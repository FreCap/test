package it.unibo.oop.smac.view.locationpanel;

import it.unibo.oop.smac.datatypes.ICoordinates;
import it.unibo.oop.smac.view.mainpanel.MainPanel;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Implementazione concreta di un {@link MyMapMarker}. Questa implementazione restituisce come
 * immagine per il MapMarker un pin di colore verde. Implementazione secondo il pattern Template
 * Method.
 * 
 * @author Federico Bellini
 */
public class GreenMapMarker extends MyMapMarker {
  private static final String DEFAULT_GREEN_PATH = "/images/greenPin.png";

  /**
   * Costruttore pubblico.
   * 
   * @param id
   *          ID che si vuole impostare per il MapMarker.
   * @param coordinates
   *          Coordinate di posizione del MapMarker.
   */
  public GreenMapMarker(final String id, final ICoordinates coordinates) {
    super(id, coordinates);
  }

  /**
   * Restituisce un'immagine contenente il tipo di MapMarker che si vuole utilizzare. In questo caso
   * e' un pin di colore verde.
   * 
   * @return I'Image contenente il MapMarker desiderato.
   */
  @Override
  protected Image getImageForMarker() {
    Image image = null;
    try {
      image = ImageIO.read(MainPanel.class.getResource(DEFAULT_GREEN_PATH));
    } catch (IOException e) {
    }
    return image;
  }

}