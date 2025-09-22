package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Fetch {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Employee employee = em.find(Employee.class, 3);

		if (employee != null) {
			System.out.println("eid : " + employee.getEid());
			System.out.println("name : " + employee.getName());
			System.out.println("email : " + employee.getEmail());
			System.out.println("salary : " + employee.getSalary());
		} else {
			System.out.println("not found");
		}

	}
}
