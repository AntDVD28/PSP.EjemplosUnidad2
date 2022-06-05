
package ejer_primos;

/**
 * Clase ComprobadorPrimo
 * @author David Jiménez Riscardo
 */
public class ComprobadorPrimo extends Thread {

    private final long numero;
    private long divisor=0;


    public ComprobadorPrimo(long numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        if (esPrimo(numero)) {
            System.out.printf ("%10d es primo.\n", this.numero);
        } else {
            System.out.printf ("%10d no es primo. Es divisible entre %d.\n",
                    this.numero, this.divisor);
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