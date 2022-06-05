package ejer_boxeadores;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Enunciado del ejercicio: Tenemos que gestionar un combate de boxeo en la que
 * dos boxeadores (hilos) van a compartir un Ring (recurso compartido) mientras
 * que el número total de golpes que se han repartido (variable compartida) sea
 * inferior a 100 (cuando el número total de golpes es 100 los hilos finalizan).
 * Una vez que los dos hilos boxeadores han terminado, el programa debe devolver
 * qué boxeadores ha ganado (el que más golpes haya dado).
 */
/**
 * Clase Principal
 *
 * @author David Jiménez Riscardo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Instanciamos el recurso compartido
        Ring ring = new Ring();

        //Instancio una lista de hilos dónde guardaré una referencia a los mismos
        List<Thread> mishilos = new LinkedList<>();

        //Instancia de los hilos
        Boxeador boxeador1 = new Boxeador("Tyson", ring);
        Boxeador boxeador2 = new Boxeador("Rocky", ring);

        //Agrego los hilos a la lista
        mishilos.add(boxeador1);
        mishilos.add(boxeador2);

        //Lanzo los hilos
        for (Thread hilo : mishilos) {
            hilo.start();
        }
        //Espero a que finalicen todos los hilos para finalizar el programa principal
        for (Thread hilo : mishilos) {
            try {
                hilo.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Fin del combate");

        //Comprobamos quién ha ganado
        if (boxeador1.getGolpes() > boxeador2.getGolpes()) {
            System.out.println("Ha ganado " + boxeador1.getNombre() + " con " + boxeador1.getGolpes() + " golpes");
        } else if (boxeador2.getGolpes() > boxeador1.getGolpes()) {
            System.out.println("Ha ganado " + boxeador2.getNombre() + " con " + boxeador2.getGolpes() + " golpes");
        } else {
            System.out.println("Combate nulo");
        }
    }

}
