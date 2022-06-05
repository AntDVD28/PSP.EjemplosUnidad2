package ejemplo06;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase Contador, este sería el recurso compartido
 * @author David Jiménez Riscardo
 */
public class Contador {
    
    private int contador = 0;

    public Contador() {

    }

    public synchronized String incrementa(int numHilo) {
        String salida = "Hilo: " + numHilo+ " - Valor del contador = " + this.getValor() + " - Operación: Incrementar\n";
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloContador.class.getName()).log(Level.SEVERE, null, ex);
        }
        contador++;
        salida = salida + "Hilo: " + numHilo + " - Valor del contador = " + this.getValor();
        return salida;
    }

    public synchronized String decrementa(int numHilo) {
       String salida = "Hilo: " + numHilo + " - Valor del contador = " + this.getValor() + " - Operación: Decrementar\n";
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloContador.class.getName()).log(Level.SEVERE, null, ex);
        }
        contador--;
        salida = salida + "Hilo: " + numHilo + " - Valor del contador = " + this.getValor();
        return salida;
    }

    public synchronized int getValor() {
        return contador;
    }
    
}