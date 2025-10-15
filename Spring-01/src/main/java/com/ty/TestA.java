package com.ty;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestA {
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("config.xml");
		Person person = (Person) app.getBean("bean1");
		person.sing();

		Animal animal = (Animal) app.getBean("bean2");
		animal.sound();
	}
}
