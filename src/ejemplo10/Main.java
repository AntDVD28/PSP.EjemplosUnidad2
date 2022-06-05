
package ejemplo10;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Ejemplo dónde vemos el uso del método join
 * @author David Jiménez Riscardo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String nombres[] = {"Valme", "Antonia", "Manoli", "Jesús", "Fran", "Estrella", "David"};
        
        //Es interesante almacenar todos los hilos en una estructura de datos
        List<Thread> misHilos = new LinkedList<>();
        for(int i=0;i<nombres.length;i++){
            misHilos.add(new EjemploHilo(nombres[i], (1+i)*2));
        }
        
        //Recorro la estructura para lanzar los hilos
        for(Thread hilo : misHilos){
            hilo.start();
        }
        
        //Recorro la estructura y compruebo que todos han terminado
        for(Thread hilo : misHilos){
            try {
                hilo.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("Después de que se ejecuten todos los hilos debo de hacer algo");
    }
    
}