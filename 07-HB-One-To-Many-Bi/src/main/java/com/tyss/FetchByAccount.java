package com.tyss;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchByAccount {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Account account = em.find(Account.class, 121212);

		if (account != null) {
			System.out.println("==========Account============");
			System.out.println(account.getAccno());
			System.out.println(account.getName());
			System.out.println(account.getBalance());

			Bank bank = account.getBank();

			System.out.println("========bank=========");
			System.out.println(bank.getBid());
			System.out.println(bank.getName());
			System.out.println(bank.getAddress());

		} else {
			System.out.println("account not found");
		}
	}
}
