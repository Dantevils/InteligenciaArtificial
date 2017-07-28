
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Random;

/*Interfaz de constantes para variables de configuracion globales*/
    public interface Constantes {
    public final int anchuraCelda=32;
    public final int alturaCelda=32;
    public final int anchuraMundoVirtual=42;//42 1344 x 704
    public final int alturaMundoVirtual=22;//22 704
    
    public  boolean IAJUGADOR = false;
    
    
/*Para el manejo de caracteres para el manejo de celdas*/
    public final char JUGARDOR='J';
    public final char CAMINO='V';
    public final char OBSTACULO='O';
    public final char ADVERSARIO='A';
    
    
    public final int ALFA=127;
    public final Color COLORFONDO = new Color(153,217,234,ALFA);
    
   public final String RUTA="file:///"+System.getProperty( "user.dir" );
   
   public final Font fuente= new Font("Time New Roman",Font.BOLD,28);
   
  /*Variables para el manejo de la velocidad al run*/
  
   public final Dimension SCREEN_SIZE =  Toolkit.getDefaultToolkit().getScreenSize();
   public final int VELOCIDAD_MINIMA = 300;
   public final int VELOCIDAD_MAXIMA = 2000;
   public final int VELOCIDAD_INICIAL = 1000;
   
  /*Manipulador del lanzador*/
   public int FUENTE_SIZE = 12;
   public int CELDA_SIZE = 32;
   public int N = 31;
   public int M = 21;
  // public Dimension SCREEN_SIZE 
   public String RUTA_DIRECTORIO = System.getProperty("user.dir");
   
   
   default void setIAJUGADOR(boolean x){
   
  /**IAJUGADOR = x;**/
  
  
   }
   
   
   default int numeroAleatorio(int minimo, int maximo) {

Random random = new Random();
int numero_aleatorio = random.nextInt((maximo - minimo) + 1) + minimo;
return numero_aleatorio;
   }
   
}
