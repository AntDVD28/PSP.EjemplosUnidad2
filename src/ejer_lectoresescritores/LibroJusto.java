
package ejer_lectoresescritores;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Recurso compartido
 * @author David Jiménez Riscardo
 */
public class LibroJusto {
    
    private int numLectores=0;
    private boolean hayEscritor=false;
    //Controlamos el número de escritores que están a la espera
    private int numEscritores=0;
    
    public synchronized void openL(int id){
        //Con la segunda condición le damos preferencia de entrada a los escritores que están esperando
        while(hayEscritor || numEscritores>0){
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
        if(numLectores==0) notifyAll();
    }
    
    public synchronized void openE(int id){
        //Incrementamos la variable
        numEscritores++;
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
        //Decrementamos la variable
        numEscritores--;
        System.out.println("Escritor "+id+" deja de escribir.");
        hayEscritor=false;
        notifyAll();
    }
    
}
