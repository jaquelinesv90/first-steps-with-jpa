package ebook.concurrency;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ebook.JpaUtil;

public class ConcurrencyTransaction {
	
	EntityManager manager1 = JpaUtil.getEntityManager();
	EntityTransaction tx1 = manager1.getTransaction();
	
	
	
	

}
