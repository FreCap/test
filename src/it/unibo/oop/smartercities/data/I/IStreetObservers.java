package it.unibo.oop.smartercities.data.I;

import it.unibo.oop.smartercities.datatype.Coordinates;
import it.unibo.oop.smartercities.datatype.InfoSighting;
import it.unibo.oop.smartercities.datatype.Sighting;
import it.unibo.oop.smartercities.datatype.StreetObserver;

import java.util.Date;
import java.util.List;

public interface IStreetObservers {
	public StreetObserver add(Coordinates coordinate) throws Exception;

	public StreetObserver sighting(InfoSighting sighting);

	public List<Sighting> getSighting(StreetObserver streetObserver);

	public List<Sighting> getSighting(StreetObserver streetObserver,
			Date from, Date to);

	public List<Sighting> getMediaVelocita(StreetObserver streetObserver);
	
	public List<Sighting> getMediaVelocita(StreetObserver streetObserver,
			Date from, Date to);

}
