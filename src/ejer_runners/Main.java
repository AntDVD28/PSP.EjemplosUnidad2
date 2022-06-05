package ejer_runners;

/**
 * Enunciado del ejercicio: Tenemos dos hilos de diferente tipo (LetterRunner y
 * NumberRunner), el primero escribe letras de la A a la Z y el otro número del
 * 1 al 26 y un recurso compartido (RecursoCompartido) que me indica, en cada
 * momento, por qué letra voy, por qué número voy, y si ahora toca escribir una
 * letra o un número. La ejecución del programa debería de reproducir:
 * A1 B2 C3 D4 E5 F6 G7 H8 I9 J10 K11 L12 M13 N14 O15 P16 Q17 R18 S19 T20 U21 V22 W23 X24 Y25 Z26
 */

/**
 * Clase Principal
 *
 * @author David Jiménez Riscardo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RecursoCompartido res = new RecursoCompartido();
 
        Thread letterThread = new Thread(new LetterRunner(res));
        Thread numberThread = new Thread(new NumberRunner(res));
 
        letterThread.start();
        numberThread.start();
    }

}
