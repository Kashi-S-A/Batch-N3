package com.ty.list;

import java.util.List;

public class Student {

	String name;
	List<String> subjects;

	public void display() {
		System.out.println("Name : " + name);
		System.out.println("Subjects : " + subjects);
	}

	public Student(String name, List<String> subjects) {
		this.name = name;
		this.subjects = subjects;
	}

}
