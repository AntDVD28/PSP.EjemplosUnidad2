package ejer_boxeadores;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para los hilos (boxeadores)
 *
 * @author David Jiménez Riscardo
 */
public class Boxeador extends Thread {

    private String nombre;
    private Ring ring;
    private int NGolpesDados;

    public Boxeador(String nombre, Ring ring) {

        this.nombre = nombre;
        this.ring = ring;
        NGolpesDados = 0;
    }

    public void pegar() {
        NGolpesDados++;
    }

    public int getGolpes() {
        return NGolpesDados;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {

        while (ring.getTotalGolpes() < 100) {

            //Simulamos un tiempo de golpeo aleatorio                  
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Boxeador.class.getName()).log(Level.SEVERE, null, ex);
            }
            ring.pegar(this);
        }
    }
}
