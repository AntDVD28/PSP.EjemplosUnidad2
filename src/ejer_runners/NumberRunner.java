package ejer_runners;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase NumberRunner
 *
 * @author David Jiménez Riscardop
 * @version 1.0
 */
public class NumberRunner implements Runnable {

    RecursoCompartido res;

    public NumberRunner(RecursoCompartido res) {
        this.res = res;
    }

    @Override
    public void run() {

        //Primera forma de solucionarlo
//        synchronized (res) {
//
//            for (int i = 1; i <= 26; i++) {
//
//                if (!res.isLetter) {
//                    System.out.print(res.number + " ");
//                    res.isLetter = true;
//                    res.number++;
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(NumberRunner.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    res.notify();
//                    try {
//                        res.wait();
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(NumberRunner.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }//fin del for
//            res.notify();
//        }//fin del synchronized

        //Segunda forma de solucionarlo
        while (res.number <= 26) {

            synchronized (res) {
                if (res.isLetter) {
                    try {
                        res.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(NumberRunner.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    System.out.print(res.number + " ");
                    res.isLetter = true;
                    res.number++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(NumberRunner.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    res.notify();
                }
            }
        }

    }//fin del método run  

}//fin de la clase
