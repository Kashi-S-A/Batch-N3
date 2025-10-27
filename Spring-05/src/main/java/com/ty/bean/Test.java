package com.ty.bean;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		ConfigurableApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);

		Student student = (Student) app.getBean("student");
		student.display();

		System.out.println("==================");

		College college = (College) app.getBean("college");
		college.admission();
	}
}
