package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Save {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");// persistenceUnitName
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Employee employee = new Employee();
		employee.setEid(2);
		employee.setName("Smith");
		employee.setEmail("smith@gmail.com");
		employee.setSalary(55000);

		et.begin();
		em.persist(employee);
		et.commit();

		System.out.println("record saved");

	}
}
