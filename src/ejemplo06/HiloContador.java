package ejemplo06;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que hace uso del recurso compartido (sincronizado)
 *
 * @author David Jiménez Riscardo
 */
public class HiloContador extends Thread {
    
    Contador contador;
    int numHilo;
    int operacion;
    

    public HiloContador(Contador contador, int numHilo, int operacion) {
        this.contador = contador;
        this.numHilo = numHilo;
        this.operacion = operacion;    
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if(operacion == 1)
                System.out.println(contador.incrementa(this.numHilo));
            else
                System.out.println(contador.decrementa(this.numHilo));
        }
    }
}
