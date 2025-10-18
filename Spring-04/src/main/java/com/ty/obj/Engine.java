package com.ty.obj;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Engine {

	@Value("700")
	int cc;

	public void start() {
		System.out.println("Engine started");
	}
}
