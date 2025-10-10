package com.ty.annotations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Save {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		User user = new User();
		user.setName("Manga");
		user.setEmail("manga@gmail.com");
		user.setPassword("manga123");
		user.setPhone(87654567);

//		User u = em.find(User.class, 1);
//		u.setPassword("112233");
//		u.setPhone(34567890);

		et.begin();
		em.persist(user);
		et.commit();

		System.out.println("user updated");
	}
}
