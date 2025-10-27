package com.ty.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "singleton")
public class Student {

	@Value("Penga")
	String name;

	@Autowired
	List<String> subjects;

	@Autowired
	College college;

	public void display() {
		System.out.println("Name : " + name);
		college.admission();
		System.out.println("-----Subjects-----");
		for (String subject : subjects) {
			System.out.println(subject);
		}
	}
}
