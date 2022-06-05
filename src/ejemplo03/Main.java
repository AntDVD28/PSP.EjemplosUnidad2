package ejemplo03;


/**
 * Ejemplo de como lanzar un hilo que implementa la interfaz Runnable
 * @author David Jiménez Riscardo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String nombres[] = {"Valme", "Antonia", "Manoli", "Jesús", "Fran", "Estrella", "David"};
        
        
        for(int i=0;i<nombres.length;i++){
            Alumno alumno = new Alumno(nombres[i],23,80,nombres[i]+"@gmail.com",10);
            Thread t = new Thread(alumno);
            t.start();
        }
        
    }
    
}
