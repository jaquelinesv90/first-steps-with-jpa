package ebook;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

//O codigo busca o veículo de valor 1
// A alteração foi identificada automaticamente e 
// refletida no banco através do comando update
public class CarUpdating {
	
	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Vehicle vehicle = manager.find(Vehicle.class, 1L);
		
		System.out.println("current value:" + vehicle.getValue());
		vehicle.setValue(vehicle.getValue().add(new BigDecimal(500)));
		System.out.println("new value:" + vehicle.getValue());
		
		tx.commit();
		manager.close();
		JpaUtil.close();
	}
}
