import java.net.MalformedURLException;
import javax.swing.JFrame;


public class VentanaMenuInicial extends JFrame{
   
    public PanelMenuInicial panel;
    
    public VentanaMenuInicial() throws MalformedURLException{
    panel = new PanelMenuInicial(this);
    this.getContentPane().add(panel);
    this.setSize(panel.getSize());
    
    }
    
}
