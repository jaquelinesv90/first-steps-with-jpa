package lesson02;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import lesson02.model.User;

public class JPQLQuery {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("Usuarios-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//firstSelect(entityManager);
		choosingReturn(entityManager);
		
		
		
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public static void choosingReturn(EntityManager entityManager) {
		String jpql = "select u from User u";
		TypedQuery<User> typedQuery = entityManager.createQuery(jpql, User.class);
		List<User> list = typedQuery.getResultList();
		
		for(User u : list) {
			System.out.println(u.getId()+ "," + u.getName());
		}
	}
	

	public static void firstSelect(EntityManager entityManager) {
		
		String jpql = "select u from User u";
		TypedQuery<User> typedQuery = entityManager.createQuery(jpql, User.class);
		List<User> list = typedQuery.getResultList();
		//list.forEach(u -> System.out.println(u.getId() + ","+u.getName()));
		for(User u : list) {
			System.out.println(u.getId()+ "," + u.getName());
		}
		
		String jpqlSingle = "select u from User u where u.id = 1";
		TypedQuery<User> typedQuerySingle = entityManager.createQuery(jpqlSingle, User.class);
		User user = typedQuerySingle.getSingleResult();
		System.out.println(user.getId()+ "," + user.getName());
		
		
		String jpqlCast = "select u from User u where u.id = 1";
		Query query = entityManager.createQuery(jpqlCast);
		User user2 = (User)query.getSingleResult();
		System.out.println(user2.getId()+ "," + user2.getName());
		
		
	}
	
}
