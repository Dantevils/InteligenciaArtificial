import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelConfiguracion extends JPanel implements Constantes{
public JLabel velocidad;
public JSlider cambiarVelocidad;
public PanelDeJuego panelJuego;
public PanelConfiguracion(PanelDeJuego panelJuego) {
this.panelJuego=panelJuego;
//configuramos etiqueta
velocidad=new JLabel("Cambiar Velocidad");
velocidad.setForeground(Color.yellow);
velocidad.setFont(fuente);
//
cambiarVelocidad = new JSlider(JSlider.VERTICAL,
VELOCIDAD_MINIMA, VELOCIDAD_MAXIMA,VELOCIDAD_INICIAL);
//cambiarVelocidad.addChangeListener(this::escuchadorslider);
cambiarVelocidad.addChangeListener(new ChangeListener() {
@Override
public void stateChanged(ChangeEvent e) {
escuchadorslider(e);
}
});
cambiarVelocidad.setMajorTickSpacing(100);
cambiarVelocidad.setPaintTicks(true);
this.setBackground(Color.gray);
this.setLayout(new BorderLayout());
add(velocidad,BorderLayout.WEST);
add(cambiarVelocidad,BorderLayout.CENTER);
}
public void escuchadorslider(ChangeEvent e) {
JSlider source = (JSlider)e.getSource();
if (!source.getValueIsAdjusting()) {
System.out.println(" Velocidad "+source.getValue());
//panelJuego.lienzo.Hero.tiempoDormido=source.getValue();
}
}
}