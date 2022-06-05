package ejemplo01;

/**
 * Ejemplo básico de como se construye un hilo
 * @author David Jiménez Riscardo
 */
public class EjemploHilo extends Thread{
    
    @Override
    public void run(){
        System.out.println("Hola mundo");
    }
}
