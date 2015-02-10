package it.unibo.oop.smac.view.stolencarspanel;

import it.unibo.oop.smac.controller.IStolenCarsObserver;
import it.unibo.oop.smac.datatypes.ISighting;

import javax.swing.JPanel;

/**
 * Interfaccia per la gestione di un panel che visualizza le informazioni sulle auto rubate.
 * Utilizzato pattern Observer.
 * 
 * @author Francesco Capponi
 */
public interface IStolenCarsPanel {

  /**
   * Attacca l'Observer degli StolenCars.
   * 
   * @param sco
   *          L'{@link IStolenCarsObserver} da attaccare.
   */
  void attachStolenCarsObserver(IStolenCarsObserver sco);

  /**
   * Restituisce il {@link JPanel}.
   * 
   * @return Il {@link JPanel}.
   */
  JPanel getPanel();

  /**
   * Questo metodo deve segnalare che c'e' stato un passaggio di una macchina rubata sotto
   * un'osservatore.
   * 
   * @param sighting
   *          L'{@link ISighting} dell'avvistamento della macchina rubata.
   */
  void newPassageStolenCar(ISighting sighting);

}
