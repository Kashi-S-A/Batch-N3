package com.ty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {

//	@Value("Penga")
	String name;

//	@Value("23")
	int age;

//	@Autowired
	Mobile mobile;

//	@Autowired
	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

//	@Value("Pengi")
	public void setName(String name) {
		this.name = name;
	}

//	@Value("24")
	public void setAge(int age) {
		this.age = age;
	}

	public Person(@Value("Mangi") String name, @Value("25") int age, @Autowired Mobile mobile) {
		this.name = name;
		this.age = age;
		this.mobile = mobile;
	}

	public void sing() {
		System.out.println("Person is singing");
	}

	public void display() {
		System.out.println(name);
		System.out.println(age);
	}

	public void useMobile() {
		System.out.println("Person is using mobile");
		mobile.ring();
	}
}
