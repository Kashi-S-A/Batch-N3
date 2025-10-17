package com.ty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {

	@Value("Penga") // field/variable injection
	String name;

	@Value("34")
	int age;

	public void study() {
		System.out.println("Person is studying news paper");
	}

	public void displayPerson() {
		System.out.println("Name : " + name);
		System.out.println("Age : " + age);
	}
}
