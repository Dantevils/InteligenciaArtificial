import java.awt.BorderLayout;
import javax.swing.JPanel;

public class PanelDeJuego extends JPanel implements Constantes {
    
    public Lienzo lienzo;
    
    public PanelDeJuego(){
    
        setLayout(new BorderLayout());
        lienzo =new Lienzo();
        lienzo.setFocusable(true);
        lienzo.requestFocus();
        this.add(lienzo);
        this.setSize(lienzo.getWidth(),lienzo.getHeight());
             
             /*lienzo.setFocusable(true);
lienzo.requestFocus();
this.getContentPane().setLayout(new BorderLayout());
this.getContentPane().add(lienzo);
this.setSize(lienzo.getWidth(),lienzo.getHeight());
    System.out.println("tamaño:   "+ lienzo.getWidth());*/
    }
    
}
