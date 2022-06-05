package ejemplo03;

/**
 * Clase Alumno que implementa la interfaz Runnable
 * @author David Jiménez Riscardo
 */
public class Alumno extends Persona implements Runnable {
    String correo;
    double nota;
    
    public Alumno(String nombre, int edad, double peso, String correo, double nota){
        super(nombre,edad,peso);
        this.correo=correo;
        this.nota=nota;
    }
    
    public String toStrig(){
        return "Hola me llamo "+this.getNombre()+" y mi correo es "+correo;
    }

    @Override
     public void run(){
        System.out.println(this.toStrig());
    }
}
