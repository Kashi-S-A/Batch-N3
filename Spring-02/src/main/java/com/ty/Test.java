package com.ty;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("config.xml");
		Person person = (Person) app.getBean("myPerson");
		person.run();
		System.out.println("Name : " + person.getName());
		System.out.println("Age : " + person.getAge());

	}
}
