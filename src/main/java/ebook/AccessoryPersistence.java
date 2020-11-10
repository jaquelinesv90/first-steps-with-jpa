package ebook;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ebook.entity.ManyToMany_unidirectional.Accessory;
import ebook.entity.ManyToMany_unidirectional.Vehicle_ManyToMany;

public class AccessoryPersistence {

	public static void main(String[] args) {
		
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Accessory wheel = new Accessory();
		wheel.setDescription("aileron");
		
		Accessory sensor = new Accessory();
		sensor.setDescription("parking system");
		
		Accessory mp3 = new Accessory();
		mp3.setDescription("mp3 Player");
		
		Accessory paintwork = new Accessory();
		paintwork.setDescription("black");
		
		//persiste acessorios
		manager.persist(wheel);
		manager.persist(sensor);
		manager.persist(mp3);
		manager.persist(paintwork);
		
		//instancia veículos
		Vehicle_ManyToMany vehicle = new Vehicle_ManyToMany();
		vehicle.setManufacturer("VW");
		vehicle.setModel("Gol");
		vehicle.setYearManufacture(2000);
		vehicle.setFuelType(FuelType.BIOFUEL);
		vehicle.getAccessory().add(wheel);
		vehicle.getAccessory().add(mp3);
		
		//instancia veículos
		Vehicle_ManyToMany vehicle2 = new Vehicle_ManyToMany();
		vehicle2.setManufacturer("VW");
		vehicle2.setModel("Gol");
		vehicle2.setYearManufacture(2000);
		vehicle2.setFuelType(FuelType.BIOFUEL);
		vehicle2.getAccessory().add(wheel);
		vehicle2.getAccessory().add(mp3);
		
		
		//persiste veiculo
		manager.persist(vehicle);
		manager.persist(vehicle2);
		
		tx.commit();
		manager.close();
		JpaUtil.close();
	}
}
