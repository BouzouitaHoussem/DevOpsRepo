package com.cataloguetheway.center.config.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cataloguetheway.center.config.website.model.Contacts;



@Repository
public interface ContactsRepository extends JpaRepository<Contacts, Long> {

}
