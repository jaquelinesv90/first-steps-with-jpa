package liveLessons.lesson04;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import liveLessons.lesson04.dto.UserDto;
import liveLessons.lesson04.model.User;


public class CriteriaQueryExample {
	
	public static void main(String[] args) {
		
	}
	
	public static void makingProjections(EntityManager entityManager) {
	   /*	
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
		// o Root é equivalente ao alias - select u from User u
		Root<User> root = criteriaQuery.from(User.class);
		
		//aqui eu digo, pegue a propriedade dominio(control) do usuario
		criteriaQuery.multiselect(root.get("control"));
		
		TypedQuery<Object[]> typedQuery = entityManager.createQuery(criteriaQuery);
		List<Object[]> list = typedQuery.getResultList();
		//list.forEach(arr -> System.out.println(String.format("%s,%s,%s",arr));
		 */
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<UserDto> criteriaQuery = criteriaBuilder.createQuery(UserDto.class);
		Root<User> root = criteriaQuery.from(User.class);
		//foi usado o criteriaBuilder método construct pois preciso de um tipo especifico
		criteriaQuery.multiselect(criteriaBuilder.construct(UserDto.class,
				root.get("id"), root.get("login"),root.get("name")));
		
		TypedQuery<UserDto> typedQuery = entityManager.createQuery(criteriaQuery);
		List<UserDto> list = typedQuery.getResultList();
		//list.forEach(arr -> System.out.println(String.format("%s,%s,%s",arr));
		
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
		
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		// o Root é equivalente ao alias - select u from User u
		Root<User> root = criteriaQuery.from(User.class);
		
		//aqui eu digo, pegue a propriedade dominio(control) do usuario
		criteriaQuery.multiselect(root.get("control"));
		
		TypedQuery<String> typedQuery = entityManager.createQuery(criteriaQuery);
		List<String> list = typedQuery.getResultList();
		//list.forEach(nome -> System.out.println("nome:" + nome));
		for(String nome : list) {
			System.out.println(nome);
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
