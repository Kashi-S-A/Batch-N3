package com.tyss.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String toEmail, String subject, String body) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(toEmail);
		message.setSubject(subject);
		message.setText(body);

		javaMailSender.send(message);
	}
	
	
	@Autowired
	private TemplateEngine engine;
	
	public void sendMailWithTemplate(String toEmail,String subject, String username) throws MessagingException {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message,true);// to add attachements
		
		Context context = new Context();
		context.setVariable("username", username);
		
		String body = engine.process("welcome-email", context);
		
		helper.setTo(toEmail);
		helper.setSubject(subject);
		helper.setText(body, true);//true -> in body html code is present
		
		helper.addAttachment("sb-notes", new File("C:\\Users\\asus\\Downloads\\gameoflifehowtop00shin.pdf"));
		
		javaMailSender.send(message);
	}
}
