package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction et = em.getTransaction();
//
//		Author author = new Author();
//		author.setId(111);
//		author.setName("Robin Sharma");
//		author.setPhone(87654567);
//
//		Book b1 = new Book();
//		b1.setId(101);
//		b1.setName("5am Club");
//		b1.setPrice(399);
//		b1.setAuthor(author);
//
//		Book b2 = new Book();
//		b2.setId(102);
//		b2.setName("The Atomatic Habits");
//		b2.setPrice(299);
//		b2.setAuthor(author);
//
//		Book b3 = new Book();
//		b3.setId(103);
//		b3.setName("The monk who sold his ferrari");
//		b3.setPrice(599);
//		b3.setAuthor(author);
//
//		et.begin();
//		em.persist(author);
//		em.persist(b1);
//		em.persist(b2);
//		em.persist(b3);
//		et.commit();

		System.out.println("saved");

	}
}
