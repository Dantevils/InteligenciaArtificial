//import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeListener;

public class InnerMenu extends JPanel implements ActionListener{
    
    public JSlider IA_Jugador_Barra, IA_Adversario_Barra;
    public JLabel Jlabel_Jugador,Jlabel_Adversario;
    public JButton Bto_Iniciar, Bto_Finalizar,Bto_Sonido,Bto_on_sound;
    //public HiloMusica player;    
    
    /*Constructor*/
 public InnerMenu(){
   // this.setLayout(new Grindlayout(5,5));
    this.setLayout(null);
    this.setBackground(Color.LIGHT_GRAY);
    //this.setSize(800, 400);
    //player=new HiloMusica(ruta+"/music/tears.wav",2);
    
    IA_Jugador_Barra = new JSlider(JSlider.HORIZONTAL,0,100,60);
    IA_Jugador_Barra.setValue(0);
    IA_Jugador_Barra.setPaintTicks(true);
    IA_Jugador_Barra.setMajorTickSpacing(1);
    IA_Jugador_Barra.setMinorTickSpacing(0);
    IA_Jugador_Barra.setBorder(new TitledBorder("Jugador"));
    IA_Jugador_Barra.setMaximum(3);
    IA_Jugador_Barra.setMinimum(0);
    
        //Label de tabla-barra
        Dictionary labelTable = new Hashtable();
        labelTable.put( 0, new JLabel("NV0") );
        labelTable.put( 1, new JLabel("NV1") );
        labelTable.put( 2, new JLabel("NV2") );
        labelTable.put( 3, new JLabel("NV3") );
        
    IA_Jugador_Barra.setLabelTable( labelTable );
    IA_Jugador_Barra.setPaintLabels(true); 
   // IA_Jugador_Barra.addChangeListener(new SliderListener());
  
    IA_Adversario_Barra =new JSlider(JSlider.HORIZONTAL,0,100,60);
    IA_Adversario_Barra.setValue(0);
    IA_Adversario_Barra.setPaintTicks(true);
    IA_Adversario_Barra.setMajorTickSpacing(1);
    IA_Adversario_Barra.setMinorTickSpacing(0);
    IA_Adversario_Barra.setMaximum(3);
    IA_Adversario_Barra.setMinimum(0);
    IA_Adversario_Barra.setBorder(new TitledBorder("Adversarios"));
    IA_Adversario_Barra.setLabelTable(labelTable);
    IA_Adversario_Barra.setPaintLabels(true);
  //  IA_Adversario_Barra.addChangeListener(new SliderListener());
    
    /*Nombres de Botones y Labels*/
    
    Jlabel_Jugador = new JLabel("Jugador");/*AL FINAL AGERGAR MINITOS*/ 
    Jlabel_Adversario = new JLabel("Adversarios");
    
    Bto_Iniciar =  new JButton("Iniciar");
    Bto_Finalizar =  new JButton("Finalizar");
    Bto_Sonido =  new JButton("Sonido:OFF");
    Bto_on_sound =new JButton("Sonido:ON");
    
    /*Pocicion de los objetos 768 1366*/
    // Jlabel_Jugador.setBounds(10, 10, 50, 50); Los intalamos despues
    IA_Jugador_Barra.setBounds(20, 713, 200, 55);
    //Jlabel_Adversario.setBounds(60, 60, 100, 100); Los intalamos despues
    IA_Adversario_Barra.setBounds(230, 713, 200, 55);/* x,y,ancho,alto*/
    Bto_Iniciar.setBounds(1066, 718, 100, 50);
    Bto_Finalizar.setBounds(1166, 718, 100, 50);
    Bto_Sonido.setBounds(1266,718,100,50);
    Bto_on_sound.setBounds(1266,718,100,50);
    Bto_on_sound.setVisible(false);
     //IA_Jugador_Barra.setVisible(true);
      
    /* Añadir  al contructor*/
     this.add(IA_Jugador_Barra);
     this.add(Jlabel_Jugador);
     this.add(IA_Adversario_Barra);
     this.add(Jlabel_Adversario);
     this.add(Bto_Iniciar);
     this.add(Bto_Finalizar);
     this.add(Bto_Sonido);
     this.add(Bto_on_sound);
     
     /*
     Bto_Iniciar.addActionListener(this);
     Bto_Finalizar.addActionListener(this);
     Bto_Sonido.addActionListener(this);
     Bto_on_sound.addActionListener(this);
     */
      
    /*Implementar luego Con IA*/
     
     // player.run();
    /*
     IA_Jugador_Barra.addChangeListener( new ChangeListener() {
      public void stateChanged( ChangeEvent evt ) {
        barraProg.setValue(barraSlid.getValue() );
      }
    }
    */
    }

 
    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource() == Bto_Finalizar ){
        System.exit(0); 
     }     
     if(e.getSource() == Bto_Iniciar ){
        System.out.println("INICIAR NUEVAMENTE EL JUEGO LAUNCHER INTERNO");
        /*this.setVisible(false);
           VentanaPrincipal Game=new VentanaPrincipal ();
            Game.setVisible(true); 
            Game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Game.setSize(1050+350,730);//Tamaño del lienzo
                */
                //Game.setResizable(false);
                                    /*Restaurar todo lo de ariba, con la condicion*/
                                    /*Creacion del menu principal*/
       }
      if(e.getSource() == Bto_Sonido ){
     //   player.cancion.stop(); 
        Bto_Sonido.setEnabled(false);
        Bto_Sonido.setVisible(false);
        Bto_on_sound.setEnabled(true);
        Bto_on_sound.setVisible(true);       
       }
     
       if(e.getSource() == Bto_on_sound ){
       // player.run();
        Bto_on_sound.setEnabled(false);
        Bto_on_sound.setVisible(false);
        Bto_Sonido.setEnabled(true);
        Bto_Sonido.setVisible(true);
       }
    
    }

 
}
