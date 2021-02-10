package ebook.jpql.join.namedQuery;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ebook.JpaUtil;

/* Para usar uma named query, chamamos o método createNamedQuery de EntityManager na
 * classe NamedQuery.
 * 
 * namedQuery é uma consulta jpql estaticamente definida com parametros já definidos.
 * 
 */
public class NamedQuery {
	
	public static void main(String[] args) {
			
			EntityManager manager = JpaUtil.getEntityManager();
			
			TypedQuery<Vehicle> query = manager.createNamedQuery(
					"Veiculo.comProprietarioPorValor", Vehicle.class );
			
			query.setParameter("valor", new BigDecimal(10_000));
			
			List<Vehicle> vehicle = query.getResultList();
			
			for(Vehicle obj: vehicle) {
				System.out.println(obj.getModel());
			}
			
			manager.close();
			JpaUtil.close();
	}
}
