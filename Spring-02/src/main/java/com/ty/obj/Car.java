package com.ty.obj;

public class Car {

	private String brand;

	private Engine engine;

	public void driving() {
		System.out.println("cc : " + engine.getCc());
		engine.start();
		System.out.println("Car is running in 80km/hr speed");
	}

	// getter,setter

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}
