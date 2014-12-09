package it.unibo.oop.streetObservers;

import javax.swing.ImageIcon;

public class StreetObserver {

	private final int ID;
	private final Double LATITUDE;
	private final Double LONGITUDE;
	private final ImageIcon icon;
	private Informations info;	
	
	public StreetObserver(Double lat, Double lng) {
		this.ID = MakeID.getNewID();
		this.LATITUDE = lat;
		this.LONGITUDE= lng;
		this.icon = new StreetObserverLocationMap().getMapOf(this. ID, this.LATITUDE, this.LONGITUDE);
	}
	
	public int getID() {
		return ID;
	}
	
	public Double getLat() {
		return LATITUDE;
	}

	public Double getLng() {
		return LONGITUDE;
	}
	
	public Informations getInfo() {
		return this.info;
	}
	
	public ImageIcon getPositionMap() {
		return icon;
	}

}
