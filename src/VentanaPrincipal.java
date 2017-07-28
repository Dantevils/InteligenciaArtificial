/*paquetes que utilizaremos:
-la clase JFrame nos proporciona funcionalidad para crear ventanas
-la clase BorderLayout nos proporciona funcionalidad para distribuir los
elemtnos graficos*/
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
/*clase VetanaPrincipal hereda de JFrame para obtener funcionalidad
de creacion de ventanas graficas*/
public class VentanaPrincipal extends JFrame implements Constantes{
//nuestra clase se compone de un lienzo de dibujo (herada de canvas)
public JSplitPane panelSeparador;
public PanelDeJuego panelJuego;    
public HiloMusica player;
public Lienzo lienzo;
public PanelConfiguracion panelConfiguracion;
public InnerMenu Imenu;


//constructor
public VentanaPrincipal() {
    /*
     panelSeparador = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    panelSeparador.setOneTouchExpandable(true);
    
   panelJuego = new PanelDeJuego();
   
   panelConfiguracion = new PanelConfiguracion(panelJuego);
   
  
   
   
   panelSeparador.setLeftComponent(panelJuego);
   panelSeparador.setRightComponent(panelConfiguracion);
   panelSeparador.setDividerLocation(panelJuego.getWidth()+20);
   panelSeparador.setDividerSize(8);
   
   
   
   getContentPane().setLayout(new BorderLayout());
   getContentPane().add(panelSeparador,BorderLayout.CENTER);
   
   this.setSize(SCREEN_SIZE.width, SCREEN_SIZE.height); 1366x768
   */
  
  
lienzo=new Lienzo();
Imenu = new InnerMenu();
player=new HiloMusica(RUTA+"/src/music/Village.wav",2);
player.run();



   
 lienzo.setFocusable(true);
lienzo.requestFocus();
this.getContentPane().setLayout(new BorderLayout());
this.getContentPane().add(lienzo);
this.getContentPane().add(Imenu);
  
this.setSize(lienzo.getWidth()+12,lienzo.getHeight()+64);
    
    

           
           }
}