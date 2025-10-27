package com.ty.mv;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class Kantara implements Movie {
	@Override
	public void story() {
		System.out.println("Story of Guliga");
	}

}
