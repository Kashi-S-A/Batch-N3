package com.tyss;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AddSubjectToStudent {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Student student = em.find(Student.class, 101);

		if (student != null) {
			Subject sub = em.find(Subject.class, 444);

			if (sub != null) {
				List<Subject> subjects = student.getSubjects();// getting existing subject for student.
				subjects.add(sub);// adding new subject
				student.setSubjects(subjects);

				et.begin();
				em.merge(student);
				et.commit();
				System.out.println("updated");
			} else {
				System.out.println("subject not found");
			}

		} else {
			System.out.println("student not found");
		}

	}
}
