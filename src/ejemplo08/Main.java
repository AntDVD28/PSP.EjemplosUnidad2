package ejemplo08;

/**
 * Ejemplo del uso de hilos SIN ESTABLECER UN ORDEN EN EL USO DEL RECURSO COMPARTIDO
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
