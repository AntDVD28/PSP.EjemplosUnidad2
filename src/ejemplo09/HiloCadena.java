package ejemplo09;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para definir los hilos
 * @author David Jiménez Riscardo
 */
public class HiloCadena extends Thread {
    private ObjetoCompartido objeto;
    String cad;
    
    public HiloCadena(ObjetoCompartido c, String s){
        this.objeto = c;
        this.cad=s;
    }
    
    public void run() {
        synchronized (objeto) {
            for (int j = 0; j < 10; j++) {
                objeto.PintaCadena(cad);
                objeto.notify();
                try {
                    //El wait además de hacer que el hilo1 pase a espera produce que el hilo2 pasa a ser uso de la zona compartida
                    objeto.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(HiloCadena.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    Thread.sleep((int) (Math.random() * 500 + 1));
                } catch (InterruptedException ex) {
                    Logger.getLogger(HiloCadena.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            objeto.notify();
        }
    }
}
