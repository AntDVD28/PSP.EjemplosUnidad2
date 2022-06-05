package ejemplo04;

import java.util.LinkedList;
import java.util.List;

/**
 * Clase para instanciar los hilos los cuales hacen uso del recurso compartido. El recurso compartido NO ESTÁ SINCRONIZADO.
 * Vemos la necesidad de tener que sincronizar el recurso compartido.
 * @author David Jiménez Riscardo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Thread> misHilos = new LinkedList<>();
        int numero;
        
        //Instancia del recurso compartido
        Contador miContador = new Contador();
        
        //Guardo los hilos en una estructura de datos
        for (int i = 0; i < 5; i++) {
            numero = (int)(Math.random()*2+1);
            //numero valdrá 1(equivalente a la operación suma) ó 2(resta)
            misHilos.add(new HiloContador(miContador,(i+1),numero));
        }
        
        //Lanzo los hilos
        for (Thread hilo : misHilos) {
            hilo.start();
        }
    }
    
}
