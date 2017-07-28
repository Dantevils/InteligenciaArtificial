import java.util.Random;
import java.util.TimerTask;


/*Contiene todo los atributos de movimiento del Item - Coliciones - Movimientos - Acciones*/
/*Clase Item, en este caso sera Pelota*/
/*En esta clase implementaremos Busqueda dependiendo en que posicion se enceutre la pelota*/
public class Item  implements Constantes{ 
    
public Laberinto laberinto;
public Celda item;
public int direccion;
public BusquedaAnchuraBall BAB;
public HiloMusica player1,player2;
                
/*Construtor de Item*/
public Item(Laberinto laberinto){
this.laberinto=laberinto;
item=new Celda((anchuraMundoVirtual/2),numeroAleatorio(5,alturaMundoVirtual-2),'I');
laberinto.celdas[item.x][item.y].tipo='I';
direccion=0; /*Implica mover hacia derecha*/ 
player1=new HiloMusica(RUTA+"/src/music/Buzzer.wav",1);
player2=new HiloMusica(RUTA+"/src/music/Cheering.wav",1);
BAB = new BusquedaAnchuraBall(laberinto,this);
                }
  
    public void soundItem(){
        player1.run();
        player2.run();
    }
/*Seccion Movimientos del item*/
    public void moverCeldaArriba(){
         if (laberinto.celdas[item.x][item.y-1].tipo != 'O' && laberinto.celdas[item.x][item.y-1].tipo !='J'&& laberinto.celdas[item.x][item.y-1].tipo !='P' && laberinto.celdas[item.x][item.y-1].tipo !='A') {
        laberinto.celdas[item.x][item.y].tipo = 'V';
         item.y=item.y-1;
        laberinto.celdas[item.x][item.y].tipo = 'I';
       }
         if (laberinto.celdas[item.x][item.y-1].tipo == 'C') {
             
           laberinto.celdas[item.x][item.y].tipo = 'V';
            laberinto.celdas[anchuraMundoVirtual/2][alturaMundoVirtual/2].tipo = 'I';
     
        player1.run();
        player2.run();
         }
       /* if (item.y > 0) {
            if (laberinto.celdas[item.x][item.y-1].tipo != 'O' && laberinto.celdas[item.x][item.y-1].tipo !='J' && laberinto.celdas[item.x][item.y-1].tipo !='A') {
                if (laberinto.celdas[item.x][item.y-1].tipo == 'I') {
                    if (item.y-2 > 0) {
                        laberinto.celdas[item.x][item.y-2].tipo = 'I';
                        laberinto.celdas[item.x][item.y-1].tipo = 'V';
                    }
                }else{
                laberinto.celdas[item.x][item.y].tipo = 'V';
                item.y=item.y-1;
                laberinto.celdas[item.x][item.y].tipo = 'I';
              // laberinto.celdas[item.x][item.y].indexSprite=Rand_Mod_Sprite()+3;
                }  
            }   
        }*/
    }

    public void moverCeldaAbajo() {
        if (laberinto.celdas[item.x][item.y+1].tipo!='O' &&  laberinto.celdas[item.x][item.y+1].tipo!='P'&&  laberinto.celdas[item.x][item.y+1].tipo!='J' &&  laberinto.celdas[item.x][item.y+1].tipo!='A') {
              laberinto.celdas[item.x][item.y].tipo='V';
                item.y=item.y+1;
                laberinto.celdas[item.x][item.y].tipo='I';
            
        }
        
        
       /* if (item.y < alturaMundoVirtual-1) {
            if (  laberinto.celdas[item.x][item.y+1].tipo!='O' &&  laberinto.celdas[item.x][item.y+1].tipo!='J') {
                if (laberinto.celdas[item.x][item.y+1].tipo=='I'){
                    if (item.y+2 < alturaMundoVirtual-1) {
                    laberinto.celdas[item.x][item.y+2].tipo='I';
                    laberinto.celdas[item.x][item.y+1].tipo='V';
                }
               }else{
                laberinto.celdas[item.x][item.y].tipo='V';
                item.y=item.y+1;
                laberinto.celdas[item.x][item.y].tipo='A';
              //  laberinto.celdas[item.x][item.y].indexSprite= Rand_Mod_Sprite();
                }
            }
        }   */
    }

    public void moverCeldaIzquierda() {
         if (laberinto.celdas[item.x-1][item.y].tipo != 'O' && laberinto.celdas[item.x-1][item.y].tipo != 'J'&& laberinto.celdas[item.x-1][item.y].tipo != 'P' && laberinto.celdas[item.x-1][item.y].tipo != 'A') {
         
         laberinto.celdas[item.x][item.y].tipo = 'V'; 
                 item.x=item.x-1;
                 laberinto.celdas[item.x][item.y].tipo = 'I'; 
         }
         
           if (laberinto.celdas[item.x-1][item.y].tipo  == 'C') {
             
           laberinto.celdas[item.x][item.y].tipo = 'V';
           item.x=numeroAleatorio(3,anchuraMundoVirtual-3);
           item.y=numeroAleatorio(1,alturaMundoVirtual-3);
          laberinto.celdas[item.x][item.y].tipo = 'I';
      soundItem();
      laberinto.LienzoPadre.GOLHERO++;
           }
        /*if (item.x > 0) {
            if (laberinto.celdas[item.x-1][item.y].tipo != 'O' && laberinto.celdas[item.x-1][item.y].tipo != 'J') {
                if (laberinto.celdas[item.x-1][item.y].tipo == 'I') {
                    if (item.x-2 > 0) {
                       laberinto.celdas[item.x-2][item.y].tipo = 'I';
                       laberinto.celdas[item.x-1][item.y].tipo = 'V';                        
                    }   
                }else{
                 laberinto.celdas[item.x][item.y].tipo = 'V'; 
                 item.x=item.x-1;
                 laberinto.celdas[item.x][item.y].tipo = 'A'; 
              //  laberinto.celdas[item.x][item.y].indexSprite=Rand_Mod_Sprite()+1;
                }
            }
            
        }*/
     }

    public void moverCeldaDerecha() {
          if (laberinto.celdas[item.x+1][item.y].tipo != 'O' && laberinto.celdas[item.x+1][item.y].tipo != 'J' && laberinto.celdas[item.x+1][item.y].tipo != 'P'&& laberinto.celdas[item.x+1][item.y].tipo != 'A') {
               laberinto.celdas[item.x][item.y].tipo = 'V';
                item.x=item.x+1;
                laberinto.celdas[item.x][item.y].tipo = 'I';
          }
           if (laberinto.celdas[item.x+1][item.y].tipo == 'C') {
             
           laberinto.celdas[item.x][item.y].tipo = 'V';
           item.x=numeroAleatorio(3,anchuraMundoVirtual-3);
           item.y=numeroAleatorio(1,alturaMundoVirtual-3);
          laberinto.celdas[item.x][item.y].tipo = 'I';
      soundItem();
      laberinto.LienzoPadre.GOLADVERSARIO++;
        }
       /* if (item.x < anchuraMundoVirtual-1 ) {
            if (laberinto.celdas[item.x+1][item.y].tipo != 'O' && laberinto.celdas[item.x+1][item.y].tipo != 'J') {
                if (laberinto.celdas[item.x+1][item.y].tipo == 'I') {
                    if (item.x+2 < anchuraMundoVirtual-1) {
                        laberinto.celdas[item.x+2][item.y].tipo = 'I';
                        laberinto.celdas[item.x+1][item.y].tipo = 'V';
                    }
                    
                }else{
                laberinto.celdas[item.x][item.y].tipo = 'V';
                item.x=item.x+1;
                laberinto.celdas[item.x][item.y].tipo = 'A';
              //  laberinto.celdas[item.x][item.y].indexSprite=Rand_Mod_Sprite()+2;
                
                }
            }
            
        }*/
     }

    public void REBOTE(){
    moverCeldaArriba();
    moverCeldaIzquierda();
    }
     public void REBOTE2(){
    moverCeldaArriba();
    moverCeldaDerecha();
     // moverCeldaDerecha();
    }
     
      public void REBOTECTM(){
         moverCeldaAbajo();
   // moverCeldaArriba();
     //moverCeldaIzquierda();
     moverCeldaDerecha();
    }


  public static int Rand_Mod_Sprite(){
    Random rand = new Random();
    int sprite = rand.nextInt(8);
    while(sprite%4 != 0){
    sprite = rand.nextInt(8);
    //System.out.println("RAAAAaaaaND:  "+ sprite);
    }
    return sprite;
    } 


}

 


