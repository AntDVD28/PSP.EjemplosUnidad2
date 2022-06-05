package ejer_restaurante;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase Camarero
 *
 * @author David Jiménez Riscardo
 */
public class Camarero extends Thread {

    private Pedido pedido;
    private String nombreCamarero;

    public Camarero(String nombreCamarero, Pedido pedido) {
        this.nombreCamarero = nombreCamarero;
        this.pedido = pedido;
    }

    public void run() {

        for (int i = 0; i < Pedido.MAXIMO_CLIENTES; i++) {

            synchronized (pedido) {
                pedido.incrementaNumPedidosPendientes();
                pedido.incrementaNumClientes();
                System.out.println("(" + this.nombreCamarero + ") Tomando nota de pedido. Cliente número: " + pedido.getNumClientes());
                pedido.notify();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Camarero.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
