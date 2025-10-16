package com.ty.map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new ClassPathXmlApplicationContext("config3.xml");

		Shop shop = (Shop) app.getBean("shopbean");
		shop.display();
	}
}
