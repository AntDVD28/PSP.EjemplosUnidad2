package ejer_restaurante;

/**
 * Clase Pedido
 * @author David Jiménez Riscardo
 */
public class Pedido {
    
    private String nombrePlato;
    //Para saber si hay pedidos pendientes de ser atendidos
    private int numPedidosPendientes;
    //Para contabilizar el número de clientes atendidos
    private int numClientes;
    //Para contabilizar el número de platos servidos
    private int numPlatosServidos;
    
    
    //Número máximo de clientes que atienden en 1 día
    public static final int MAXIMO_CLIENTES = 10;
    
    public Pedido(String nombrePlato){
        this.nombrePlato = nombrePlato;
        this.numPedidosPendientes = 0;
        this.numClientes = 0;
        this.numPlatosServidos = 0;
    }
    
    
    public void incrementaNumPedidosPendientes(){        
        numPedidosPendientes++;
    }
    
    public void decrementaNumPedidosPendientes(){
        if(numPedidosPendientes>0)
            numPedidosPendientes--;
    }
    
    public int getNumPedidosPendientes(){
        return this.numPedidosPendientes;
    }
    
    public String getNombrePlato(){
        return this.nombrePlato;
    }
    
    public int getNumClientes(){
        return this.numClientes;
    }
    
    public void incrementaNumClientes(){
        this.numClientes++;
    }
    
    public int getNumPlatosServidos(){
        return this.numPlatosServidos;
    }
    
    public void incrementaNumPlatosServidos(){
        this.numPlatosServidos++;
    }
}
