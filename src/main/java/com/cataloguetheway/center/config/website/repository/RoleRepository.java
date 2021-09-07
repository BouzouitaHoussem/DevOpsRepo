package com.cataloguetheway.center.config.website.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cataloguetheway.center.config.website.model.Role;
import com.cataloguetheway.center.config.website.util.RoleNumber;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleNumber(RoleNumber roleNumber);
    boolean existsByRoleNumber(RoleNumber roleNumber);
}
