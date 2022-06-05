package ejemplo07;

/**
 *
 * @author David Jiménez Riscardo
 */
public class EjemploInterbloqueo {
    //Tengo dos recursos compartidos
    private Persona fran = new Persona("Fran",39,81);
    private Persona amalia = new Persona("Amalia",39,62);

    public void method1() {
        try{
            synchronized (fran) {
                Thread.sleep(2000);
                synchronized (amalia) {
                    System.out.println("Me sincronizo primero con "+fran.getNombre()+" y luego con "+amalia.getNombre());
                }
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }

    public void method2() {
        try{
            synchronized (amalia) {
                Thread.sleep(2000);
                synchronized (fran) {
                    System.out.println("Me sincronizo primero con "+amalia.getNombre()+" y luego con "+fran.getNombre());
                }
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
