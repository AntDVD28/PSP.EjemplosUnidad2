
package ejer_lectoresescritores;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AntDVD
 */
public class Lector extends Thread{
    private static Random r = new Random();
    //private Libro libro;
    private LibroJusto libro;
    private int numLector;
    
    public Lector(int numLector, LibroJusto libro){
    //public Lector(int numLector, Libro libro){
        this.numLector = numLector;
        this.libro = libro;
    }
    
    public void run(){
        
        while(true){
            
            try {
                libro.openL(numLector);
                Thread.sleep(r.nextInt(200));
                //Leo el libro
                libro.closeL(numLector);        
                Thread.sleep(r.nextInt(300));
            } catch (InterruptedException ex) {
                Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
