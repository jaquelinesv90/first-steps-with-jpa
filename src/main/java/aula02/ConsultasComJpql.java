package aula02;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConsultasComJpql {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("Clientes-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		primeiraConsulta(entityManager);
		
		
		entityManager.close();
		entityManagerFactory.close();
	}

	public static void primeiraConsulta(EntityManager entityManager) {
		System.out.println("entrou");
	}
	
}
