import java.awt.Graphics;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;
import java.util.Random;
import javax.swing.JComponent;

/*Clase Laberinto*/
public class Laberinto extends JComponent implements Constantes {
public int anchuraLaberinto,alturaLaberinto;//Dimensiones del laberinto
public Celda[][] celdas;// Celdas de n x m
public Celda celdaMovimiento;
public Lienzo LienzoPadre;
//public Jugador Hero;

public Laberinto(Lienzo LienzoPadre) {
    
    this.LienzoPadre = LienzoPadre;
    celdas=new Celda[anchuraMundoVirtual][alturaMundoVirtual];
    //Inicializar el array de celdas
    for(int i=0; i < anchuraMundoVirtual; i++)
    for ( int j=0 ; j <  alturaMundoVirtual ; j++)
    celdas[i][j]=new Celda(i+(i*anchuraCelda),j+(j*alturaCelda),'V');
    
    //  celdaMovimiento=new Celda(6,6,'J'); /*Jugador Ocupable*/
    
//    celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='J';
    
    //celdas[5][5].tipo='O'; 
    //celdas[13][13].tipo='I';  
    //Ancho y largo del laberinto
    this.anchuraLaberinto=anchuraMundoVirtual*anchuraCelda;
    this.alturaLaberinto=alturaMundoVirtual*alturaCelda;
    this.setSize(anchuraLaberinto,alturaLaberinto);
}
/*Movimiento de los Sprite*/
    public static int Rand_Mod_Sprite(){
    Random rand = new Random();
    int sprite = rand.nextInt(8);
    while(sprite%4 != 0){
    sprite = rand.nextInt(8);
    }
    return sprite;
    }   
    
    /*Movimientos por teclado KeyEvent*/
    public void moverCelda(KeyEvent evento) throws InterruptedException{
        switch(evento.getKeyCode()){
        
            case KeyEvent.VK_UP:
               //moverCeldaArriba();
               LienzoPadre.Hero.moverCeldaArriba();
              break;
            
            case KeyEvent.VK_DOWN:
             // moverCeldaAbajo();
                LienzoPadre.Hero.moverCeldaAbajo();
             break;
            
            case KeyEvent.VK_LEFT:
           //    moverCeldaIzquierda();
                 LienzoPadre.Hero.moverCeldaIzquierda();
            break;
                
            case KeyEvent.VK_RIGHT:
         //     moverCeldaDerecha();
                LienzoPadre.Hero.moverCeldaDerecha();
            break;
                
            case  KeyEvent.VK_Q:
                moverCeldaIzquierdaArriba();
            break;
            
            case KeyEvent.VK_E:
                moverCeldaDerechaArriba();
            break;
             
            case KeyEvent.VK_Z:
                moverCeldaIzquierdaAbajo();
            break;
                
            case KeyEvent.VK_C:
                moverCeldaDerechaAbajo();
            break;
                
            case KeyEvent.VK_ENTER:
          System.out.println("PAUSE - MENU");
          /*Pasar todos los celdas = objetos*/
         /*Desplaegar Menu de modificaciones*/
          
      
          this.LienzoPadre.lanzadorTareas.cancel();
          
            break;
                
            case KeyEvent.VK_ESCAPE:
                System.out.println("SALIR");
                System.exit(0);
          //this.LienzoPadre.Hero.wait(100000);
          // this.LienzoPadre.adversario1.run();
          // this.LienzoPadre.lanzadorTareas.schedule(null, null);
          //this.LienzoPadre.lanzadorTareas.scheduleAtFixedRate(this.LienzoPadre.Hero, 0, 500);
          //scheduleAtFixedRate
            break;
        }
                 }
    
/*Movimientos del jugador manipulable*/    
    
    public void moverCeldaArriba(){
        if (celdaMovimiento.y > 0) {
            System.out.println("arriba-paret");
            if ( celdas[celdaMovimiento.x][celdaMovimiento.y-1].tipo != 'O' && celdas[celdaMovimiento.x][celdaMovimiento.y-1].tipo != 'A'&& celdas[celdaMovimiento.x][celdaMovimiento.y-1].tipo != 'C'){
                System.out.println("arriva");
                if (celdas[celdaMovimiento.x][celdaMovimiento.y-1].tipo == 'I' ) {
                      System.out.println("celda" + (celdaMovimiento.y-2));
                      if ( celdaMovimiento.y-2 == 0 || celdas[celdaMovimiento.x][celdaMovimiento.y-3].tipo == 'O' || celdas[celdaMovimiento.x][celdaMovimiento.y-3].tipo == 'A') {
                         celdas[celdaMovimiento.x][celdaMovimiento.y].tipo = 'V';
                         celdas[celdaMovimiento.x][celdaMovimiento.y-1].tipo = 'I';
                         celdaMovimiento.y=celdaMovimiento.y-2;
                         celdas[celdaMovimiento.x][celdaMovimiento.y].tipo = 'J';
                      }
                                           
                      if ( celdaMovimiento.y-2 >0 && celdas[celdaMovimiento.x][celdaMovimiento.y-2].tipo != 'O' && celdas[celdaMovimiento.x][celdaMovimiento.y-2].tipo != 'A') {
                          if (celdas[celdaMovimiento.x][celdaMovimiento.y-2].tipo == 'C') {
                                 celdas[22][11].tipo = 'I';
                                //  celdas[celdaMovimiento.x][celdaMovimiento.y-2].tipo = 'C';
                                  celdas[celdaMovimiento.x][celdaMovimiento.y-1].tipo = 'V';
                         celdas[celdaMovimiento.x][celdaMovimiento.y-2].tipo = 'C';
                              
                          }else{
                         celdas[celdaMovimiento.x][celdaMovimiento.y-2].tipo = 'I';
                         celdas[celdaMovimiento.x][celdaMovimiento.y-1].tipo = 'V';
                    }
                      }
                      
                }else{
                    celdas[celdaMovimiento.x][celdaMovimiento.y].tipo = 'V';
                    celdaMovimiento.y=celdaMovimiento.y-1;
                    celdas[celdaMovimiento.x][celdaMovimiento.y].tipo = 'J';
                    celdas[celdaMovimiento.x][celdaMovimiento.y].indexSprite=Rand_Mod_Sprite()+3;
                }
                
            }
            
        }
         
    }

    public void moverCeldaAbajo() {
        System.out.println("Mover Abajo");
        if (celdaMovimiento.y < alturaMundoVirtual-1 ) {
            if (celdas[celdaMovimiento.x][celdaMovimiento.y+1].tipo != 'O' && celdas[celdaMovimiento.x][celdaMovimiento.y+1].tipo != 'A'&& celdas[celdaMovimiento.x][celdaMovimiento.y+1].tipo != 'C') {
                if (celdas[celdaMovimiento.x][celdaMovimiento.y+1].tipo =='I'){
                    if ( celdaMovimiento.y+2 ==  alturaMundoVirtual-1 || celdas[celdaMovimiento.x][celdaMovimiento.y+3].tipo == 'O' || celdas[celdaMovimiento.x][celdaMovimiento.y+3].tipo == 'A') {
                         celdas[celdaMovimiento.x][celdaMovimiento.y].tipo = 'V';
                         celdas[celdaMovimiento.x][celdaMovimiento.y+1].tipo = 'I';
                         celdaMovimiento.y=celdaMovimiento.y+2;
                         celdas[celdaMovimiento.x][celdaMovimiento.y].tipo = 'J';
                      }
                    if (celdaMovimiento.y+2 < alturaMundoVirtual-1 && celdas[celdaMovimiento.x][celdaMovimiento.y+2].tipo != 'O' && celdas[celdaMovimiento.x][celdaMovimiento.y+2].tipo != 'A'  ) {
                        if (celdas[celdaMovimiento.x][celdaMovimiento.y+2].tipo == 'C') {
                             celdas[22][11].tipo ='I';
                        celdas[celdaMovimiento.x][celdaMovimiento.y+1].tipo ='V';
                        celdas[celdaMovimiento.x][celdaMovimiento.y+2].tipo ='C';
                            
                        }else{
                        celdas[celdaMovimiento.x][celdaMovimiento.y+2].tipo ='I';
                        celdas[celdaMovimiento.x][celdaMovimiento.y+1].tipo ='V';
                        
                    }
                    }
                    
                    
                }else{
                    celdas[celdaMovimiento.x][celdaMovimiento.y].tipo ='V';
                    celdaMovimiento.y=celdaMovimiento.y+1;
                    celdas[celdaMovimiento.x][celdaMovimiento.y].tipo ='J'; 
                    celdas[celdaMovimiento.x][celdaMovimiento.y].indexSprite= Rand_Mod_Sprite();
    
                }
                
            }
            
        }        
      }

    public void moverCeldaIzquierda() {
         System.out.println("Mover Izquierda");
         if (celdaMovimiento.x > 0) {
             if (celdas[celdaMovimiento.x-1][celdaMovimiento.y].tipo != 'O' && celdas[celdaMovimiento.x-1][celdaMovimiento.y].tipo != 'A' && celdas[celdaMovimiento.x-1][celdaMovimiento.y].tipo != 'C') {
                 if (celdas[celdaMovimiento.x-1][celdaMovimiento.y].tipo == 'I') {
                     
                      if ( celdaMovimiento.x-2 == 0 || celdas[celdaMovimiento.x-3][celdaMovimiento.y].tipo == 'O' || celdas[celdaMovimiento.x-3][celdaMovimiento.y].tipo == 'A') {
                         celdas[celdaMovimiento.x][celdaMovimiento.y].tipo = 'V';
                         celdas[celdaMovimiento.x-1][celdaMovimiento.y].tipo = 'I';
                         celdaMovimiento.x=celdaMovimiento.x-2;
                         celdas[celdaMovimiento.x][celdaMovimiento.y].tipo = 'J';
                      }
                     
                     
                     if (celdaMovimiento.x-2 > 0 && celdas[celdaMovimiento.x-2][celdaMovimiento.y].tipo != 'O' && celdas[celdaMovimiento.x-2][celdaMovimiento.y].tipo != 'A') {
                         if (celdas[celdaMovimiento.x-2][celdaMovimiento.y].tipo == 'C') {
                             celdas[22][11].tipo = 'I';
                         celdas[celdaMovimiento.x-1][celdaMovimiento.y].tipo = 'V';
                         celdas[celdaMovimiento.x-2][celdaMovimiento.y].tipo = 'C';
                             
                         }else{
                         celdas[celdaMovimiento.x-2][celdaMovimiento.y].tipo = 'I';
                         celdas[celdaMovimiento.x-1][celdaMovimiento.y].tipo = 'V';
                         
                         } 
                     }
                     
                 }else{
                 celdas[celdaMovimiento.x][celdaMovimiento.y].tipo = 'V';
                 celdaMovimiento.x=celdaMovimiento.x-1;
                 celdas[celdaMovimiento.x][celdaMovimiento.y].tipo = 'J';
                 celdas[celdaMovimiento.x][celdaMovimiento.y].indexSprite=Rand_Mod_Sprite()+1;
    
                 }
 
             }
            
        }
     }

    public void moverCeldaDerecha() {
         System.out.println("Mover Derecha");
         
           if (celdaMovimiento.x < anchuraMundoVirtual-1){
               System.out.println("pared");
               if(celdas[celdaMovimiento.x+1][celdaMovimiento.y].tipo != 'O' && celdas[celdaMovimiento.x+1][celdaMovimiento.y].tipo != 'A' && celdas[celdaMovimiento.x+1][celdaMovimiento.y].tipo != 'C'){
                   System.out.println("O & A");
                   if (celdas[celdaMovimiento.x+1][celdaMovimiento.y].tipo == 'I' ) {
                       
                         if ( (celdaMovimiento.x+2 == anchuraMundoVirtual-1) || celdas[celdaMovimiento.x+3][celdaMovimiento.y].tipo == 'O' || celdas[celdaMovimiento.x+3][celdaMovimiento.y].tipo == 'A') {
                         celdas[celdaMovimiento.x][celdaMovimiento.y].tipo = 'V';
                         celdas[celdaMovimiento.x+1][celdaMovimiento.y].tipo = 'I';
                         celdaMovimiento.x=celdaMovimiento.x+2;
                         celdas[celdaMovimiento.x][celdaMovimiento.y].tipo = 'J';
                      }
                       
                       
                       
                       
                       if (celdaMovimiento.x+2 < anchuraMundoVirtual-1 && celdas[celdaMovimiento.x+2][celdaMovimiento.y].tipo != 'O' && celdas[celdaMovimiento.x+2][celdaMovimiento.y].tipo != 'A') {
                       System.out.println("Item");
                           if (celdas[celdaMovimiento.x+2][celdaMovimiento.y].tipo == 'C') {
                       celdas[22][11].tipo = 'I';
                       
                       celdas[celdaMovimiento.x+1][celdaMovimiento.y].tipo = 'V'; 
                          celdas[celdaMovimiento.x+2][celdaMovimiento.y].tipo = 'C'; 
                           }else{
                       celdas[celdaMovimiento.x+2][celdaMovimiento.y].tipo = 'I';
                       celdas[celdaMovimiento.x+1][celdaMovimiento.y].tipo = 'V';
                       celdas[celdaMovimiento.x][celdaMovimiento.y].indexSprite=Rand_Mod_Sprite()+2;
                       celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='J';
                         }}
                   }
                   else{
                       celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='V';
                       celdaMovimiento.x= celdaMovimiento.x +1;
                       celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='J';
                        celdas[celdaMovimiento.x][celdaMovimiento.y].indexSprite=Rand_Mod_Sprite()+2;
                   
                   
                   }
               }
                  
     }
    }
    
    private void moverCeldaIzquierdaArriba(){
        System.out.println("Mover IzquierdaArriba");
        moverCeldaIzquierda();
        moverCeldaArriba();
        
    }

    private void moverCeldaDerechaArriba(){
        System.out.println("Mover DerechaArriba");
        moverCeldaDerecha();
        moverCeldaArriba();
        
    }
    
    private void moverCeldaIzquierdaAbajo(){
        System.out.println("Mover IzquierdaAbajo");
        moverCeldaIzquierda();
        moverCeldaAbajo();
    
    }
    
    private void moverCeldaDerechaAbajo(){
        System.out.println("Mover DerechaAbajo");
        moverCeldaDerecha();
        moverCeldaAbajo();
    }

@Override
public void update(Graphics g){
for(int i=0; i < anchuraMundoVirtual ; i++)
for ( int j=0 ; j < alturaMundoVirtual; j++)
celdas[i][j].paintComponent(g);

}
    
    
@Override
public void paintComponent(Graphics g) {
    update(g);
}

/*Construir Mundo de obstaculos en laberinto*/
}