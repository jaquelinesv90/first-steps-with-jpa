package lesson01;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	//método main cria as instancias
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("Clientes-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		/** Busca de registro
		  
		 	Cliente cliente = entityManager.find(Cliente.class, 1);
			System.out.print(cliente.getNome());
		 */
	
		/**
		 * Inserindo um registro com persist
		 
			Cliente cliente = new Cliente();
			cliente.setId(6);
			cliente.setNome("Babi");
			entityManager.getTransaction().begin();
			entityManager.persist(cliente);
			entityManager.getTransaction().commit();
		*/
		
		/**
		 *  operações que vão alterar o banco(insert,update) precisam estar dentro de uma transação
		    só é possível remover objetos que o entityManager está ciente de que existe no banco por isso a 
		    busca antecipada,quando se utiliza o método find o entityManager coloca o objeto como gerenciado
			
			Client cliente = entityManager.find(Client.class, 1);
			entityManager.getTransaction().begin();
			entityManager.remove(cliente);
			entityManager.getTransaction().commit();
		 */
		 
		/**
		 * ao fazer duas consultas no banco(iguais) ele faz a primeira
		   e guarda em cache(na memoria, apartir daípassou a ser um objeto gerenciado)
		   quando foi buscado novamente ele retorna o que ja tem na memoria, isso é
		   chamado de cache de primeiro nivel
			
			Client cliente = entityManager.find(Client.class, 1);
			Client cliente2 = entityManager.find(Client.class, 1);
		 * 
		 */
		  /**
		   * 
		   */
		
			Client client = new Client();
			client.setId(6);
			client.setName("Babi");
			
			
		 
			 //enquanto não fechar e não limpar a memoria não será
			 //executado novamente a consulta 2,
		
		//fecha as instancias	
		entityManager.close();
		entityManagerFactory.close();
	}
	
}
