package it.unibo.oop.smac.view.stolencars.network;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import it.unibo.oop.smac.controller.IStolenCarsObserver;
import it.unibo.oop.smac.network.view.jobs.ControllerSightingSender;

import java.util.Observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class NetServer {

  /**
   * Logger della classe
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(NetServer.class);

  /**
   * Costante della porta del server su cui offrire il servizio.
   */
  public static final int PORT = Integer.parseInt(System.getProperty("port", "8007"));

  /**
   * Dispatcher che notifica i jobs che l'osservano alla ricezione di pacchetti da parte della rete.
   */
  private final Observable dispatcher;

  /**
   * Costruttore della classe.
   * 
   * @param observer
   *          dell'applicazione su cui verranno richiamate le funzioni di segnalazione all'arrivo di
   *          eventi dalla rete
   */
  public NetServer(final IStolenCarsObserver observer) {
    this.dispatcher = new Dispatcher(observer);
    dispatcher.addObserver(new ControllerSightingSender());
    this.run();
  }

  /**
   * Inizializzazione dell'inizializzatore di un nuovo channel (connessione).
   */
  private final ChannelInitializer<SocketChannel> channelInitializer = new ChannelInitializer<SocketChannel>() {
    @Override
    public void initChannel(final SocketChannel ch) {
      final ChannelPipeline p = ch.pipeline();

      p.addLast(new ObjectEncoder(), new ObjectDecoder(ClassResolvers.cacheDisabled(null)),
          new ServerHandler(dispatcher));
    }
  };

  /**
   * Metodo che fa partire il processo server.
   */
  private void run() {
    new Thread(new Runnable() {
      @Override
      public void run() {
        // inizializza i workers per gestire le connessioni entranti
        // secondo la tecnica NIO (Nonblocking server)
        final EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        final EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
          // inizializzo i parametri di connessione
          final ServerBootstrap b = new ServerBootstrap();
          b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
              .handler(new LoggingHandler(LogLevel.INFO)).childHandler(channelInitializer);

          // Binda la porta e inizia ad accettare le connessioni dai
          // client
          b.bind(PORT).sync().channel().closeFuture().sync();
        } catch (InterruptedException e) {
          LOGGER.error(
              "Service Interrupted, you have already another server running. I'm shutting down", e);
          System.exit(0);
        } finally {
          bossGroup.shutdownGracefully();
          workerGroup.shutdownGracefully();
        }
      }
    }).start();
  }

}