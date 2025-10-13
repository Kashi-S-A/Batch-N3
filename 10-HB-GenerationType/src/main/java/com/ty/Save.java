package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Save {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Product product = new Product();
		product.setName("Samsung");
		product.setDescription("16GB RAM | 256GM ROM, white color");
		product.setCategory("mobile");
		product.setPrice(150000);

		et.begin();
		em.persist(product);
		et.commit();

//		System.out.println("saved");

//		Product product = em.find(Product.class, 1);
//
//		if (product != null) {
//			product.setPrice(250000);
//
//			et.begin();
//			et.commit();
//
//			System.out.println("update");
//		} else {
//			System.out.println("Not found");
//		}
	}
}
