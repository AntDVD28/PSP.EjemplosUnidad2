package ejer_runners;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase LetterRunner
 *
 * @author David Jiménez Riscardo
 * @version 1.0
 */
public class LetterRunner implements Runnable {

    RecursoCompartido res;

    public LetterRunner(RecursoCompartido res) {
        this.res = res;
    }

    @Override
    public void run() {

        //Primera forma de solucionarlo 
//        synchronized (res) {
//
//            for (int i = 1; i <= 26; i++) {
//
//                if (res.isLetter) {
//
//                    System.out.print(res.letter);
//                    res.isLetter = false;
//                    res.letter++;
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(LetterRunner.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    res.notify();
//                    try {
//                        res.wait();
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(LetterRunner.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }//fin del for 
//            res.notify();
//        }//fin del synchronized

        //Segunda forma de solucionarlo         
        while (res.letter <= 'Z') {

            synchronized (res) {
                if (!res.isLetter) {
                    try {
                        res.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(LetterRunner.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    System.out.print(res.letter);
                    res.isLetter = false;
                    res.letter++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(LetterRunner.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    res.notify();
                }
            }
        }

    }//fin del método run

}//fin de la clase
