package ejemplo08;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para definir los hilos
 * @author David Jiménez Riscardo
 */
public class HiloCadena extends Thread {
    private ObjetoCompartido objeto;
    String cad;
    
    public HiloCadena(ObjetoCompartido c, String s){
        this.objeto = c;
        this.cad=s;
    }
    
    public void run(){
        for(int j=0;j<10;j++){
            objeto.PintaCadena(cad);
            try {
                //Duermo el hilo entre 0 y 5 segundos
                Thread.sleep((int)(Math.random()*5000+1));
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloCadena.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
