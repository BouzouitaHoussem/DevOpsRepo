package com.cataloguetheway.center.config.website.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cataloguetheway.center.config.website.model.WebsiteUser;



@Repository
public interface UserRepository extends JpaRepository<WebsiteUser, Integer> {
    Optional<WebsiteUser> findByEmail(String email);
    boolean existsByEmail(String email);
}
