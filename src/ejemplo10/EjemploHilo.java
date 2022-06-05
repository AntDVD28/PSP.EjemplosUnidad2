
package ejemplo10;

/**
 * Ejemplo de como crear un hilo con estructura de objeto
 * @author David Jiménez Riscardo
 */
public class EjemploHilo extends Thread {
    
    private int nSaludos;
    
    public EjemploHilo(String nombre, int nSaludos){
        super(nombre);
        this.nSaludos = nSaludos;
    }
    
    @Override
    public void run(){
        for(int i=0;i<nSaludos;i++){
            System.out.println("Hola, me llamo "+this.getName()+" y voy por el saludo número "+(i+1));
        }
    }
    
}
