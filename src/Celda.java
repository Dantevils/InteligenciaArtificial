import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JComponent;


public class Celda extends JComponent implements Constantes {
    public int x;
    public int y;
    public Rectangle rectanguloCelda;
    public int indexSprite;
    public BusquedaAnchuraBall BA;

    /*Atributos para el manejo de Imagenes ó Sprites*/
    public char tipo;
    public static BufferedImage jugador,obstaculo,camino, adversario,item,castle,publico;
    /*Para imagenes sin movimiento, todas las funciones  deben de ser estaticas, para el consumo de memoria*/
    public static BufferedImage sprites[],imagenSprites; 
    public static BufferedImage publico_V[],SecuenciaImg_publico;
    public static BufferedImage jugador_V[],SecuenciaImg_Jugador;
    public static BufferedImage adversario_V[],SecuenciaImg_Adversario;
    public static BufferedImage item_V[],SecuenciaImg_Item;


    /*Constructor de la clase Celda*/
    public Celda(int x,int y,char tipo) {
    this.x=x;
    this.y=y;
    this.tipo=tipo;
    indexSprite=2;
     /*Creacion de los elementos Sin Sprites*/
    try {
   
        obstaculo = ImageIO.read(new File("src/images/obstaculo.png"));
        castle = ImageIO.read(new File("src/images/castle.png"));

        /*Cargada de las imagenes de grupo*/
        SecuenciaImg_Item = ImageIO.read(new File("src/images/balls.png"));
        imagenSprites = ImageIO.read(new File("src/images/snake.png"));
        SecuenciaImg_publico =ImageIO.read(new File("src/images/People.png"));
        SecuenciaImg_Adversario = ImageIO.read(new File("src/images/snake2.png"));
        /*Array 4x3 de contenido para las imagenes en movimiento*/
        sprites= new BufferedImage[4*3];
        item_V = new BufferedImage[4*3];
        publico_V =  new BufferedImage[4*3];
        adversario_V = new BufferedImage[4*3];
        /*Es recorido separando las imagenes*/
        loadSprite(); /*Con esta funcion cargamos las imagenes*/
    } catch (IOException e) {
    System.out.println(e.toString());
    }
}
    /*Metodo para dibujar Celdas,la cual hace uso del metodo drawRect*/
    @Override
    public void paintComponent(Graphics g) {
        update(g);

    }

    @Override
    public void update(Graphics g){     
        switch(tipo) {

        case 'J': g.drawImage(sprites[indexSprite],x,y, null); break; /*Para el Tipo Juegador*/
        
        case 'O': g.drawImage(obstaculo,x,y, this); break;/*Para el tipo Obstaculo*/
        
        case 'C': g.drawImage(castle,x,y, this); break;/*Para las celdas en blanco*/

        case 'V': //g.setColor(COLORFONDO);
                  //g.fillRect(x, y, anchuraCelda, alturaCelda);
                  g.drawImage(camino,x,y, this); 
                  break;
        case 'A': g.drawImage(adversario_V[indexSprite],x,y, null); break;

        case 'I': g.drawImage(item_V[indexSprite],x,y, this); break;
        
        case 'P': g.drawImage(publico_V[indexSprite],x,y, this); break;
        }
    }

    public static void loadSprite(){
        for(int i=0; i<3 ;i++){
                        for(int j=0;j<4;j++){
                             sprites[(i*4)+j]= imagenSprites.getSubimage(i*anchuraCelda, j*alturaCelda, anchuraCelda, alturaCelda);
                            //jugador_V[(i*4)+j]=SecuenciaImg_Jugador.getSubimage(i*anchuraCelda, j*alturaCelda, anchuraCelda, alturaCelda);
                            adversario_V[(i*4)+j]=SecuenciaImg_Adversario.getSubimage(i*anchuraCelda, j*alturaCelda, anchuraCelda, alturaCelda);
                          publico_V[(i*4)+j]=SecuenciaImg_publico.getSubimage(i*anchuraCelda, j*alturaCelda, anchuraCelda, alturaCelda);
                            item_V[(i*4)+j]=SecuenciaImg_Item.getSubimage(i*anchuraCelda, j*alturaCelda, anchuraCelda, alturaCelda);
                        }

        }
    }
    
    /*Para editar si el click se encuentra en la celda, dibujamos*/
    public boolean celdaSeleccionada(int xp,int yp) {
        return  rectanguloCelda.contains(new Point(xp,yp));
    }
}
