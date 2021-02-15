package ebook.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ebook.JpaUtil;
import ebook.Vehicle;

/* A consulta busca todos os veículos cadastrados e imprime o modelo deles.
 * Seria o mesmo que fazer em JPQL: select v from Veiculo v
 * 
 * Primeiramente, pegamos uma instância do tipo CriteriaBuilder do 
 */
public class VehicleSearching {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Vehicle> criteriaQuery = builder.createQuery(Vehicle.class);
		
		Root<Vehicle> vehicle = criteriaQuery.from(Vehicle.class);
		criteriaQuery.select(vehicle);
		
		TypedQuery<Vehicle> query = manager.createQuery(criteriaQuery);
		List<Vehicle> vehicles = query.getResultList();
		
		for(Vehicle v : vehicles) {
			System.out.println(v.getModel());
		}
		
		manager.close();
		JpaUtil.close();
	}
}
