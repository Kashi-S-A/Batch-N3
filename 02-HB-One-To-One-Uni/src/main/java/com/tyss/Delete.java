package com.tyss;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Delete {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Engine engine = em.find(Engine.class, 222);

		if (engine != null) {

			et.begin();
			// fetch car and setEngine as null
			// update car
			// remove engine
			em.remove(engine);
			et.commit();

			System.out.println("engine deleted");
		} else {
			System.out.println("not found");
		}

	}
}
