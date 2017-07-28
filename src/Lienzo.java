/*Paquetes que utilizaremos*/
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


/*La clase Lienzo hereda de Canvas Pinta el lienzo*/
public class Lienzo extends Canvas implements Constantes{
public Laberinto laberinto;
public Image fondo,winner,loser;
public Graphics graficoBuffer;
public Image imagenBuffer;
public Adversario adversario,adversario2,adversario3;
public Jugador Hero,Hero2,Hero3;
public Item Pelota;
public Timer lanzadorTareas;
public int j1,i1;
public int count = 0;
public int GOLHERO=0;
public int GOLADVERSARIO=0;

/*Construtor de Lienzo*/
public Lienzo(){
    
laberinto=new Laberinto(this);

/*Creadores de Mapa, o niveles de juegos*/
    //Word1();
    //Word2();
    Word3();
/*Integracion de los Personajes y ambiente*/
Hero = new Jugador(laberinto);
//Hero2 = new Jugador(laberinto);
//Hero3 = new Jugador(laberinto);
Pelota = new Item(laberinto);
adversario = new Adversario(laberinto);
//adversario2 = new Adversario(laberinto);
//adversario3 = new Adversario(laberinto);

//Hero.BA.destinos.add(new Estado(Pelota.item.x,Pelota.item.y,'N',null));

//Pelota.BAB.buscar(Pelota.item.x,Pelota.item.y,anchuraMundoVirtual-2, alturaMundoVirtual/2);


//Pelota.BAB.add(new Estado(anchuraMundoVirtual-2,alturaMundoVirtual/2,'N',null));

Pelota.BAB.destinos.add(new Estado(anchuraMundoVirtual-2,alturaMundoVirtual/2,'N',null));
Pelota.BAB.destinos2.add(new Estado(0,alturaMundoVirtual/2,'N',null));
Pelota.BAB.destinos3.add(new Estado(anchuraMundoVirtual/2,numeroAleatorio(4,alturaMundoVirtual-2),'N',null));
//this.laberinto.celdas[anchuraMundoVirtual-2][alturaMundoVirtual/2].tipo='C';

//adversario.BA.destinos.add(new Estado(Pelota.item.x,Pelota.item.y,'N',null));
//adversario3 = new Adversario(laberinto);

/*Busqueda por anchura*/
    /*BA = new BusquedaAnchura(laberinto);
    laberinto.LienzoPadre.Hero.BA.buscar(laberinto.LienzoPadre.Hero.jugador.x,laberinto.LienzoPadre.Hero.jugador.y, 13, 13);
    laberinto.LienzoPadre.Hero.BA.calcularRuta();*/
   /* for (int i = 0; i < anchuraMundoVirtual; i++) {
        for (int j = 0; j < alturaMundoVirtual; j++) {
            if (laberinto.celdas[i][j].tipo == 'I') {
                this.i1 = i;
                this.j1 = j;
                //SE PODRIA RETORNAR UN ESTADO PARA LA BUSQUEDA DE LA PELOTA
                      
            }
        }
    }*/
    
    /*Buscar a jugador*/
   


//Hero.BA.destinos.add(new Estado(i1,j1,'N',null));

//Hero.BA.destinos.add(new Estado(13,13,'N',null));
//Hero.BA.destinos.add(new Estado(2,7,'N',null));

//adversario.BA.destinos.add(new Estado(i1,j1,'N',null));


/*Colocamos el fondo*/
try{ 
    fondo = ImageIO.read(new File("src/images/fondo.jpg"));
    winner = ImageIO.read(new File("src/images/win.png"));
    loser = ImageIO.read(new File("src/images/loser.png"));
}catch (IOException e) {
    System.out.println(e.toString() + "Imagen no Encontrada");}
//this.setBackground(Color.green);

/*Dimensiones del lienzo*/
this.setSize(laberinto.anchuraLaberinto+34,laberinto.alturaLaberinto+8);
//1344 x 704

/*Añadimos el escuchador de mouse*/
/*addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent evt) {
activarCelda(evt);
repaint();
}
});*/

/*Escuchador eventos de teclado*/
addKeyListener(new java.awt.event.KeyAdapter() {
@Override
public void keyPressed(KeyEvent evt) {
    try {
        laberinto.moverCelda(evt);
    } catch (InterruptedException ex) {
        Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
    }
repaint();
}
}); //MODIFIACION AL TRY AND CATCH

/*Lanzador de hilos de busquedas*/
lanzadorTareas=new Timer();
lanzadorTareas.scheduleAtFixedRate(adversario.BA,0,700);
//lanzadorTareas.scheduleAtFixedRate(adversario2.BA,0,500);
//lanzadorTareas.scheduleAtFixedRate(adversario3.BA,0,500);
//lanzadorTareas.scheduleAtFixedRate(Pelota,0,100);
//lanzadorTareas.scheduleAtFixedRate(Hero.BA,0,600);
//lanzadorTareas.scheduleAtFixedRate(Hero2.BA,0,600);
//lanzadorTareas.scheduleAtFixedRate(Hero3.BA,0,600);

//lanzadorTareas.scheduleAtFixedRate(adversario2,0,1000);
//lanzadorTareas.scheduleAtFixedRate(adversario3,0,1000);
lanzadorTareas.scheduleAtFixedRate(Pelota.BAB,0,700);

}
//metodo llamada la primera vez que se pinta

@Override
public void update(Graphics g){
    /**/
  //inicialización del buffer gráfico mediante la imagen
    Date fecha = new Date();
    if(graficoBuffer==null){
    imagenBuffer=createImage(this.getWidth(),this.getHeight());
    graficoBuffer=imagenBuffer.getGraphics();
    }
    //volcamos color de fondo e imagen en el nuevo buffer grafico
    graficoBuffer.setColor(getBackground());
    graficoBuffer.fillRect(0,0,this.getWidth(),this.getHeight());
    graficoBuffer.drawImage(fondo, 0, 0, null);
   
    graficoBuffer.setFont(fuente);
    
    graficoBuffer.setColor(Color.lightGray);
    graficoBuffer.fillRect(645, 40,80 ,60);
    
    graficoBuffer.setColor(Color.black);

    int diferencia =Math.abs((adversario.adversario.x )- (Hero.jugador.x));
    int time = fecha.getSeconds();
    if (time>=58) {
        count ++;
    }
    laberinto.update(graficoBuffer);
  graficoBuffer.drawString(GOLADVERSARIO +"||"+ GOLHERO, 660,64);
  //graficoBuffer.drawRect(60, 80,665 ,100);
 
  graficoBuffer.drawString(""+count+":"+fecha.getSeconds(), 662,100);
 
   //graficoBuffer.drawRect(645, 40,80 ,60);
 
    
   /**/
  //g.drawImage(fondo, 0, 0, null);
  //laberinto.paintComponent(g);
    if (GOLADVERSARIO == 2) {
        this.Pelota.player1.run();
        this.Pelota.player2.run();
        graficoBuffer.setFont(new Font("Comic Sans",Font.BOLD,80));
        graficoBuffer.setColor(Color.black);
        graficoBuffer.drawString("PERDEDOR",542,180);
        graficoBuffer.drawImage(loser, 500, 200, null);
        lanzadorTareas.cancel();
        
    }
    if (GOLHERO == 2) {
         /*Canselar HILOS*/
        this.Pelota.player1.run();
        this.Pelota.player2.run();
        graficoBuffer.setFont(new Font("Comic Sans",Font.BOLD,80));
        graficoBuffer.setColor(Color.black);
        graficoBuffer.drawString("GANADOR",542,180);
        graficoBuffer.drawImage(winner, 500, 200, null);
        lanzadorTareas.cancel();
        
    }
    //pintamos la imagen previa
    g.drawImage(imagenBuffer, 0, 0, null);
}

@Override
public void paint(Graphics g) {
    update(g);
}

private void activarCelda(MouseEvent evt) {
for(int i=0; i < anchuraMundoVirtual; i++)
for ( int j=0 ; j <  alturaMundoVirtual ; j++)
laberinto.celdas[i][j].celdaSeleccionada(evt.getX(),evt.getY());
}

private  void Word2(){
    
  this.laberinto.celdas[4][16].tipo='C';
  this.laberinto.celdas[anchuraMundoVirtual/2][alturaMundoVirtual-4].tipo='C';
for (int o = 2; o <= 3; o++) {
     
            for (int p = 1; p <= 9; p++) {
              this.laberinto.celdas[o][p].tipo='O';
              
            }
        }
          for (int o = 5; o <= 6; o++) {
            for (int p = 9; p <= 15; p++) {
              this.laberinto.celdas[o][p].tipo='O';
            }
        }
            for (int o = 8; o <= 9; o++) {
            for (int p = 11; p <= 19; p++) {
              this.laberinto.celdas[o][p].tipo='O';
            }
        }
             for (int o =10; o <= 11; o++) {
            for (int p = 4; p <= 8; p++) {
              this.laberinto.celdas[o][p].tipo='O';
            }
        }
              for (int o =12; o <=13 ; o++) {
            for (int p = 5; p <= 9; p++) {
              this.laberinto.celdas[o][p].tipo='O';
            }
        }
                 for (int o =14; o <=15 ; o++) {
            for (int p = 3; p <= 7; p++) {
              this.laberinto.celdas[o][p].tipo='O';
            }
        }


}
private  void Word1(){

for (int o = 10; o <= 13; o++) {
            for (int p = 12; p <= 16; p++) {
              this.laberinto.celdas[o][p].tipo='O';
            }
        }
          for (int o = 16; o <= 20; o++) {
            for (int p = 3; p <= 10; p++) {
              this.laberinto.celdas[o][p].tipo='O';
            }
        }
            for (int o =26 ; o <= 30; o++) {
            for (int p = 3; p <= 12; p++) {
              this.laberinto.celdas[o][p].tipo='O';
            }
        }
             for (int o =32; o <= 36; o++) {
            for (int p = 0; p <= 19; p++) {
              this.laberinto.celdas[o][p].tipo='O';
            }
        }
              for (int o =1; o <=13 ; o++) {
            for (int p = 0; p <= 10; p++) {
              this.laberinto.celdas[o][p].tipo='O';
            }
        }
                 for (int o =5; o <=17 ; o++) {
            for (int p = 0; p <= 10; p++) {
              this.laberinto.celdas[o][p].tipo='O';
            }
        }
                 

}   
public static int Rand_Mod_Sprite(){
    Random rand = new Random();
    int sprite = rand.nextInt(8);
    while(sprite%4 != 0){
    sprite = rand.nextInt(8);
    }
    return sprite;
    } 
private void Word3(){
    //altura 22
    //anchura 42
    int sprite2 =11;
    for (int i = 0; i <22 ; i++) {
          this.laberinto.celdas[0][i].tipo='O';
          this.laberinto.celdas[anchuraMundoVirtual-2][i].tipo='P';
          this.laberinto.celdas[anchuraMundoVirtual-1][i].tipo='P';
          
          this.laberinto.celdas[anchuraMundoVirtual-2][i].indexSprite=sprite2--;
          this.laberinto.celdas[anchuraMundoVirtual-1][i].indexSprite=Rand_Mod_Sprite();
          if (sprite2<0) {
            sprite2 = 11;
            }
          
    }
    int sprite = 1;
    
    for (int j = 0; j < 42; j++) {
        
        this.laberinto.celdas[j][0].tipo = 'P';
         this.laberinto.celdas[j][0].indexSprite= sprite++;
         if (sprite>11) {
            sprite = 0;
        }
        this.laberinto.celdas[j][alturaMundoVirtual-1].tipo='O';
            
    }
    
   /*Ubicacion de los aros*/
   this.laberinto.celdas[0][(alturaMundoVirtual/2)-1].tipo='C';
   this.laberinto.celdas[0][alturaMundoVirtual/2].tipo='C';
   this.laberinto.celdas[0][(alturaMundoVirtual/2)+1].tipo='C';
   this.laberinto.celdas[1][(alturaMundoVirtual/2)-1].tipo='C';
   this.laberinto.celdas[1][alturaMundoVirtual/2].tipo='C';
   this.laberinto.celdas[1][(alturaMundoVirtual/2)+1].tipo='C';
     this.laberinto.celdas[2][(alturaMundoVirtual/2)-1].tipo='C';
   this.laberinto.celdas[2][alturaMundoVirtual/2].tipo='C';
   this.laberinto.celdas[2][(alturaMundoVirtual/2)+1].tipo='C';
      
   this.laberinto.celdas[anchuraMundoVirtual-2][alturaMundoVirtual/2].tipo='C';
   this.laberinto.celdas[anchuraMundoVirtual-2][(alturaMundoVirtual/2)-1].tipo='C';
   this.laberinto.celdas[anchuraMundoVirtual-2][(alturaMundoVirtual/2)+1].tipo='C';
    this.laberinto.celdas[anchuraMundoVirtual-1][alturaMundoVirtual/2].tipo='C';
   this.laberinto.celdas[anchuraMundoVirtual-1][(alturaMundoVirtual/2)-1].tipo='C';
   this.laberinto.celdas[anchuraMundoVirtual-1][(alturaMundoVirtual/2)+1].tipo='C';
    this.laberinto.celdas[anchuraMundoVirtual-3][alturaMundoVirtual/2].tipo='C';
   this.laberinto.celdas[anchuraMundoVirtual-3][(alturaMundoVirtual/2)-1].tipo='C';
   this.laberinto.celdas[anchuraMundoVirtual-3][(alturaMundoVirtual/2)+1].tipo='C';
}

}