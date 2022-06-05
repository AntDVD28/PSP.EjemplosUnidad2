
package ejer_lectoresescritores;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para los hilos escritores
 * @author David Jiménez Riscardo
 */
public class Escritor extends Thread{
    private static Random r = new Random();
    //private Libro libro;
    private LibroJusto libro;
    private int numEscritor;
    
    //public Escritor(int numEscritor, Libro libro){
    public Escritor(int numEscritor, LibroJusto libro){
        this.numEscritor= numEscritor;
        this.libro = libro;
    }
    
    public void run(){
        
        while(true){
            
            try {
                libro.openE(numEscritor);
                Thread.sleep(r.nextInt(200));
                //Escribo en el libro
                libro.closeE(numEscritor);           
                Thread.sleep(r.nextInt(300));
            } catch (InterruptedException ex) {
                Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
