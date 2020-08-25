package ebook;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class IdVehicle implements Serializable{
		
	private static final long serialVersionUID = 1L;
	private String licensePlate;
	private String city;
	
	public IdVehicle() {}
	
	public IdVehicle(String licensePlate, String city) {
		this.licensePlate = licensePlate;
		this.city = city;
	}
	
	
	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
