package EnumMapping.attributeConverter;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import EnumMapping.attributeConverter.business.TripBean;
import EnumMapping.attributeConverter.enums.Vehicle;
import ebook.JpaUtil;

public class Searching {
	
	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		
		TypedQuery<TripBean> q = em.createQuery("SELECT t FROM Trip t WHERE t.vehicle = :v", TripBean.class);
		q.setParameter("v", Vehicle.PLANE);
		List<TripBean> trips = q.getResultList();
	}

}
