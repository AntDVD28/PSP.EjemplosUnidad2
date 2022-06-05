package ejer_filosofos;

/**
 * Ejercicio Cena de los filósofos
 * @author David Jiménez Riscardo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tenedores recursoCompartido = new Tenedores();
        HiloFilosofo filosofos[] = new HiloFilosofo[5];
        for(int i=0; i<filosofos.length;i++){
            filosofos[i] = new HiloFilosofo(i,recursoCompartido);
        }
        
        System.out.println("EJERCICIO DE LA CENA DE LOS FILÓSFOTOS");
        System.out.println("--------------------------------------");
        
        for (HiloFilosofo filosofo : filosofos) {
            filosofo.start();
        }
        
        for (HiloFilosofo filosofo : filosofos) {
            try {
                filosofo.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("\nResumen de las veces que han comido:");
        for (HiloFilosofo filosofo : filosofos) {
            System.out.printf("El filófoso %d ha comido %d veces.\n",filosofo.getNumFiloso(),filosofo.getNumComidas());
        }
    }
    
}
