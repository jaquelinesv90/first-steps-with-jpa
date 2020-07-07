package lesson02;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import lesson02.model.User;

public class JPQLQuery {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("Usuarios-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		firstSelect(entityManager);
		
		
		entityManager.close();
		entityManagerFactory.close();
	}

	public static void firstSelect(EntityManager entityManager) {
		String jpql = "select u from User u";
		
		TypedQuery<User> typedQuery = entityManager.createQuery(jpql, User.class);
		List<User> list = typedQuery.getResultList();
		
		//list.forEach(u -> System.out.println(u.getId() + ","+u.getName()));
		for(User u : list) {
			System.out.println(u.getId()+","+u.getName());
		}
		
	}
	
}
