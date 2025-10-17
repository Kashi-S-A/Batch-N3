package com.ty;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new ClassPathXmlApplicationContext("config.xml");

		Person person = (Person) app.getBean("person");
		person.study();
		person.displayPerson();

		System.out.println("=================================");

		BankAccount ba = (BankAccount) app.getBean("bankAccount");
		ba.deposit();
		ba.displayBank();

		System.out.println("=================================");

		RCB rcb = (RCB) app.getBean("myRCB");
		rcb.play();
		rcb.displayRCB();
	}
}
