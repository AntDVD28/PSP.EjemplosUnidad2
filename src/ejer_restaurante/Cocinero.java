package ejer_restaurante;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase Cocinero
 *
 * @author David Jiménez Riscardo
 */
public class Cocinero extends Thread {

    private Pedido pedido;
    private String nombreCocinero;

    public Cocinero(String nombreCocinero, Pedido pedido) {
        this.nombreCocinero = nombreCocinero;
        this.pedido = pedido;
    }

    public void run() {

        for (int i = 0; i < Pedido.MAXIMO_CLIENTES; i++) {

            synchronized (pedido) {

                while (pedido.getNumPedidosPendientes() == 0) {
                    System.out.println("(" + this.nombreCocinero + ") No hay pedidos. Cocinero esperando...");
                    try {

                        pedido.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }//fin del while
                pedido.decrementaNumPedidosPendientes();
                pedido.incrementaNumPlatosServidos();
                System.out.println("(" + this.nombreCocinero + ") Sirviendo..." + pedido.getNombrePlato() + " del pedido " + pedido.getNumPlatosServidos());
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
            }

        }//fin del for

    }
}
