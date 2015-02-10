package it.unibo.oop.smac.test.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Classe le operazioni effettuate dal client di rete all'invio e alla ricezioni di messaggi dal
 * server.
 */
public class SightingSenderClientHandler extends ChannelInboundHandlerAdapter {

  /**
   * Track corrente di cui si vuole simulare il comportamento.
   */
  public TrackSimulator trackSimulator;

  /**
   * Construttore che imposta la track che il client deve seguire.
   * 
   * @param trackSimulator
   *          oggetto che si occupa della simulazione del percorso del client corrente
   */
  public SightingSenderClientHandler(final TrackSimulator trackSimulator) {
    this.trackSimulator = trackSimulator;
  }

  /**
   * Funzione che stabilisce cosa deve essere effettuato una volta creato il canale di comunicazione
   * client-server.
   */
  @Override
  public void channelActive(final ChannelHandlerContext ctx) {
    // ai fini di test, finché l'applicazione è attiva, dovrà essere spedito
    // un pacchetto al server contenente le informazioni del sighting,
    // generato dal TrackCommand
    while (true) {
      ctx.writeAndFlush(trackSimulator.next());
    }
  }

  /**
   * Effettua il flush dei dati nel buffer.
   */
  @Override
  public void channelReadComplete(final ChannelHandlerContext ctx) {
    ctx.flush();
  }

  /**
   * Nel caso in cui la connessione cada, vada in timeout o accada qualsiasi altro errore, viene
   * generata un'exception e terminata la connessione.
   */
  @Override
  public void exceptionCaught(final ChannelHandlerContext ctx, final Throwable cause) {
    cause.printStackTrace();
    ctx.close();
  }
}