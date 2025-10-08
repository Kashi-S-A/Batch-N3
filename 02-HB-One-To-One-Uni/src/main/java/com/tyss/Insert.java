package com.tyss;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Car car = new Car();
		car.setCid(103);
		car.setBrand("TATA");
		car.setPrice(2500000);

		Engine engine = new Engine();
		engine.setEid(333);
		engine.setCc(1000);

		car.setEngine(engine);// FK relation will be established

		et.begin();
		em.persist(car);
//		em.persist(engine);
		et.commit();

		System.out.println("saved");

	}
}
