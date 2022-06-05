package ejemplo09;

/**
 * Ejemplo del uso de hilos ESTABLECIENDO UN ORDEN EN EL USO DEL RECURSO COMPARTIDO (USO DE WAIT, NOTIFY Y NOTIFYALL)
 * @author David Jiménez Riscardo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ObjetoCompartido obj = new ObjetoCompartido();
        HiloCadena a = new HiloCadena(obj, " A ");
        HiloCadena b = new HiloCadena(obj, " B ");
        a.start();
        b.start();
    }
    
}
