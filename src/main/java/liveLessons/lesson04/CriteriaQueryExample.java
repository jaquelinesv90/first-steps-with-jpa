package liveLessons.lesson04;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import liveLessons.lesson04.model.Control;
import liveLessons.lesson04.model.User;


public class CriteriaQueryExample {
	
	public static void main(String[] args) {
		
	}
	
	public static void choosingReturn(EntityManager entityManager) {
		/*
		 * Exemplo utilizando um  dominio
		 *
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Control> criteriaQuery = criteriaBuilder.createQuery(Control.class);
		// o Root é equivalente ao alias - select u from User u
		Root<User> root = criteriaQuery.from(User.class);
		
		//aqui eu digo, pegue a propriedade dominio(control) do usuario
		criteriaQuery.multiselect(root.get("control"));
		
		TypedQuery<Control> typedQuery = entityManager.createQuery(criteriaQuery);
		List<Control> list = typedQuery.getResultList();
		//list.forEach(u -> System.out.println(u.getId() + ","+u.getName()));
		for(Control c : list) {
			System.out.println(c.getId()+ "," + c.getName());
		}
		*/
		
		//Exemplo utilizando uma propriedade
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Control> criteriaQuery = criteriaBuilder.createQuery(Control.class);
		// o Root é equivalente ao alias - select u from User u
		Root<User> root = criteriaQuery.from(User.class);
		
		//aqui eu digo, pegue a propriedade dominio(control) do usuario
		criteriaQuery.multiselect(root.get("control"));
		
		TypedQuery<Control> typedQuery = entityManager.createQuery(criteriaQuery);
		List<Control> list = typedQuery.getResultList();
		//list.forEach(u -> System.out.println(u.getId() + ","+u.getName()));
		for(Control c : list) {
			System.out.println(c.getId()+ "," + c.getName());
		}
		
	}
	
	// Utilizar o criteria segundo a documentação é mais performatico que utilizar
	// jpql dinamico
	public static void firstSelect(EntityManager entityManager) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		// o Root é equivalente ao alias - select u from User u
		Root<User> root = criteriaQuery.from(User.class);
		
		criteriaQuery.select(root);
		
		TypedQuery<User> typedQuery = entityManager.createQuery(criteriaQuery);
		List<User> list = typedQuery.getResultList();
		//list.forEach(u -> System.out.println(u.getId() + ","+u.getName()));
		for(User u : list) {
			System.out.println(u.getId()+ "," + u.getName());
		}
	}

}
