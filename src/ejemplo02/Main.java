package ejemplo02;

import java.util.LinkedList;
import java.util.List;

/**
 * Método para lanzar el hilo
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
    }
    
}
