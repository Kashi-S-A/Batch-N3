package com.ty.annotations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Fetch {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em1 = emf.createEntityManager();

		System.out.println("=================EM1=====================");
		User u1 = em1.find(User.class, 50);
		System.out.println(u1);

		System.out.println("-------------------------------");

		User u2 = em1.find(User.class, 50);
		System.out.println(u2);

		System.out.println("-------------------------------");

		User u3 = em1.find(User.class, 60);
		System.out.println(u3);

		System.out.println("***********************************");

		EntityManager em2 = emf.createEntityManager();

		System.out.println("=================EM2=====================");
		User u4 = em2.find(User.class, 50);
		System.out.println(u4);

		System.out.println("-------------------------------");

		User u5 = em2.find(User.class, 50);
		System.out.println(u5);

		System.out.println("-------------------------------");

		User u6 = em2.find(User.class, 60);
		System.out.println(u6);
	}
}
