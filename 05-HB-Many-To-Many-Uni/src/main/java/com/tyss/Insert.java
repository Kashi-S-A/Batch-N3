package com.tyss;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Student student = new Student();
		student.setId(101);
		student.setName("Dinga");
		student.setPhone(34567876);

		Subject sub1 = new Subject();
		sub1.setId(111);
		sub1.setName("Java");
		sub1.setDays(60);

		Subject sub2 = new Subject();
		sub2.setId(222);
		sub2.setName("Spring");
		sub2.setDays(65);

		Subject sub3 = new Subject();
		sub3.setId(333);
		sub3.setName("SQL");
		sub3.setDays(30);

		List<Subject> subjects = Arrays.asList(sub1, sub2, sub3);

		student.setSubjects(subjects);

		et.begin();
		em.persist(student);
		em.persist(sub1);
		em.persist(sub2);
		em.persist(sub3);
		et.commit();

		System.out.println("saved");

	}
}
