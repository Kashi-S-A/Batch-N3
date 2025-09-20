package com.ty;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Save {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		// load the driver
		// connection
		// table creation

		System.out.println("Done");
	}
}
