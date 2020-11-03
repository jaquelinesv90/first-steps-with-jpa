package MapDatabaseView;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.jboss.logging.Logger;

public class TestViewEntity {
	
	Logger log = Logger.getLogger(this.getClass().getName());
	
	private EntityManagerFactory emf;
		
	public void selectFromView() {
		log.info(".. selectFromView...");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		List<BookView> bvs = em.createQuery("SELECT V FROM BookView v", BookView.class)
				.getResultList();
		
		for(BookView bv : bvs) {
			log.info(bv.getTitle() + "was written by" + bv.getAutho);
		}
		
		em.getTransaction().commit();
		em.close();
	}

}
