package com.ty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "myRCB")
public class RCB {

	String state;

	String capt;

	public RCB(@Value("Karnataka") String state, @Value("Rajat Patidar") String capt) {
		this.state = state;
		this.capt = capt;
	}

	public void displayRCB() {
		System.out.println("State : " + state);
		System.out.println("Captain : " + capt);
	}

	public void play() {
		System.out.println("Play to win");
	}
}
