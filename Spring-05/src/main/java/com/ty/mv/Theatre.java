package com.ty.mv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Theatre {

	@Value("Sangam")
	String name;

	@Value("Thane")
	String address;

//	@Autowired
//	@Qualifier(value = "chaava")
	Movie movie;

//	@Autowired
//	@Qualifier(value = "chaava")
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Autowired
	public Theatre(@Qualifier(value = "chaava") Movie movie) {
		this.movie = movie;
	}

	public void play() {
		System.out.println("Welcome to " + name + " Theatre");
		System.out.println("Address : " + address);
		System.out.println("Movie is : " + movie.getClass().getName());
		movie.story();
	}
}
