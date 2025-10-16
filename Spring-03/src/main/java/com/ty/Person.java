package com.ty;

public class Person {

	String name;
	int age;

	public void display() {
		System.out.println("Name : " + name);
		System.out.println("Age : " + age);
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

}
