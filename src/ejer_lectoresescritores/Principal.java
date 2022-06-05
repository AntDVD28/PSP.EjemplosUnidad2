
package ejer_lectoresescritores;

/**
 * Clase Principal
 * @author David Jiménez Riscardo
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Libro libro = new Libro();
        LibroJusto libro = new LibroJusto();
        Escritor[] escritores = new Escritor[2];
        Lector[] lectores = new Lector[10];
        
        for(int i=0;i<escritores.length;i++){
            escritores[i] = new Escritor(i+1, libro);
        }
        
        for(int i=0;i<lectores.length;i++){
            lectores[i] = new Lector(i+1, libro);
        }
        
        for(int i=0;i<escritores.length;i++){
            escritores[i].start();
        }
        
        for(int i=0;i<lectores.length;i++){
            lectores[i].start();
        }
    }
    
}
