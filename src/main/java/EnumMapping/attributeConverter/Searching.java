package EnumMapping.attributeConverter;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ebook.JpaUtil;

public class Searching {
	
	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		
		TypedQuery<Trip> q = em.createQuery("SELECT t FROM Trip t WHERE t.vehicle = :v", Trip.class);
		q.setParameter("v", Vehicle.PLANE);
		List<Trip> trips = q.getResultList();
	}

}
