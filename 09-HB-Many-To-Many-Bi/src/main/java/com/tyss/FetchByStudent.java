package com.tyss;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchByStudent {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Student student = em.find(Student.class, 102);

		if (student != null) {
			System.out.println("=========Student============");
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getPhone());

			List<Subject> subjects = student.getSubjects();

			System.out.println("=========Subjects========");
			for (Subject subject : subjects) {
				System.out.println(subject.getId());
				System.out.println(subject.getName());
				System.out.println(subject.getDays());
				System.out.println("----------------------");
			}

		} else {
			System.out.println("student not found");
		}
	}
}
