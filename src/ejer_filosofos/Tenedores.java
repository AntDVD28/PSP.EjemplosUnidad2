package ejer_filosofos;

/**
 * Recurso a compartir
 * @author David Jiménez Riscardo
 */
public class Tenedores {
    private int[] tenedores;
    
    public Tenedores(){
        tenedores = new int[5];
        for(int i=0;i<tenedores.length;i++){
            tenedores[i]=0;
        }
    }
    
    public boolean puedeComer(int pos){
        if(tenedores[pos]==0 && tenedores[(pos+1)%5]==0){
            return true;
        }else{
            return false;
        }
    }
    
    public void comer(int pos){
        tenedores[pos]=1;
        tenedores[(pos+1)%5]=1;
    }
    
    public void dejarDeComer(int pos){
        tenedores[pos]=0;
        tenedores[(pos+1)%5]=0;
    }
}
