package it.unibo.oop.smartercities.datatype;

public class LicensePlate {

	private final String licensePlate;	
	
	public LicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((licensePlate == null) ? 0 : licensePlate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof LicensePlate){
			return this.toString().equals(obj.toString());
		}
		return false;
	}

	@Override
	public String toString() {
		return "LicensePlate = " + licensePlate;
	}
	
}
