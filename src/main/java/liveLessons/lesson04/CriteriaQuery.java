package liveLessons.lesson04;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

import ebook.JpaUtil;
import ebook.jpql.projections.VehiclePrice;
import liveLessons.lesson04.model.User;


public class CriteriaQuery {
	
	public static void main(String[] args) {
		
	}
	
	public static void firstSelect(EntityManager entityManager) {
		
		EntityManager manager = JpaUtil.getEntityManager();
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
