package com.tyss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
//@Profile("uat")
public class Sb02RestApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sb02RestApisApplication.class, args);
	}

}
