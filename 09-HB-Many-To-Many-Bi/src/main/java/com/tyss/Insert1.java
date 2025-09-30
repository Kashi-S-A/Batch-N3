package com.tyss;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Insert1 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Student student = new Student();
		student.setId(102);
		student.setName("Dingi");
		student.setPhone(76543455);

		Subject java = em.find(Subject.class, 111);

		Subject spring = em.find(Subject.class, 222);

		Subject web = new Subject();
		web.setId(444);
		web.setName("WebTech");
		web.setDays(30);

		List<Subject> subjects = Arrays.asList(java, spring, web);

		student.setSubjects(subjects);

		et.begin();
		em.persist(student);
		em.persist(web);
		et.commit();

		System.out.println("saved");

	}
}
