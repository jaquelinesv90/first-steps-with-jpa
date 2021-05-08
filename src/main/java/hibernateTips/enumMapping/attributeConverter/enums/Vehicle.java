package hibernateTips.enumMapping.attributeConverter.enums;

public enum Vehicle {
	
	BUS("B"), CAR("C"), TRAIN("T"), PLANE("P");
	
	private String shortName;
	
	private Vehicle(String shortName) {
		this.shortName = shortName;
	}
	
	public String getShortName() {
		return shortName;
	}
	
	public static Vehicle fromShortName(String shortName) {
		switch(shortName) {
		case "B":
			return Vehicle.BUS;
		
		case "C":
			return Vehicle.CAR;
			
		case "T":
			return Vehicle.TRAIN;
			
		case "P":
			return Vehicle.PLANE;
			
		default:
			throw new IllegalArgumentException("ShortName:" + shortName + "not supported");
		}
	}
}
