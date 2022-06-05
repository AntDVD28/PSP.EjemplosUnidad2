package ejemplo07;

/**
 * Clase Persona
 * @author David Jiménez Riscardo
 */
public class Persona {
    private String nombre;
    private int edad;
    private double peso;
    
    public Persona(String nombre, int edad, double peso){
        this.nombre=nombre;
        this.edad=edad;
        this.peso=peso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    //Y, además, miles de métodos super interesantes...
}
