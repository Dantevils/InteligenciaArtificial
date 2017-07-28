
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/*Programa Principal Lanzador de la Ventana*/
public class Main {
    
    public static void main(String[]args) throws IOException{
        
        VentanaMenuInicial menuInicial = new VentanaMenuInicial();
        
        menuInicial.setIconImage(ImageIO.read(new File("src/images/icon.png")));//Agregar ICON              
        menuInicial.setTitle("::Dantevils::");
        menuInicial.setUndecorated(true);
        menuInicial.setVisible(true);
        menuInicial.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    
       // vp.setUndecorated(true);// Elimina los la tableta del juego y deja en pantalla completa
       // Menuinicial.setExtendedState(JFrame.MAXIMIZED_BOTH);    //vp.setSize(800, 600);
    }
    
}
