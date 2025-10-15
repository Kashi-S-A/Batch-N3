package com.ty;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestB {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("config1.xml");
		Person person = (Person) app.getBean("PersonBean");
		person.sing();

		Animal animal = (Animal) app.getBean("myAnimal");// Exception, Animal bean is not configured
		animal.sound();
	}
}
