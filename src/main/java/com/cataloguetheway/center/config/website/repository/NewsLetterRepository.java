package com.cataloguetheway.center.config.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cataloguetheway.center.config.website.model.NewsLetter;



@Repository
public interface  NewsLetterRepository extends JpaRepository<NewsLetter, Long> {

}
