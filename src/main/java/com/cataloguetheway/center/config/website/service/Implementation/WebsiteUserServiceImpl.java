package com.cataloguetheway.center.config.website.service.Implementation;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cataloguetheway.center.config.website.dto.UserDto;
import com.cataloguetheway.center.config.website.dto.mapper.UserDtoToUserMapper;
import com.cataloguetheway.center.config.website.model.WebsiteUser;
import com.cataloguetheway.center.config.website.repository.UserRepository;




@Service
public class WebsiteUserServiceImpl {

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    UserDtoToUserMapper userDtoToUserMapper;

    public Optional<WebsiteUser> getByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public boolean existsEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public WebsiteUser save(WebsiteUser user){
        return userRepository.save(user);
    }
    
    public WebsiteUser save(UserDto userDto){
    	WebsiteUser user =new WebsiteUser();
    	user=userDtoToUserMapper.mapUserDtoToUser(userDto);
        return userRepository.save(user);
    }
}
