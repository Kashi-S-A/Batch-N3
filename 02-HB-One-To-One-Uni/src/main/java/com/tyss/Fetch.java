package com.tyss;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Fetch {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Car car = em.find(Car.class, 102);

		if (car != null) {
			System.out.println("=========Car===========");
			System.out.println(car.getCid());
			System.out.println(car.getBrand());
			System.out.println(car.getPrice());

			Engine engine = car.getEngine();
			System.out.println("======Engine=======");
			System.out.println(engine.getEid());
			System.out.println(engine.getCc());

		} else {
			System.out.println("not found");
		}

	}
}
