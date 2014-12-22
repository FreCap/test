package it.unibo.oop.smartercities.model;

import java.util.List;

import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.datatype.InfoStolenCars;
import it.unibo.oop.smartercities.datatype.InfoStreetObserver;
import it.unibo.oop.smartercities.datatype.PlateLicense;
import it.unibo.oop.smartercities.datatype.InfoSighting;

public interface ModelInterface {
	
	// aggiunta di un nuovo street observer
	void addNewStreetObserver(Coordinates c);
	
	// notifica di un passaggio
	void newPassage(Coordinates c, InfoSighting s);
	
	// restituisce le info di uno street observer
	InfoStreetObserver getInfoOf(Coordinates c);
	
	// verifica se un auto è rubata
	InfoStolenCars verifyStolenCar(PlateLicense lp);

	// resituisce una lista di macchine rubate
	List<Object> getStolenCarsList();
}
