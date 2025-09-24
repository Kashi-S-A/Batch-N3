package com.ty;

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

		Bank bank = new Bank();
		bank.setBid(101);
		bank.setName("SBI");
		bank.setAddress("Thane");

		Account a1 = new Account();
		a1.setAccno(121212);
		a1.setName("Dinga");
		a1.setBalance(45000);

		Account a2 = new Account();
		a2.setAccno(121312);
		a2.setName("Dingi");
		a2.setBalance(5000);

		Account a3 = new Account();
		a3.setAccno(121412);
		a3.setName("Manga");
		a3.setBalance(55000);

		List<Account> accounts = Arrays.asList(a1, a2, a3);
		
		bank.setAccounts(accounts);

		et.begin();
		em.persist(bank);
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		et.commit();

		System.out.println("saved");

	}
}
