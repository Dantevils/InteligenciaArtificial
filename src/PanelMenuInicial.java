
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMenuInicial extends JPanel implements Constantes {
    public JButton comenzar, salir,configuracion,sonido,creditos;
    public JCheckBox with_IA, with_AI2, español, ingles;
    public JLabel labelConfiguracion, labelLoading;
    // public JTextField campo_nombre, campo_email;
    public ImageIcon icono_mundo,loading;
    public String[] tipos_letra;
    public JFrame ventana_principal;
    public boolean toShow_feedback;
    public HiloMusica player;
    public boolean Flag = true;
    public boolean FlagSong = true;
    
    public PanelMenuInicial(JFrame ventana_principal) throws MalformedURLException{
        this.ventana_principal=ventana_principal;
        this.setName("Dantevils Games");
        this.setLayout(null);
        player=new HiloMusica(RUTA+"/src/music/Epilogue.wav",2);
        this.setSize(SCREEN_SIZE.width,SCREEN_SIZE.height);
        toShow_feedback=true;
        
        labelConfiguracion=new JLabel("CONFIGURACION");
        labelConfiguracion.setFont(new Font("Times New Roman", Font.BOLD,40));
        labelConfiguracion.setForeground(Color.orange);
        labelConfiguracion.setBounds(20, 20, 400, 200);
        labelConfiguracion.setVisible(false);
        
        
        labelLoading = new JLabel("L O A D I N G .");
        labelLoading.setFont(new Font("Times New Roman", Font.BOLD,40));
        labelLoading.setForeground(Color.orange);
        labelLoading.setBounds(20, 500, 400, 200);
        labelLoading.setVisible(false);
        
      /*campo_nombre=new JTextField("");
        campo_nombre.setFont(new Font("Times New Roman",Font.BOLD,40));
        campo_nombre.setForeground(Color.LIGHT_GRAY);
        campo_nombre.setCaretColor(Color.orange);
        campo_nombre.setBounds(260, 100, 300, 50);
        campo_nombre.setOpaque(false);
        campo_email=new JTextField("");
        campo_email.setFont(new Font("Times New Roman",Font.BOLD,40));
        campo_email.setForeground(Color.LIGHT_GRAY);
        campo_email.setCaretColor(Color.orange);
        campo_email.setBounds(260, 160, 300, 50);
        campo_email.setOpaque(false);*/
        
        with_IA=new JCheckBox("Jugador IA ",toShow_feedback);
        with_IA.setFont(new Font("Times New Roman", Font.BOLD,30));
        with_IA.setForeground(Color.LIGHT_GRAY);
        with_IA.setBounds(60, 260, 800, 40);
        with_IA.setOpaque(false);
        with_IA.setVisible(false);
        with_IA.addActionListener(this::seleccionarCpuInteligente);
        
        with_AI2=new JCheckBox("Adversario IA",true);
        with_AI2.setFont(new Font("Times New Roman", Font.BOLD,30));
        with_AI2.setForeground(Color.LIGHT_GRAY);
        with_AI2.setBounds(60, 300, 1000, 40);
        with_AI2.setOpaque(false);
        with_AI2.setVisible(false);
        with_AI2.setEnabled(false);
        
        
        
        español=new JCheckBox("Español", false);
        español.setFont(new Font("Times New Roman", Font.BOLD,20));
        español.setForeground(Color.orange);
        español.setBounds(220, 180, 150, 100);
        español.setOpaque(false);
        español.addActionListener(this::seleccionarEspañol);
        español.setVisible(false);
        
        ingles=new JCheckBox("English", true);
        ingles.setFont(new Font("Times New Roman", Font.BOLD,20));
        ingles.setForeground(Color.orange);
        ingles.setBounds(60, 180, 150, 100);
        ingles.setOpaque(false);
        ingles.addActionListener(this::seleccionarIngles);
        ingles.setVisible(false);
        
        comenzar=new JButton("P R E S S   S T A R T");
        comenzar.setBounds(480, 100, 310, 50);
        //comenzar.setOpaque(false);
        comenzar.setFont(new Font("Times New Roman", Font.BOLD,20));
        comenzar.setBackground(Color.WHITE);
        comenzar.setForeground(Color.BLACK);
        comenzar.setHorizontalTextPosition(JButton.CENTER);
        comenzar.setVerticalTextPosition(JButton.CENTER);
        comenzar.addActionListener(this::pulsarBotonComenzar);
        //comenzar.addMouseListener(t);
        
        salir=new JButton("E X I T");
        salir.setBounds(480, 160, 310, 50);/*L*/
        //salir.setOpaque(false);
        salir.setFont(new Font("Times New Roman", Font.BOLD,20));
        salir.setBackground(Color.WHITE);
        salir.setForeground(Color.BLACK);
       // salir.setOpaque(false);
        
/*Funtion*/
/*salir.setOpaque(false);
salir.setContentAreaFilled(false);
salir.setBorderPainted(false);*/


        salir.setHorizontalTextPosition(JButton.CENTER);
        salir.setVerticalTextPosition(JButton.CENTER);
        salir.addActionListener(this::pulsarBotonSalir);
        
        configuracion = new JButton("CONFIGURATION");
        configuracion.setBounds(480,220 , 310, 50);
        configuracion.setFont(new Font("Times New Roman", Font.BOLD,20));
        configuracion.setBackground(Color.WHITE);
        configuracion.setForeground(Color.BLACK);
        configuracion.setHorizontalTextPosition(JButton.CENTER);
        configuracion.setVerticalTextPosition(JButton.CENTER);
        configuracion.addActionListener(this::pulsarBotonConfiguracion);
        
        
        sonido = new JButton("SOUND");
        sonido.setBounds(480,280, 310, 50);
        sonido.setFont(new Font("Times New Roman", Font.BOLD,20));
        sonido.setBackground(Color.WHITE);
        sonido.setForeground(Color.BLACK);
        sonido.setHorizontalTextPosition(JButton.CENTER);
        sonido.setVerticalTextPosition(JButton.CENTER);
        sonido.addActionListener(this::pulsarBotonSonido);
        
        
        
        creditos = new JButton("CREDITS");
        creditos.setBounds(480,340 , 310, 50);
        creditos.setFont(new Font("Times New Roman", Font.BOLD,20));
        creditos.setBackground(Color.WHITE);
        creditos.setForeground(Color.BLACK);
        creditos.setHorizontalTextPosition(JButton.CENTER);
        creditos.setVerticalTextPosition(JButton.CENTER);
        
        
        
        
              
        add(configuracion);
        add(creditos);
        add(sonido);
        add(comenzar);
        add(salir);
        add(labelConfiguracion);
        add(labelLoading);
      
       // add(campo_nombre);
       // add(email);
       // add(campo_email);
        add(with_IA);
        add(with_AI2);
        add(español);
        add(ingles);
        
        player.run();
    }
    
    /*Metodos a llamar, de los ActionListener*/   
    public void pulsarBotonSonido(ActionEvent e){
        if(FlagSong == true){
        player.cancion.stop();
        FlagSong = false;
        }else{
            player.run();
            FlagSong =true;
        }
        
    }   
    private static void delaySegundo()
    {
        try
        {
            Thread.sleep(1000);
        }catch(InterruptedException e){}
    } 
    public void pulsarBotonConfiguracion(ActionEvent e){
        
        if (Flag == true) {
        with_IA.setVisible(true);
        with_AI2.setVisible(true);
        español.setVisible(true);
        ingles.setVisible(true);
        labelConfiguracion.setVisible(true);
        Flag = false;
        }
        else{
        labelConfiguracion.setVisible(false);
        with_IA.setVisible(false);
        with_AI2.setVisible(false);
        español.setVisible(false);
        ingles.setVisible(false);
        Flag = true;
        }
    }
    
    public void pulsarBotonComenzar(ActionEvent e){
       labelLoading.setVisible(true);
        for (int i = 0; i < 2; i++) {
            labelLoading.setVisible(false);
            labelLoading.setText("L O A D I N G...");
            labelLoading.setVisible(true);
        }
       this.player.cancion.stop();
       // if(campo_nombre.getText().isEmpty() && campo_email.getText().isEmpty())
       // {
            //JOptionPane.showMessageDialog(null,"DEBES INTRODUCIR TU NOMBRE","YADY Computer Game",JOptionPane.PLAIN_MESSAGE);
         
       // }else{
            
            /*Configuarar para lanzar el juego*/
           
            //JOptionPane.showMessageDialog(null,"LANZAR EL VIDEO JUEGO", "YADY Computer Game", JOptionPane.PLAIN_MESSAGE);
            System.out.println("INICIO");
            VentanaPrincipal Juego = new VentanaPrincipal();
             Juego.setUndecorated(true);
            Juego.setVisible(true);
            
            
            Juego.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            /*VERIFICAR LA CREACION DE VENTANAS Y ELIMINARLAS*/
            
            this.setVisible(false);
            
          /// System.exit(-1);
            //this.set
            
            
    
                
            if(español.isSelected())
            {
                JOptionPane.showMessageDialog(null,"EN IDIOMA CASTELLANO", "YADY Computer Game", JOptionPane.PLAIN_MESSAGE);
            }
            if(with_AI2.isSelected())
            {
                JOptionPane.showMessageDialog(null,"Jugador Sin IA", "YADY Computer Game", JOptionPane.PLAIN_MESSAGE);
            }
        }
    //}
    
   public void pulsarBotonSalir(ActionEvent e){
       System.exit(0);
   }
   
   public void seleccionarEspañol(ActionEvent e){
       //JOptionPane.showMessageDialog(null,"SE SELECCIONO CASTELLANO", "YADY Computer Game", JOptionPane.PLAIN_MESSAGE);
       ingles.setSelected(false);
       labelConfiguracion.setText("CONFIGURACION");
       comenzar.setText("C O M E N Z A R");
       salir.setText("S A L I R");
       configuracion.setText("C O N F I G U R A C I O N");
       creditos.setText("C R E D I T O S");
       sonido.setText("S O N I D O");
       
   }
   
   public void seleccionarIngles(ActionEvent e)
   {
       //JOptionPane.showMessageDialog(null,"SE SELECCIONO INGLES", "YADY Computer Game", JOptionPane.PLAIN_MESSAGE);
       español.setSelected(false);
       labelConfiguracion.setText("CONFIGURATION");
       comenzar.setText("P R E S S   S T A R T");
       salir.setText("E X I T");
       configuracion.setText("C O N F I G U R A T I O N");
       creditos.setText("C R E D I T S");
       sonido.setText("M U S I C");
   }
   
   public void seleccionarCpuInteligente(ActionEvent e)
   {
      // JOptionPane.showMessageDialog(null,"SE SELECCIONO FEEDBACK INTELIGENTE", "YADY Computer Game", JOptionPane.PLAIN_MESSAGE);
       toShow_feedback = with_IA.isSelected();
     //  IAJUGADOR = true;
   }
   
   @Override
   public void paintComponent(Graphics g){
       
       Dimension d=getSize();
       BufferedImage fondo=null;
       try{
           fondo= ImageIO.read(new File("src/images/fondo2.jpg"));
       }catch(IOException ex){
           Logger.getLogger(PanelMenuInicial.class.getName()).log(Level.SEVERE,null, ex);           
       }
       
       g.drawImage(fondo,0,0,d.width, d.height, null);
     
       
       super.paintComponents(g);
      
   
   }
  
   
   
}
