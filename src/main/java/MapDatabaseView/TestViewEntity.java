package MapDatabaseView;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jboss.logging.Logger;

public class TestViewEntity {
	
	public static void main(String[] args) {
		TestViewEntity t = new TestViewEntity();
		t.selectFromView();
	}
	
	Logger log = Logger.getLogger(this.getClass().getName());
	
	private EntityManagerFactory emf;
		
	public void selectFromView() {
		log.info(".. selectFromView...");
		emf = Persistence.createEntityManagerFactory("Usuarios-PU");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		List<OwnerView> bvs = em.createQuery("SELECT V FROM VIEW_OWNER v", OwnerView.class)
				.getResultList();
		
		for(OwnerView ov : bvs) {
			log.info("sucess name:" + ov.getName());
		}
		
		em.getTransaction().commit();
		em.close();
	}

}
