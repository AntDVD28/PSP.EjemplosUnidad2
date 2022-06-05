package ejemplo01;

/**
 * Ejemplo básico de como lanzar un hilo
 * @author David Jiménez Riscardo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EjemploHilo h1 = new EjemploHilo();
        h1.start();
        
        EjemploHilo h2 = new EjemploHilo();
        h2.start();
        
        EjemploHilo h3 = new EjemploHilo();
        h3.start();
        
        EjemploHilo h4 = new EjemploHilo();
        h4.start();
        
    } 
    
}


