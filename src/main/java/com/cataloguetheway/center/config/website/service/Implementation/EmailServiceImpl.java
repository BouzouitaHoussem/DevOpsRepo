package com.cataloguetheway.center.config.website.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.google.api.client.util.Value;

@Component
public class EmailServiceImpl {

	@Autowired
	JavaMailSender emailSender;

	public void sendSimpleMessage(String emailTo,String subject, String text) throws MailSendException {
	
	        SimpleMailMessage message = new SimpleMailMessage(); 
	        message.setFrom("ourteni73ahmed@gmail.com");
	        message.setTo(emailTo); 
	        message.setSubject(subject); 
	        message.setText(text);
	        emailSender.send(message);
	
		}

	       
		
	}
	
	

