package it.unibo.oop.smartercities.datatype;

public class Coordinates {
	
	private final double latitude;
	private final double longitude;
	
	public Coordinates(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Coordinates(Coordinates coord) {
		this(coord.getLatitude(), coord.getLongitude());
	}

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}
}
