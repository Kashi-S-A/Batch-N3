package com.ty.obj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {

	@Value("Mercedes")
	String brand;

//	@Autowired	//field or variable injection
	Engine engine;

//	@Autowired // setter injection.
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Autowired // constructor injection
	public Car(Engine engine) {
		this.engine = engine;
	}

	public void drive() {
		System.out.println(brand);
		System.out.println(engine.cc);
		engine.start();
		System.out.println("Car is running in Hight speed");
	}
}
