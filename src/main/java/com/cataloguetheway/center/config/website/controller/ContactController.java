package com.cataloguetheway.center.config.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cataloguetheway.center.config.website.controller.response.ContactEmailResponse;
import com.cataloguetheway.center.config.website.dto.EmailDto;
import com.cataloguetheway.center.config.website.service.Implementation.EmailServiceImpl;




@RestController
@CrossOrigin
public class ContactController {
	
	@Autowired
	EmailServiceImpl emailService;
	@Value("${emailRecipient}")
	String emailTo;
	@PostMapping(value="/send-email")
	public ResponseEntity<ContactEmailResponse> SendEmail(@RequestBody EmailDto  emailContent){
		try {
			String subject = "Message From The way Platform"; 
			String text ="Email: "+emailContent.getEmail()+"\n"+"Name: "+emailContent.getName()+"\n"+emailContent.getText();
			emailService.sendSimpleMessage(emailTo,subject,text);
		}catch(Exception e) {
			e.printStackTrace();
			ContactEmailResponse emailResponseFailed = new ContactEmailResponse("Oops somthing went wrong! try again please",false);
			return new ResponseEntity(emailResponseFailed,HttpStatus.OK);
		}
		 
		
		ContactEmailResponse emailResponseSucceded = new ContactEmailResponse("email sent successfully",true);
			return new ResponseEntity(emailResponseSucceded,HttpStatus.OK);
		
			
		
		
	}

}
