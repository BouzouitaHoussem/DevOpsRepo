package com.cataloguetheway.center.config.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cataloguetheway.center.config.website.controller.request.SignInRequest;
import com.cataloguetheway.center.config.website.controller.request.SignUpRequest;
import com.cataloguetheway.center.config.website.controller.response.SignInResponse;
import com.cataloguetheway.center.config.website.controller.response.SignUpResponse;
import com.cataloguetheway.center.config.website.dto.UserDto;
import com.cataloguetheway.center.config.website.dto.mapper.SignUpRequestToUserDtoMapper;
import com.cataloguetheway.center.config.website.security.jwt.JwtProvider;
import com.cataloguetheway.center.config.website.service.Implementation.WebsiteUserServiceImpl;




@CrossOrigin
@RestController
public class WebsiteUserController {
	@Autowired
	WebsiteUserServiceImpl userService;
	@Autowired
	SignUpRequestToUserDtoMapper signUpRequestToUserDtoMapper;

	@Autowired
	AuthenticationManager authenticationManager;
	
    @Autowired
    JwtProvider jwtProvider;
	 
	@Autowired
	UserDetailsService userDetailsService;

	/* signup api */

	@PostMapping(value = "/signup")
	public SignUpResponse signUp(@RequestBody SignUpRequest signupRequest) {
		if (userService.existsEmail(signupRequest.getEmail())) {
			return new SignUpResponse("This Email is already being used",false);
		} else {
			UserDto userDto = signUpRequestToUserDtoMapper.MapSignUpRequestToUserDto(signupRequest);
			userService.save(userDto);
			return new SignUpResponse("Registraion completed successfully",true);
		}
	}

	/* Login api */

	@PostMapping(value = "/signin")
	public SignInResponse signIn(@RequestBody SignInRequest signinRequest) {
		try {
			Authentication authentication =authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(signinRequest.getEmail(), signinRequest.getPassword()));
			final String jwt =   jwtProvider.generateToken(authentication);
			final UserDetails user = userDetailsService.loadUserByUsername(signinRequest.getEmail());
			return new SignInResponse(jwt,true);
		} catch (BadCredentialsException e) {
			return new SignInResponse("Check your credentials!",false);
		}
		
		
	}
	
	/* hi api */
	@GetMapping(value="/hi")
	public String  HiApi() {
		return "<h1>HI</h1>";
	}

}
