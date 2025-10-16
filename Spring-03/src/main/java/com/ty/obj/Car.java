package com.ty.obj;

public class Car {

	String brand;

	Engine engine;

	public void driving() {
		System.out.println("cc : " + engine.cc);
		engine.start();
		System.out.println("Car is running in 80km/hr speed");
	}

	public Car(String brand, Engine engine) {
		this.brand = brand;
		this.engine = engine;
	}

}
