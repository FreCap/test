package it.unibo.oop.smac.test.model;

import it.unibo.oop.smac.datatypes.LicensePlate;
import it.unibo.oop.smac.test.client.LicensePlateGenerator;

import javax.management.InvalidAttributeValueException;

import org.junit.Test;

public class LicensePlateTest {

  /**
   * Controlla che la creazione di un oggetto {@link LicensePlate} con una targa conforme non
   * restituisca eccezioni. * @throws Exception
   * 
   * @exception Exception
   *              quando viene restituita una exception, fallisce il test
   * 
   */
  @Test
  public void testNewLicensePlate() throws Exception {
    new LicensePlate("TE355TT");

  }

  /**
   * Controlla che la creazione di un oggetto {@link LicensePlate} con una targa NON conforme
   * restituisca eccezioni.
   * 
   * @exception InvalidAttributeValueException
   *              necessaria l'exception per il successo del test
   */
  @Test(expected = InvalidAttributeValueException.class)
  public void testNewLicensePlateFail() throws Exception {
    new LicensePlate("NONCONFORME");
  }

  /**
   * Controlla che il generatore di targhe {@link LicensePlateTest} restituisca una targa conforme.
   * 
   * @exception Exception
   *              quando viene restituita una exception, fallisce il test
   */
  @Test
  public void testNewLicensePlateGenerator() throws Exception {
    new LicensePlate(LicensePlateGenerator.generate());
  }

}
