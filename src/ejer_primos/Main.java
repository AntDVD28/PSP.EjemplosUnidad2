package ejer_primos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Enunciado del ejercicio: Se nos proporciona una clase ComprobadorPrimo de
 * tipo hilo (Thread) que recibe en su constructor un número entero (long) que
 * cuando es lanzado a ejecutarse intenta calcular si el número pasado como
 * parámetro al constructor es un número primo. Cuando haya obtenido un
 * resultado (si el número es primo o no), se mostrará por la consola. Escribir
 * un programa principal que lea de un archivo de texto cuyo nombre se pasará
 * como parámetro desde la consola (args[0]). Ese archivo de texto contendrá
 * números enteros (uno por línea) que habrá que ir leyendo y almacenando en
 * alguna estructura (lista, array, conjunto, etc.). Si alguna línea no contiene
 * algo que pueda ser interpretado como un número entero grande en Java (un
 * long) se descartará y no se introducirá en la estructura de almacenamiento.
 * Una vez se disponga de todos los números, se recorrerá la estructura de
 * almacenamiento y se lanzará un hilo de tipo ComprobadorPrimo por cada número
 * para que se vayan realizando las comprobaciones concurrentemente. A partir de
 * ahí ya se encargarán los hilos de mostrar por pantalla sus resultados según
 * vayan siendo calculados. Si todo funciona correctamente, los números que son
 * primos grandes deberían ser los que más se tardara en calcular que son primos
 * y deberían ser los últimos en aparecer en pantalla. También deberían tardar
 * algo más en calcularse aquellos que sean divisibles por números grandes,
 * aunque normalmente se tardará menos que con un número primo (dependerá de
 * cómo de grande sea su divisor más pequeño encontrado). Sin embargo, para
 * aquellos que sean divisibles por números pequeños (2, 3, 5, 7, 11, 13, 17,
 * etc.) su solución aparecerá casi inmediatamente, pues será muy rápida su
 * resolución.
 */
/**
 * Clase Principal
 * @author David Jiménez Riscardo
 * @version 1.0
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String nombreFichero = null;
        //Estructura de datos donde guardaremos los números del fichero
        ArrayList<String> lista = null;
        //Estructura de datos dónde guardaremos una referencia a los hilos generados
        List<Thread> misHilos = new LinkedList<>();
        
        
        //Leo el nombre del fichero desde la consola
        if(args.length!=1){
            System.out.println("Parámetros erróneos");
            System.exit(0);
        }else{
            nombreFichero = args[0];
        }
        
        System.out.println("COMPROBACIÓN DE NÚMEROS PRIMOS");
        System.out.println("------------------------------");
        System.out.println("Leyendo archivo de entrada.");
        
        //Volcamos el contenido del fichero a un ArrayList
        try {
            lista = Main.leeLineasDeFichero(nombreFichero);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Números leídos:"+lista.toString());
        
        //Instancio los hilos y los guardo en una lista de hilos      
        for(int i=0;i<lista.size();i++){           
            long num = Long.valueOf(lista.get(i));
            ComprobadorPrimo cp = new ComprobadorPrimo(num);
            misHilos.add(cp);        
        }
        
        //Recorro mi lista de hilos y los lanzo
        System.out.println("Lanzando comprobadores concurrentes de primalidad");
        for(Thread hilo : misHilos){
            hilo.start();
        }
        
        //Espero a que todos los hilos finalicen para finalizar el programa principal
        for(Thread hilo : misHilos){
            try {
                hilo.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Fin del programa");
             
    }//Fin del main
    
    /**
     * Método para devolver cada línea de un fichero en una estructura (@link ArrayList)
     * Sólo agregaremos a la lista los enteros grandes (long)
     * @param nombreFichero Nombre del fichero
     * @return Estructura de tipo (@link ArrayList)
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static ArrayList<String> leeLineasDeFichero(String nombreFichero) throws FileNotFoundException, IOException{
        
        ArrayList<String> lista = new ArrayList<>();
        
        FileReader fr = new FileReader(nombreFichero);
        BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();
                
        while( linea != null ){
            //Comprobamos si es un entero largo
            if(isLong(linea))
                lista.add(linea);
            
            linea = br.readLine();
        }
        
        if( br != null ) br.close();
        if( fr != null ) fr.close();  
        
        return lista;
    }
    
    /**
     * Método para comprobar si una cadena recibida es un entero largo
     * @param cadena Cadena recibida
     * @return Valor booleano, true si la cadena es un entero largo, false en caso contrario
     */
    public static boolean isLong(String cadena) {

        boolean resultado;

        try {
            Long.valueOf(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
    
}