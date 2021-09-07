package com.cataloguetheway.center.config.website.service.Implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cataloguetheway.center.config.website.model.Role;
import com.cataloguetheway.center.config.website.repository.RoleRepository;
import com.cataloguetheway.center.config.website.util.RoleNumber;



@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Optional<Role> getByRolNombre(RoleNumber rolNombre){
        return roleRepository.findByRoleNumber(rolNombre);
    }

    public boolean existsRolNombre(RoleNumber rolNombre){
        return roleRepository.existsByRoleNumber(rolNombre);
    }

    public void save(Role rol){
    	roleRepository.save(rol);
    }
}
