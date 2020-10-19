package ebook;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

// Persistencia  utilizando a anotação @ManyToOne
public class OwnerPersistence_ {
	
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Owner owner = new Owner();
		owner.setName_owner("Jurandir");
		owner.setTelephone_owner("(34) 1234-5678");
		
		manager.persist(owner);
		
		

	}
	
	
}
