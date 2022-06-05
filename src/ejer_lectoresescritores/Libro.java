
package ejer_lectoresescritores;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para el recurso compartido
 * @author David Jiménez Riscardo
 */
public class Libro {
    
    private int numLectores=0;
    private boolean hayEscritor=false;
    
    public synchronized void openL(int id){
        while(hayEscritor){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        numLectores++;
        System.out.println("Lector "+id+" leyendo...");
    }
    
    public synchronized void closeL(int id){
        System.out.println("Lector "+id+" deja de leer.");
        numLectores--;
        if(numLectores==0) notify();
    }
    
    public synchronized void openE(int id){
        while(hayEscritor || numLectores>0){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        hayEscritor = true;
        System.out.println("Escritor "+id+" escribiendo...");
    }
    
    public synchronized void closeE(int id){
        System.out.println("Escritor "+id+" deja de escribir.");
        hayEscritor=false;
        notifyAll();
    }
    
}
