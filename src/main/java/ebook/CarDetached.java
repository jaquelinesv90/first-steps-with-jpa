package ebook;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/*
	Objetos desanexados
São objetos em um estado que não é gerenciado pelo EntityManager,mas ainda representam entidades no banco.
As alterações em objetos desanexados não são sincronizadas com o banco de dados.Utilizamos objetos desanexados, por exemplo,
quando eles são expostos para alteração através de páginas web e apenas em um segundo momento o usuário solicita a 
gravação das alterações do objeto.
*/
public class CarDetached {
	
	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Vehicle vehicle = manager.find(Vehicle.class,1L);
		
		tx.commit();
		manager.close();
		
		// essa alteração não será sincronizada
		vehicle.setValue(new BigDecimal(112_000));
		
		JpaUtil.close();
		
	}
		
	
	
	
}
