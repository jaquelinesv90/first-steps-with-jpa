package EnumMapping.attributeConverter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Trip {
	
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
