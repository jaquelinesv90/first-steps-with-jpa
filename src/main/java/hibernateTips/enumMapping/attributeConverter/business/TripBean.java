package hibernateTips.enumMapping.attributeConverter.business;

import javax.persistence.Entity;
import javax.persistence.Id;

import hibernateTips.enumMapping.attributeConverter.enums.Vehicle;


@Entity
public class TripBean {
	
	@Id
	private Long id;
	
	private Vehicle vehicle;

	
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
}
