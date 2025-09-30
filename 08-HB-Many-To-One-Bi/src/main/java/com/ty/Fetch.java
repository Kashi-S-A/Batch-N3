package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Fetch {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Book book = em.find(Book.class, 101);

		if (book != null) {
			System.out.println("===========Book=========");
			System.out.println(book.getId());
			System.out.println(book.getName());
			System.out.println(book.getPrice());

			Author author = book.getAuthor();

			System.out.println("=========Author=========");
			System.out.println(author.getId());
			System.out.println(author.getName());
			System.out.println(author.getPhone());
		} else {
			System.out.println("Book not found");
		}

	}
}
