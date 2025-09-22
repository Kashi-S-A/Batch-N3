package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Update {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Employee employee = em.find(Employee.class, 10);

		if (employee != null) {
			employee.setSalary(80000);

			et.begin();
			em.merge(employee);
			et.commit();

			System.out.println("salary is updated");

		} else {
			System.out.println("not found");
		}

	}
}
