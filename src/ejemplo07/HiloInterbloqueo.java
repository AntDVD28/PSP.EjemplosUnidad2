package ejemplo07;

/**
 *
 * @author David Jiménez Riscardo
 */
public class HiloInterbloqueo extends Thread {
    private EjemploInterbloqueo lock;
    private int metodo;

    public HiloInterbloqueo(EjemploInterbloqueo lock, int metodo){
        this.lock = lock;
        this.metodo=metodo;
    }

    @Override
    public void run() {
        if(metodo==1)
            lock.method1();
        else
            lock.method2();   
    }
}
