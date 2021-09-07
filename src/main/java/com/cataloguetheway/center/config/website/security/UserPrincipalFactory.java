package com.cataloguetheway.center.config.website.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.cataloguetheway.center.config.website.model.WebsiteUser;





public class UserPrincipalFactory {
    public static CustomUserPrincipal build(WebsiteUser user){
        List<GrantedAuthority> authorities =
        		user.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRoleNumber().name())).collect(Collectors.toList());
        return new CustomUserPrincipal(user.getEmail(), user.getPassword(), authorities);
    }
}
