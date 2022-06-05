package ejer_restaurante;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Manolo y Pepe tienen un bar cuya especialidad son las lentejas, hacen las
 * lentejas más buenas de la comarca. Su jornada de trabajo termina cuando han
 * servido el número máximo de pedidos (variable MAXIMO_CLIENTES). Manolo es el
 * cocinero y tarda el doble de tiempo en servir un plato de lentejas que Pepe
 * (camarero).
 */
/**
 * Clase Principal
 *
 * @author David Jiménez Riscardo
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Instancio el recurso compartido
        Pedido pedido = new Pedido("Plato de lentejas");

        //Instancio la lista de hilos
        ArrayList<Thread> misHilos;
        misHilos = new ArrayList();

        //Instancio los hilos
        Cocinero cocinero = new Cocinero("Manolo", pedido);
        Camarero camarero = new Camarero("Pepe", pedido);

        //Agrego los hilos a la lista
        misHilos.add(cocinero);
        misHilos.add(camarero);

        System.out.println("Bienvenidos al Restaurante de Manolo y Pepe - Especialidad en lentejas");
        System.out.println("======================================================================");

        //Inicio los hilos
        for (Thread hilo : misHilos) {
            hilo.start();
        }

        //Espero a que terminen todos
        for (Thread hilo : misHilos) {
            try {
                hilo.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("Jornada de trabajo finalizada");

    }

}
