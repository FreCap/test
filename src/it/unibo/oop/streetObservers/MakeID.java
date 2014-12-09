package it.unibo.oop.streetObservers;

public final class MakeID {
	
	static int ID = 0;
	
	private MakeID() {
	}
	
	public static int getNewID() {
		return ++ID;
	}
}
