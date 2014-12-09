package it.unibo.oop.streetObservers;

import java.net.URL;
import java.util.Optional;

import javax.swing.*;

public class StreetObserverLocationMap {
	
	private static final String DEFAULT_ICON_PATH = "/images/somethingWrongHappened.png";
	private Optional<ImageIcon> controlIcon;
	
	public StreetObserverLocationMap () {
	}
	
	public ImageIcon getMapOf(int ID, Double lat, Double lng){
		URL url = new URLencoder().getURLfor(ID, lat, lng);
		controlIcon = GetImageFromGoogle.get(url);
		if(controlIcon.isPresent()){
			return controlIcon.get();
		}
		else{
			return new ImageIcon(DEFAULT_ICON_PATH);
		}
	}
}
