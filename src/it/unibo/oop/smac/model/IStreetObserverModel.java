package it.unibo.oop.smac.model;

import it.unibo.oop.smac.database.model.NotFoundException;
import it.unibo.oop.smac.database.model.StreetObserverNotValidException;
import it.unibo.oop.smac.datatype.I.IInfoStreetObserver;
import it.unibo.oop.smac.datatype.I.ISighting;
import it.unibo.oop.smac.datatype.I.IStreetObserver;

/**
 * Interfaccia del Model dell'applicazione. Chi implementa questa interfaccia di deve occupare della
 * memorizzazione dei dati provenienti dagli osservatori.
 * 
 * @author Federico Bellini
 */
public interface IStreetObserverModel {

  /**
   * Questo metodo deve aggiungere un nuovo {@link IStreetObserver} a quelli già presenti nel Model.
   * 
   * @param streetObserver
   *          L'{@link IStreetObserver} da aggiungere.
   */
  void addNewStreetObserver(IStreetObserver streetObserver);

  /**
   * Questo metodo controlla se l'{@link IStreetObserver} passato come argomento sia gia' presente
   * nel Model dell'appicazione.
   * 
   * @param streetObserver
   *          L'{@link IStreetObserver} di cui verificare la presenza.
   * @return True se esiste, false altrimenti.
   */
  boolean checkStreetObserverExists(IStreetObserver streetObserver);

  /**
   * Questo metodo deve aggiungere un nuovo {@link ISighting} a quelli già salvati nel Model.
   * 
   * @param sighting
   *          L'{@link ISighting} da aggiungere.
   * @throws StreetObserverNotValidException
   */
  void addSighting(ISighting sighting) throws IllegalArgumentException,
      StreetObserverNotValidException;

  /**
   * Questo metodo raccoglie i dati su di un {@link IStreetObserver}, e li organizza restituendo al
   * chiamante un {@link IInfoStreetObserver} contenente le informazioni sull'osservstore richiesto.
   * 
   * @param streetObserver
   *          L'{@link IStreetObserver} di cui si vogliono recuperare le informazioni.
   * @return Un oggetto del tipo {@link IInfoStreetObserver} contenente le informazioni sull'
   *         {@link IStreetObserver} richiesto.
   * @throws NotFoundException
   *           Eccezione lanciata nel caso in cui l'{@link IStreetObserver} di cui si vogliono
   *           recuperare le informazioni non fosse presente nel Model dell'applicazione.
   */
  IInfoStreetObserver getStreetObserverInfo(IStreetObserver streetObserver)
      throws IllegalArgumentException, NotFoundException;
}
