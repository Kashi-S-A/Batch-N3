package com.tyss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.service.EmailService;

import jakarta.mail.MessagingException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;

	@GetMapping("/email")
	public String sendEmail(@RequestParam String toEmail) {

		String subject = "Thank you for Registration";

		String body = "Greetings!!!!!!  Your account has been registered in our Spring Boot classes, Enjoy the sessions and learn buidling robust applications";

		emailService.sendEmail(toEmail, subject, body);

		return "Email Sent successfully to :" + toEmail;
	}
	
	@GetMapping("/temp")
	public String sendEmailTemplate(@RequestParam String toEmail,@RequestParam String name) throws MessagingException {

		String subject = "Thank you for Registration";

		emailService.sendMailWithTemplate(toEmail, subject, name);
		
		return "Email with template Sent successfully to :" + toEmail;
	}

}
