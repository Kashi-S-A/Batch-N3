package com.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchAll {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("select e from Employee e");

//		Query query = em.createQuery("select e from Employee e where e.name=?1");//index based parameter
//		query.setParameter(1, "Tiger");

//		Query query = em.createQuery("select e from Employee e where e.name=:empName");//naming based parameter
//		query.setParameter("empName", "Tiger");

//		Query query = em.createQuery("select e from Employee e where e.name=?1 and e.salary=?2");// index based
//		query.setParameter(1, "Tiger");
//		query.setParameter(2, 95000.0);

		List<Employee> employees = query.getResultList();

		System.out.println("============Employees=============");
		for (Employee employee : employees) {
			System.out.println(employee.getEid());
			System.out.println(employee.getName());
			System.out.println(employee.getEmail());
			System.out.println(employee.getSalary());
			System.out.println("--------------------------------");
		}

	}
}