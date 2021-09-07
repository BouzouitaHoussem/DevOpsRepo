package com.cataloguetheway.center.config.website.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cataloguetheway.center.config.website.dto.TokenDto;
import com.cataloguetheway.center.config.website.model.Role;
import com.cataloguetheway.center.config.website.model.WebsiteUser;
import com.cataloguetheway.center.config.website.security.jwt.JwtProvider;
import com.cataloguetheway.center.config.website.service.Implementation.RoleService;
import com.cataloguetheway.center.config.website.service.Implementation.WebsiteUserServiceImpl;
import com.cataloguetheway.center.config.website.util.RoleNumber;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;



@RestController
@RequestMapping("/oauth")
@CrossOrigin
public class OauthController {

    @Value("${google.clientId}")
    String googleClientId;

    @Value("${secretPsw}")
    String secretPsw;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    WebsiteUserServiceImpl userService;

    @Autowired
    RoleService rolService;



    @PostMapping("/google")
    public ResponseEntity<TokenDto> google(@RequestBody TokenDto tokenDto) throws IOException {
        final NetHttpTransport transport = new NetHttpTransport();
        final JacksonFactory jacksonFactory = JacksonFactory.getDefaultInstance();
        GoogleIdTokenVerifier.Builder verifier =
                new GoogleIdTokenVerifier.Builder(transport, jacksonFactory)
                .setAudience(Collections.singletonList(googleClientId));
        final GoogleIdToken googleIdToken = GoogleIdToken.parse(verifier.getJsonFactory(), tokenDto.getValue());
        final GoogleIdToken.Payload payload = googleIdToken.getPayload();
        WebsiteUser user = new WebsiteUser();
        if(userService.existsEmail(payload.getEmail()))
        	user = userService.getByEmail(payload.getEmail()).get();
        else
        	user = saveUser(payload.getEmail());
        TokenDto tokenRes = login(user);
        return new ResponseEntity(tokenRes, HttpStatus.OK);
    }

    @PostMapping("/facebook")
    public ResponseEntity<TokenDto> facebook(@RequestBody TokenDto tokenDto) throws IOException {
        Facebook facebook = new FacebookTemplate(tokenDto.getValue());
        final String [] fields = {"email", "picture"};
        WebsiteUser user = facebook.fetchObject("me", WebsiteUser.class, fields);
        WebsiteUser usuario = new WebsiteUser();
        if(userService.existsEmail(user.getEmail()))
            usuario = userService.getByEmail(user.getEmail()).get();
        else
            usuario = saveUser(user.getEmail());
        TokenDto tokenRes = login(usuario);
        return new ResponseEntity(tokenRes, HttpStatus.OK);
    }

    private TokenDto login(WebsiteUser user){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), secretPsw)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        TokenDto tokenDto = new TokenDto();
        tokenDto.setValue(jwt);
        return tokenDto;
    }

    private WebsiteUser saveUser(String email){
    	WebsiteUser user = new WebsiteUser(email, passwordEncoder.encode(secretPsw));
        Role rolUser = new Role(RoleNumber.ROLE_USER);
        rolService.save(rolUser);
        Set<Role> roles = new HashSet<>();
        roles.add(rolUser);
        user.setRoles(roles);
        return userService.save(user);
    }

}