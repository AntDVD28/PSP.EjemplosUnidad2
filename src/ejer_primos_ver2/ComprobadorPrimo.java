package ejer_primos_ver2;

import java.util.ArrayList;

/**
 * Clase Comprobador de Primo
 * @author David Jiménez Riscardo
 */
public class ComprobadorPrimo extends Thread {

    private final long numero;
    private long divisor=0;
    private ArrayList listaPrimos;
    


    public ComprobadorPrimo(long numero, ArrayList listaprimos) {
        this.numero = numero;
        this.listaPrimos = listaprimos;
    }

    @Override
    public void run() {
        
        if (esPrimo(numero)) { 
            synchronized(listaPrimos){          
                this.listaPrimos.add(numero);
            }   
        }      
    }

    boolean esPrimo(long numero) {
        boolean primo= true;
        long candidatoDivisor= 2;
        while (candidatoDivisor < numero && primo) {
            try {
                Thread.sleep (0, 2);
            } catch (InterruptedException ex) {
                System.out.printf ("Error en sleep: %s.\n", ex.getMessage());
            }
            if (numero % candidatoDivisor == 0) {
                primo= false;
                divisor= candidatoDivisor;
            } else
                candidatoDivisor++;                       
        }        
        return primo;
    }
    
    

// Una forma más óptima de llevar a cabo la comprobación
// (el problema es que es demasiado rápida y para este ejericio interesa que sea más "lenta"
/*    boolean esPrimo(long numero) {
        boolean primo= true;
        long candidatoDivisor= 3;
        if (numero % 2 == 0) {
            primo= false;
        }
        while (candidatoDivisor < (int) Math.sqrt(numero) && !primo) {
            if (numero % candidatoDivisor == 0)
                primo= false;
            else
                candidatoDivisor +=2;                       
        }        
        return primo;
    }
*/    
    
}
