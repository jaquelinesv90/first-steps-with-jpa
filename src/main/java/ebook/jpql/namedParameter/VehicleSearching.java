package ebook.jpql.namedParameter;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ebook.JpaUtil;
import ebook.Vehicle;

/* Se você precisar fazer uma consulta filtrando por valores informados
 * pelo usuário, não é recomendado que faça concatenações na string da consulta,
 * principalmente para evitar SQL Injection. O ideal é usar parâmetros da Query.
 * 
 * Nomeamos os parâmetros com um prefixo : e vinculamos os valores para cada
 * parametro usando o método setParameter de Query.
 */
public class VehicleSearching {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		Query query = manager.createQuery(
				"select v from Vehicle v where yearManufacture >= :year " +
				" and value <= :price");
		query.setParameter("year", 2020);
		query.setParameter("price", new BigDecimal(107_000));
		
		List vehicles = query.getResultList();
		
		for(Object obj: vehicles) {
			Vehicle vehicle = (Vehicle) obj;
			
			System.out.println(vehicle.getModel() +" "+ vehicle.getManufacturer());
		}
		
		manager.close();
		JpaUtil.close();
	}
}
