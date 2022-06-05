package ejemplo07;

/**
 * Ejemplo de interbloqueo
 * @author David Jiménez Riscardo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EjemploInterbloqueo lock = new EjemploInterbloqueo();
        HiloInterbloqueo t1 = new HiloInterbloqueo(lock,0);
        HiloInterbloqueo t2 = new HiloInterbloqueo(lock,1);
        t1.start();
        t2.start();
    }
    
}
