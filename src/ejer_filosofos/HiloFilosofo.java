package ejer_filosofos;

/**
 * Clase HiloFilosofo
 * @author David Jiménez Riscardo
 */
public class HiloFilosofo extends Thread {
    private int numFilosofo;
    private int numComidas;
    private Tenedores tenedores;
    
    public HiloFilosofo(int numFilosofo, Tenedores tenedores){
        this.numFilosofo=numFilosofo;
        numComidas=0;
        this.tenedores=tenedores;
    }
    
    public int getNumFiloso(){
        return numFilosofo;
    }
    
    public int getNumComidas(){
        return numComidas;
    }
    
    public void run() {
        boolean comido=false;
        System.out.printf("El filósofo %d llega al salón.\n",this.numFilosofo);
        for(int i=0; i<5;i++){
            synchronized(tenedores){
                if(tenedores.puedeComer(this.numFilosofo)==true){
                    tenedores.comer(this.numFilosofo);
                    System.out.printf("El filósofo %d empieza a comer.\n",this.numFilosofo);
                    this.numComidas++;
                    comido=true;
                }else{
                    System.out.printf("El filósofo %d no ha podido comer y duerme.\n",this.numFilosofo);
                    comido=false;
                }
            }
            try { 
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            if(comido){
                synchronized(tenedores){
                    tenedores.dejarDeComer(this.numFilosofo);
                    System.out.printf("El filósofo %d deja de comer.\n",this.numFilosofo);
                }
            }
            try { 
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
        System.out.printf("El filósofo %d se marcha del salón.\n",this.numFilosofo);
    }
}
