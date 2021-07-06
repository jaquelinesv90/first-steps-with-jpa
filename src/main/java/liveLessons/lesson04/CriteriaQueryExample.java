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
	
	//CriteriaQuery é a instancia que contém as clausulas
	//CriteriaBuilder nos ajuda a construir nossa query
	public static void main(String[] args) {
		
	}
	
	public static void paginandoResultados(EntityManager entityManager) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		// o Root é equivalente ao alias - select u from User u
		Root<User> root = criteriaQuery.from(User.class);
		
		criteriaQuery.select(root);
		
		
		TypedQuery<User> typedQuery = entityManager.createQuery(criteriaQuery)
				.setFirstResult(0) // PRIMEIRO = (PAGINA - 1) * QTDE_PA
				.setMaxResults(2);
		
		List<User> list = typedQuery.getResultList();
		//list.forEach(u -> System.out.println(u.getId() + ","+u.getName()));
		for(User u : list) {
			System.out.println(u.getId()+ "," + u.getName());
		}
	}
	
	// A instancia do criteriaBuilder nos ajuda a passar parametros para 
	// os métodos que são referentes as clausulas do sql como por ex: order by
	public static void orderingResults(EntityManager entityManager) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		// o Root é equivalente ao alias - select u from User u
		Root<User> root = criteriaQuery.from(User.class);
		
		//clausulas como por exemplo order by, a gente utiliza apartir da instancia
		// do criteria query 
		// nome é a propriedade pela qual será ordenada a consulta
		criteriaQuery.select(root);
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("nome")));
		
		TypedQuery<User> typedQuery = entityManager.createQuery(criteriaQuery);
		List<User> list = typedQuery.getResultList();
		//list.forEach(u -> System.out.println(u.getId() + ","+u.getName()));
	}
	
	
	public static void passParameter(EntityManager entityManager) {
		//passagem de parametros por -  id/
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		// o Root é equivalente ao alias - select u from User u
		Root<User> root = criteriaQuery.from(User.class);
		
		criteriaQuery.select(root);
		//vai trazer o usuario de identificador 1
		criteriaQuery.where(criteriaBuilder.equal(root.get("id"), 1));
		
		TypedQuery<User> typedQuery = entityManager.createQuery(criteriaQuery);
		User user = typedQuery.getSingleResult();
		//list.forEach(u -> System.out.println(u.getId() + "," + u.getNome()));	
		
		///////////passagem de parametros por -  login
		CriteriaBuilder criteriaBuilder2 = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<User> criteriaQuery2 = criteriaBuilder2.createQuery(User.class);
		// o Root é equivalente ao alias - select u from User u
		Root<User> root2 = criteriaQuery.from(User.class);
		
		criteriaQuery2.select(root2);
		criteriaQuery2.where(criteriaBuilder.equal(root.get("login"), "ria"));
		
		TypedQuery<User> typedQuery2 = entityManager.createQuery(criteriaQuery2);
		User user2 = typedQuery2.getSingleResult();
		//list.forEach(u -> System.out.println(u.getId() + "," + u.getNome()));	
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
