package ebook.cascadePersistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ebook.JpaUtil;

public class CascadePersistence {
	
	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Category category = new Category();
		category.setName("clothes");
		
		Product product = new Product();
		product.setName("t-shirt");
		product.setCategory(category);
		
		manager.persist(product);
		
		tx.commit();
		manager.close();
		JpaUtil.close();
	}

}
