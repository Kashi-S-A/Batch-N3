package com.ty.read;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
	@Value(value = "${user_secret}")
	private String secret;
	@Value(value = "${user_name}")
	private String username;

	public void display() {
		System.out.println("secret : " + secret);
		System.out.println("username : " + username);
	}
}
