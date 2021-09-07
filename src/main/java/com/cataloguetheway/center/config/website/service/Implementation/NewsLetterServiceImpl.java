package com.cataloguetheway.center.config.website.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cataloguetheway.center.config.website.model.NewsLetter;
import com.cataloguetheway.center.config.website.repository.NewsLetterRepository;


@Service
public class NewsLetterServiceImpl  {

	@Autowired
	NewsLetterRepository newsLetterRepository;
	
	
	public String addNewsLetter(String email) {
		NewsLetter newsLetter = new NewsLetter();
		newsLetter.setEmail(email);
		return newsLetterRepository.save(newsLetter).getEmail();
	}

	
}
