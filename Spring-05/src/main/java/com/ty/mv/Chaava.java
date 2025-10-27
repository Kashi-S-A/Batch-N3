package com.ty.mv;

import org.springframework.stereotype.Component;

@Component
public class Chaava implements Movie {

	@Override
	public void story() {
		System.out.println("Story of Sambhaji maharaj");
	}

}
