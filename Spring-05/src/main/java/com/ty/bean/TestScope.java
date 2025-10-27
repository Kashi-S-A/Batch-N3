package com.ty.bean;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestScope {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);

		Student s1 = app.getBean(Student.class);
		System.out.println(s1);

		Student s2 = app.getBean(Student.class);
		System.out.println(s2);

		Student s3 = app.getBean(Student.class);
		System.out.println(s3);

		System.out.println("--------------------");

		College c1 = app.getBean(College.class);
		System.out.println(c1);

		College c2 = app.getBean(College.class);
		System.out.println(c2);

		College c3 = app.getBean(College.class);
		System.out.println(c3);
	}
}
