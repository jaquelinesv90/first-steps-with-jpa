package ebook.jpql.typedQueries;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ebook.JpaUtil;
import ebook.Vehicle;

/*  Quando fazemos uma consulta, podemos obter o resultado de um tipo especifico,
 * sem precisar fazer casting dos objetos ou até mesmo conversões não checadas 
 * para coleções genéricas.
 * 
 */
public class VehicleSearching {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		TypedQuery<Vehicle> query = manager.createQuery(
				"select v from Vehicle v", Vehicle.class);
		List<Vehicle> vehicles = query.getResultList();
		
		for(Vehicle obj: vehicles) {
			Vehicle vehicle = (Vehicle) obj;
			
			System.out.println(vehicle.getModel() +" "+ vehicle.getManufacturer());
		}
		
		manager.close();
		JpaUtil.close();
	}
}
