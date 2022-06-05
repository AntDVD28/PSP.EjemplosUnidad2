package ejer_boxeadores;

/**
 * Clase para el recurso compartido
 * @author David Jiménez Riscardo
 */
public class Ring {

    private int totalGolpes;

    public Ring() {
        totalGolpes = 0;
    }

    public int getTotalGolpes() {
        return totalGolpes;
    }

    public synchronized void pegar(Boxeador b) {

        if (this.getTotalGolpes() < 100) {
            this.totalGolpes++;
            b.pegar();
            System.out.println("Pegada de " + b.getNombre() + " (" + b.getGolpes() + "/" + this.getTotalGolpes() + ")");
        }
    }

}
