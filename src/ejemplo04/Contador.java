package ejemplo04;

/**
 * Clase Contador, este sería el recurso compartido
 * @author David Jiménez Riscardo
 */
public class Contador {
    
    private int contador=0;
    
    public Contador(){
        
    }
    
    public void incrementa(){
        contador++;
    }
    
    public void decrementa(){
        contador--;
    }
    
    public int getValor(){
        return contador;
    }
    
}
