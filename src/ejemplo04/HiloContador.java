package ejemplo04;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que hace uso del recurso compartido (no sincronizado)
 * @author David Jiménez Riscardo
 */
public class HiloContador extends Thread {
   
    Contador contador;
    int numHilo;
    int operacion;
    
    
    public HiloContador(Contador contador, int numHilo, int operacion){
        this.contador=contador;
        this.numHilo=numHilo;
        this.operacion=operacion;      
    }
    
    @Override
    public void run(){
        for(int i=0; i<5;i++){
            System.out.println("Hilo: "+this.numHilo+" - Valor del contador = "+contador.getValor()+ " - Operación: "+operacion);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloContador.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(operacion==1)
                contador.incrementa();
            else
                contador.decrementa();
            System.out.println("Hilo: "+this.numHilo+" - Valor del contador = "+contador.getValor());
        }
    }
}
