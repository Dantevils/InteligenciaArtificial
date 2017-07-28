import java.util.Random;

/*Clase Jugador-Hero*/
public class Jugador implements Constantes {
public Laberinto laberinto;
public Celda jugador;
public int direccion;
public BusquedaAnchura2Hero BA;
                
/*Constructor*/   
public Jugador(Laberinto laberinto){
    this.laberinto=laberinto;
    jugador=new Celda(4,numeroAleatorio(3,alturaMundoVirtual-3),'J');
    laberinto.celdas[jugador.x][jugador.y].tipo='J';
    //direccion=0; /*Implica mover hacia derecha*/
    BA = new BusquedaAnchura2Hero(laberinto,this);
}

/*Nuevos Movimientos Jugador-Hero Modificacion*/

    public void moverCeldaArriba(){
        if (jugador.y > 0) {
            System.out.println("arriba-paret");
            if ( laberinto.celdas[jugador.x][jugador.y-1].tipo != 'O' && laberinto.celdas[jugador.x][jugador.y-1].tipo != 'J' && laberinto.celdas[jugador.x][jugador.y-1].tipo != 'P'&& laberinto.celdas[jugador.x][jugador.y-1].tipo != 'A'&& laberinto.celdas[jugador.x][jugador.y-1].tipo != 'C'){
                System.out.println("arriva");
                if (laberinto.celdas[jugador.x][jugador.y-1].tipo == 'I' ) {
                      System.out.println("celda" + (jugador.y-2));
                      if ( jugador.y-2 == 2 || laberinto.celdas[jugador.x][jugador.y-3].tipo == 'O' || laberinto.celdas[jugador.x][jugador.y-3].tipo == 'J') {
                         laberinto.celdas[jugador.x][jugador.y].tipo = 'V';
                        // laberinto.celdas[adversario.x][adversario.y-1].tipo = 'I';
                         
                         jugador.y=jugador.y-2;
                         laberinto.celdas[jugador.x][jugador.y].tipo = 'J';
                         laberinto.LienzoPadre.Pelota.moverCeldaArriba();
                      }
                      if ( jugador.y-2 >0 &&laberinto.celdas[jugador.x][jugador.y-2].tipo != 'O' && laberinto.celdas[jugador.x][jugador.y-2].tipo != 'A' && laberinto.celdas[jugador.x][jugador.y-2].tipo != 'P') {
                        // laberinto.celdas[adversario.x][adversario.y-2].tipo = 'I';
                           laberinto.LienzoPadre.Pelota.moverCeldaArriba();
                         laberinto.celdas[jugador.x][jugador.y-1].tipo = 'V';
                    }
                      
                }else{
                    laberinto.celdas[jugador.x][jugador.y].tipo = 'V';
                    jugador.y=jugador.y-1;
                    laberinto.celdas[jugador.x][jugador.y].tipo = 'J';
                    laberinto.celdas[jugador.x][jugador.y].indexSprite=Rand_Mod_Sprite()+3;
                }
                
            }
            
        }
         
    }
    public void moverCeldaAbajo() {
        System.out.println("Mover Abajo");
        if (jugador.y < alturaMundoVirtual-1 ) {
            if (laberinto.celdas[jugador.x][jugador.y+1].tipo != 'O' && laberinto.celdas[jugador.x][jugador.y+1].tipo != 'J'&& laberinto.celdas[jugador.x][jugador.y+1].tipo != 'P'&& laberinto.celdas[jugador.x][jugador.y+1].tipo != 'A'&& laberinto.celdas[jugador.x][jugador.y+1].tipo != 'C') {
                if (laberinto.celdas[jugador.x][jugador.y+1].tipo =='I'){
                    if ( jugador.y+2 ==  alturaMundoVirtual-2 || laberinto.celdas[jugador.x][jugador.y+3].tipo == 'O' || laberinto.celdas[jugador.x][jugador.y+3].tipo == 'J') {
                         laberinto.celdas[jugador.x][jugador.y].tipo = 'V';
                         //laberinto.celdas[adversario.x][adversario.y+1].tipo = 'I';
                         
                         jugador.y=jugador.y+2;
                         laberinto.celdas[jugador.x][jugador.y].tipo = 'J';
                          laberinto.LienzoPadre.Pelota.moverCeldaAbajo();
                      }
                    if (jugador.y+2 < alturaMundoVirtual-1 && laberinto.celdas[jugador.x][jugador.y+2].tipo != 'O' && laberinto.celdas[jugador.x][jugador.y+2].tipo != 'J' && laberinto.celdas[jugador.x][jugador.y+2].tipo != 'P' ) {
                        //laberinto.celdas[adversario.x][adversario.y+2].tipo ='I';
                         
                        laberinto.celdas[jugador.x][jugador.y+1].tipo ='V';
                        laberinto.LienzoPadre.Pelota.moverCeldaAbajo();
                    }
                    
                    
                }else{
                    laberinto.celdas[jugador.x][jugador.y].tipo ='V';
                    jugador.y=jugador.y+1;
                    laberinto.celdas[jugador.x][jugador.y].tipo ='J'; 
                    laberinto.celdas[jugador.x][jugador.y].indexSprite= Rand_Mod_Sprite();
    
                }
                
            }
            
        }        
      }
    public void moverCeldaIzquierda() {
         System.out.println("Mover Izquierda");
         if (jugador.x > 0) {
             if (laberinto.celdas[jugador.x-1][jugador.y].tipo != 'O' && laberinto.celdas[jugador.x-1][jugador.y].tipo != 'J'&& laberinto.celdas[jugador.x-1][jugador.y].tipo != 'P'&& laberinto.celdas[jugador.x-1][jugador.y].tipo != 'A'&& laberinto.celdas[jugador.x-1][jugador.y].tipo != 'C') {
                 if (laberinto.celdas[jugador.x-1][jugador.y].tipo == 'I') {
                     
                      if ( jugador.x-2 == 0 || laberinto.celdas[jugador.x-3][jugador.y].tipo == 'O' || laberinto.celdas[jugador.x-3][jugador.y].tipo == 'J') {
                         laberinto.celdas[jugador.x][jugador.y].tipo = 'V';
                        // laberinto.celdas[adversario.x-1][adversario.y].tipo = 'I';
                         
                         jugador.x=jugador.x-2;
                         laberinto.celdas[jugador.x][jugador.y].tipo = 'J';
                          laberinto.LienzoPadre.Pelota.moverCeldaDerecha();
                                  }
                     
                     
                     if (jugador.x-2 > 0 && laberinto.celdas[jugador.x-2][jugador.y].tipo != 'O' && laberinto.celdas[jugador.x-2][jugador.y].tipo != 'J' && laberinto.celdas[jugador.x-2][jugador.y].tipo != 'P') {
                        // laberinto.celdas[adversario.x-2][adversario.y].tipo = 'I';
                         
                          laberinto.celdas[jugador.x-1][jugador.y].tipo = 'V';
                          laberinto.LienzoPadre.Pelota.moverCeldaIzquierda();
                     }
                     
                 }else{
                 laberinto.celdas[jugador.x][jugador.y].tipo = 'V';
                 jugador.x=jugador.x-1;
                 laberinto.celdas[jugador.x][jugador.y].tipo = 'J';
                 laberinto.celdas[jugador.x][jugador.y].indexSprite=Rand_Mod_Sprite()+1;
    
                 }
 
             }
            
        }
     }
    public void moverCeldaDerecha() {
         System.out.println("Mover Derecha");
           if (jugador.x < anchuraMundoVirtual-2){
               System.out.println("pared");
               if(laberinto.celdas[jugador.x+1][jugador.y].tipo != 'O' && laberinto.celdas[jugador.x+1][jugador.y].tipo != 'J'&& laberinto.celdas[jugador.x+1][jugador.y].tipo != 'P'&& laberinto.celdas[jugador.x+1][jugador.y].tipo != 'A'&& laberinto.celdas[jugador.x+1][jugador.y].tipo != 'C'){
                   System.out.println("O & A");
                   if (laberinto.celdas[jugador.x+1][jugador.y].tipo == 'I' ) {
                       
                         if ( (jugador.x+2 == anchuraMundoVirtual-3) || laberinto.celdas[jugador.x+3][jugador.y].tipo == 'O' || laberinto.celdas[jugador.x+3][jugador.y].tipo == 'J') {
                         laberinto.celdas[jugador.x][jugador.y].tipo = 'V';
                       //  laberinto.celdas[adversario.x+1][adversario.y].tipo = 'I';
                         
                         jugador.x=jugador.x+2;
                         laberinto.celdas[jugador.x][jugador.y].tipo = 'J';
                          laberinto.LienzoPadre.Pelota.moverCeldaDerecha();
                      }
                       
                       
                       
                       
                       if (jugador.x+2 < anchuraMundoVirtual-2 && laberinto.celdas[jugador.x+2][jugador.y].tipo != 'O' && laberinto.celdas[jugador.x+2][jugador.y].tipo != 'J' && laberinto.celdas[jugador.x+2][jugador.y].tipo != 'P') {
                       System.out.println("Item");
                      // laberinto.celdas[adversario.x+2][adversario.y].tipo = 'I';
                        laberinto.LienzoPadre.Pelota.moverCeldaDerecha();
                       laberinto.celdas[jugador.x+1][jugador.y].tipo = 'V';
                       laberinto.celdas[jugador.x][jugador.y].indexSprite=Rand_Mod_Sprite()+2;
                       laberinto.celdas[jugador.x][jugador.y].tipo='J';
                         }
                   }
                   else{
                       laberinto.celdas[jugador.x][jugador.y].tipo='V';
                       jugador.x= jugador.x +1;
                       laberinto.celdas[jugador.x][jugador.y].tipo='J';
                        laberinto.celdas[jugador.x][jugador.y].indexSprite=Rand_Mod_Sprite()+2;
                   
                   
                   }
               }
                  
     }
    }
    






 /*
    public void moverCeldaArriba(){
        if (jugador.y > 0) {
            System.out.println("arriba-paret");
            if ( laberinto.celdas[jugador.x][jugador.y-1].tipo != 'O' && laberinto.celdas[jugador.x][jugador.y-1].tipo != 'A'&& laberinto.celdas[jugador.x][jugador.y-1].tipo != 'C'){
                System.out.println("arriva");
                if (laberinto.celdas[jugador.x][jugador.y-1].tipo == 'I' ) {
                      System.out.println("celda" + (jugador.y-2));
                      if ( jugador.y-2 == 0 || laberinto.celdas[jugador.x][jugador.y-3].tipo == 'O' || laberinto.celdas[jugador.x][jugador.y-3].tipo == 'A') {
                         laberinto.celdas[jugador.x][jugador.y].tipo = 'V';
                         //laberinto.celdas[jugador.x][jugador.y-1].tipo = 'I';
                         jugador.y=jugador.y-2;
                         laberinto.celdas[jugador.x][jugador.y].tipo = 'J';
                      }
                                           
                      if ( jugador.y-2 >0 && laberinto.celdas[jugador.x][jugador.y-2].tipo != 'O' && laberinto.celdas[jugador.x][jugador.y-2].tipo != 'A') {
                          if (laberinto.celdas[jugador.x][jugador.y-2].tipo == 'C') {
                                // laberinto.celdas[22][11].tipo = 'I';
                                //  celdas[celdaMovimiento.x][celdaMovimiento.y-2].tipo = 'C';++
                                  laberinto.celdas[jugador.x][jugador.y-1].tipo = 'V';
                         laberinto.celdas[jugador.x][jugador.y-2].tipo = 'C';
                              
                          }else{
                        // laberinto.celdas[jugador.x][jugador.y-2].tipo = 'I';
                         laberinto.celdas[jugador.x][jugador.y-1].tipo = 'V';
                    }
                      }
                      
                }else{
                    laberinto.celdas[jugador.x][jugador.y].tipo = 'V';
                    jugador.y=jugador.y-1;
                    laberinto.celdas[jugador.x][jugador.y].tipo = 'J';
                    laberinto.celdas[jugador.x][jugador.y].indexSprite=Rand_Mod_Sprite()+3;
                }
                
            }
            
        }
         
    }

    public void moverCeldaAbajo() {
        System.out.println("Mover Abajo");
        if (jugador.y < alturaMundoVirtual-1 ) {
            if (laberinto.celdas[jugador.x][jugador.y+1].tipo != 'O' && laberinto.celdas[jugador.x][jugador.y+1].tipo != 'A'&& laberinto.celdas[jugador.x][jugador.y+1].tipo != 'C') {
                if (laberinto.celdas[jugador.x][jugador.y+1].tipo =='I'){
                    if ( jugador.y+2 ==  alturaMundoVirtual-1 || laberinto.celdas[jugador.x][jugador.y+3].tipo == 'O' || laberinto.celdas[jugador.x][jugador.y+3].tipo == 'A') {
                         laberinto.celdas[jugador.x][jugador.y].tipo = 'V';
                       //  laberinto.celdas[jugador.x][jugador.y+1].tipo = 'I';
                         jugador.y=jugador.y+2;
                         laberinto.celdas[jugador.x][jugador.y].tipo = 'J';
                      }
                    if (jugador.y+2 < alturaMundoVirtual-1 && laberinto.celdas[jugador.x][jugador.y+2].tipo != 'O' && laberinto.celdas[jugador.x][jugador.y+2].tipo != 'A'  ) {
                        if (laberinto.celdas[jugador.x][jugador.y+2].tipo == 'C') {
                             //laberinto.celdas[22][11].tipo ='I';
                             
                        laberinto.celdas[jugador.x][jugador.y+1].tipo ='V';
                        laberinto.celdas[jugador.x][jugador.y+2].tipo ='C';
                            
                        }else{
                        //laberinto.celdas[jugador.x][jugador.y+2].tipo ='I';
                        laberinto.celdas[jugador.x][jugador.y+1].tipo ='V';
                        
                    }
                    }
                    
                    
                }else{
                    laberinto.celdas[jugador.x][jugador.y].tipo ='V';
                    jugador.y=jugador.y+1;
                    laberinto.celdas[jugador.x][jugador.y].tipo ='J'; 
                    laberinto.celdas[jugador.x][jugador.y].indexSprite= Rand_Mod_Sprite();
    
                }
                
            }
            
        }        
      }

    public void moverCeldaIzquierda() {
         System.out.println("Mover Izquierda");
         if (jugador.x > 0) {
             if (laberinto.celdas[jugador.x-1][jugador.y].tipo != 'O' && laberinto.celdas[jugador.x-1][jugador.y].tipo != 'A' && laberinto.celdas[jugador.x-1][jugador.y].tipo != 'C') {
                 if (laberinto.celdas[jugador.x-1][jugador.y].tipo == 'I') {
                     
                      if ( jugador.x-2 == 0 || laberinto.celdas[jugador.x-3][jugador.y].tipo == 'O' || laberinto.celdas[jugador.x-3][jugador.y].tipo == 'A') {
                         laberinto.celdas[jugador.x][jugador.y].tipo = 'V';
                      //   laberinto.celdas[jugador.x-1][jugador.y].tipo = 'I';
                         jugador.x=jugador.x-2;
                         laberinto.celdas[jugador.x][jugador.y].tipo = 'J';
                      }
                     
                     
                     if (jugador.x-2 > 0 && laberinto.celdas[jugador.x-2][jugador.y].tipo != 'O' && laberinto.celdas[jugador.x-2][jugador.y].tipo != 'A') {
                         if (laberinto.celdas[jugador.x-2][jugador.y].tipo == 'C') {
                           //  laberinto.celdas[22][11].tipo = 'I';
                         laberinto.celdas[jugador.x-1][jugador.y].tipo = 'V';
                         laberinto.celdas[jugador.x-2][jugador.y].tipo = 'C';
                             
                         }else{
                        // laberinto.celdas[jugador.x-2][jugador.y].tipo = 'I';
                         laberinto.celdas[jugador.x-1][jugador.y].tipo = 'V';
                         
                         } 
                     }
                     
                 }else{
                 laberinto.celdas[jugador.x][jugador.y].tipo = 'V';
                 jugador.x=jugador.x-1;
                 laberinto.celdas[jugador.x][jugador.y].tipo = 'J';
                 laberinto.celdas[jugador.x][jugador.y].indexSprite=Rand_Mod_Sprite()+1;
    
                 }
 
             }
            
        }
     }

    public void moverCeldaDerecha() {
         System.out.println("Mover Derecha");
         
           if (jugador.x < anchuraMundoVirtual-1){
               System.out.println("pared");
               if(laberinto.celdas[jugador.x+1][jugador.y].tipo != 'O' && laberinto.celdas[jugador.x+1][jugador.y].tipo != 'A' && laberinto.celdas[jugador.x+1][jugador.y].tipo != 'C'){
                   System.out.println("O & A");
                   if (laberinto.celdas[jugador.x+1][jugador.y].tipo == 'I' ) {
                       
                         if ( (jugador.x+2 == anchuraMundoVirtual-1) || laberinto.celdas[jugador.x+3][jugador.y].tipo == 'O' || laberinto.celdas[jugador.x+3][jugador.y].tipo == 'A') {
                         laberinto.celdas[jugador.x][jugador.y].tipo = 'V';
                        /// laberinto.celdas[jugador.x+1][jugador.y].tipo = 'I';
                         jugador.x=jugador.x+2;
                         laberinto.celdas[jugador.x][jugador.y].tipo = 'J';
                      }
                       
                       
                       
                       
                       if (jugador.x+2 < anchuraMundoVirtual-1 && laberinto.celdas[jugador.x+2][jugador.y].tipo != 'O' && laberinto.celdas[jugador.x+2][jugador.y].tipo != 'A') {
                       System.out.println("Item");
                           if (laberinto.celdas[jugador.x+2][jugador.y].tipo == 'C') {
                       //laberinto.celdas[22][11].tipo = 'I';
                       
                       laberinto.celdas[jugador.x+1][jugador.y].tipo = 'V'; 
                          laberinto.celdas[jugador.x+2][jugador.y].tipo = 'C'; 
                           }else{
                       //laberinto.celdas[jugador.x+2][jugador.y].tipo = 'I';
                       laberinto.celdas[jugador.x+1][jugador.y].tipo = 'V';
                       laberinto.celdas[jugador.x][jugador.y].indexSprite=Rand_Mod_Sprite()+2;
                       laberinto.celdas[jugador.x][jugador.y].tipo='J';
                         }}
                   }
                   else{
                       laberinto.celdas[jugador.x][jugador.y].tipo='V';
                       jugador.x= jugador.x +1;
                       laberinto.celdas[jugador.x][jugador.y].tipo='J';
                        laberinto.celdas[jugador.x][jugador.y].indexSprite=Rand_Mod_Sprite()+2;
                   
                   
                   }
               }
                  
     }
    }
    
    */
    
/*Seccion Movimientos Juegador-Hero*/
    
    public void moverCeldaArriba2(){
        if (jugador.y > 0) {
            if (laberinto.celdas[jugador.x][jugador.y-1].tipo != 'O' && laberinto.celdas[jugador.x][jugador.y-1].tipo !='A') {
                if (laberinto.celdas[jugador.x][jugador.y-1].tipo == 'I') {
                    if (jugador.y-2 > 0) {
                       // laberinto.celdas[jugador.x][jugador.y-2].tipo = 'I';
                        laberinto.celdas[jugador.x][jugador.y-1].tipo = 'V';
                    }
                }else{
                laberinto.celdas[jugador.x][jugador.y].tipo = 'V';
                jugador.y=jugador.y-1;
                laberinto.celdas[jugador.x][jugador.y].tipo = 'J';
                laberinto.celdas[jugador.x][jugador.y].indexSprite=Rand_Mod_Sprite()+3;
                }  
            }   
        }
    }

    public void moverCeldaAbajo2() {
        if (jugador.y < alturaMundoVirtual-1) {
            if (  laberinto.celdas[jugador.x][jugador.y+1].tipo!='O' &&  laberinto.celdas[jugador.x][jugador.y+1].tipo!='A') {
                if (laberinto.celdas[jugador.x][jugador.y+1].tipo=='I'){
                    if (jugador.y+2 < alturaMundoVirtual-1) {
                  //  laberinto.celdas[jugador.x][jugador.y+2].tipo='I';
                    laberinto.celdas[jugador.x][jugador.y+1].tipo='V';
                }
               }else{
                laberinto.celdas[jugador.x][jugador.y].tipo='V';
                jugador.y=jugador.y+1;
                laberinto.celdas[jugador.x][jugador.y].tipo='J';
                laberinto.celdas[jugador.x][jugador.y].indexSprite= Rand_Mod_Sprite();
                }
            }
        }   
    }

    public void moverCeldaIzquierda2() {
        if (jugador.x > 0) {
            if (laberinto.celdas[jugador.x-1][jugador.y].tipo != 'O' && laberinto.celdas[jugador.x-1][jugador.y].tipo != 'A') {
                if (laberinto.celdas[jugador.x-1][jugador.y].tipo == 'I') {
                    if (jugador.x-2 > 0) {
                      // laberinto.celdas[jugador.x-2][jugador.y].tipo = 'I';
                       laberinto.celdas[jugador.x-1][jugador.y].tipo = 'V';                        
                    }   
                }else{
                 laberinto.celdas[jugador.x][jugador.y].tipo = 'V'; 
                 jugador.x=jugador.x-1;
                 laberinto.celdas[jugador.x][jugador.y].tipo = 'J'; 
                laberinto.celdas[jugador.x][jugador.y].indexSprite=Rand_Mod_Sprite()+1;
                }
            }
            
        }
     }

    public void moverCeldaDerecha2() {
        if (jugador.x < anchuraMundoVirtual-1 ) {
            if (laberinto.celdas[jugador.x+1][jugador.y].tipo != 'O' && laberinto.celdas[jugador.x+1][jugador.y].tipo != 'A') {
                if (laberinto.celdas[jugador.x+1][jugador.y].tipo == 'I') {
                    if (jugador.x+2 < anchuraMundoVirtual-1) {
                       // laberinto.celdas[jugador.x+2][jugador.y].tipo = 'I';
                        laberinto.celdas[jugador.x+1][jugador.y].tipo = 'V';
                    }
                    
                }else{
                laberinto.celdas[jugador.x][jugador.y].tipo = 'V';
                jugador.x=jugador.x+1;
                laberinto.celdas[jugador.x][jugador.y].tipo = 'J';
                laberinto.celdas[jugador.x][jugador.y].indexSprite=Rand_Mod_Sprite()+2;
                
                }
            }
            
        }
     }
    
    public void moverCeldaIzquierdaArriba(){
        System.out.println("Mover IzquierdaArriba");
        moverCeldaIzquierda();
        moverCeldaArriba();
        
    }

    public void moverCeldaDerechaArriba() {
        System.out.println("Mover DerechaArriba");
        moverCeldaDerecha();
        moverCeldaArriba();
        
    }
    
    public void moverCeldaIzquierdaAbajo(){
        System.out.println("Mover IzquierdaAbajo");
        moverCeldaIzquierda();
        moverCeldaAbajo();
    
    }
    
    public void moverCeldaDerechaAbajo(){
        System.out.println("Mover DerechaAbajo");
        moverCeldaDerecha();
        moverCeldaAbajo();
    }
    
    public static int Rand_Mod_Sprite(){
    Random rand = new Random();
    int sprite = rand.nextInt(8);
    while(sprite%4 != 0){
    sprite = rand.nextInt(8);
         }
    return sprite;
 } 
   
/*Otros Movimientos & Funciones*/
    
    private void JuegadorMoverDerecha() {/*
        if (jugador.x < anchuraMundoVirtual-1 ) {
laberinto.celdas[jugador.x][jugador.y].tipo='V';
jugador.x=jugador.x+1;
laberinto.celdas[jugador.x][jugador.y].tipo='J';
laberinto.celdas[jugador.x][jugador.y].indexSprite=Rand_Mod_Sprite()+2;
}else {
laberinto.celdas[jugador.x][jugador.y].tipo='V';
jugador.x=anchuraMundoVirtual-1;
jugador.y=numeroAleatorio(0,alturaMundoVirtual-1);
laberinto.celdas[jugador.x][jugador.y].tipo='J';
laberinto.celdas[jugador.x][jugador.y].indexSprite=Rand_Mod_Sprite()+2;
}*/
        /*
        if (celdaMovimiento.x < anchuraMundoVirtual-1 ) {
               celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='V';
        celdaMovimiento.x=celdaMovimiento.x+1;
        celdas[celdaMovimiento.x][celdaMovimiento.y].tipo='J';
           celdas[celdaMovimiento.x][celdaMovimiento.y].indexSprite=Rand_Mod_Sprite()+2;
             
        */
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
if (jugador.x < anchuraMundoVirtual-1) {
    if (laberinto.celdas[jugador.x+1][jugador.y].tipo !='A') {
        laberinto.celdas[jugador.x][jugador.y].tipo='V';
        jugador.x=jugador.x+1;
        laberinto.celdas[jugador.x][jugador.y].tipo='J';
        laberinto.celdas[jugador.x][jugador.y].indexSprite=Rand_Mod_Sprite()+2;
    }else direccion = 1; 
}
else{
        laberinto.celdas[jugador.x][jugador.y].tipo='V';
        jugador.x=0;
        jugador.y=numeroAleatorio(0,alturaMundoVirtual-1);
        laberinto.celdas[jugador.x][jugador.y].tipo='J';
        laberinto.celdas[jugador.x][jugador.y].indexSprite=Rand_Mod_Sprite()+2;             
}

}
    private void JugadorMoverIzquierda(){
    
if (jugador.x > 0) {
    if (laberinto.celdas[jugador.x-1][jugador.y].tipo !='A') {
        laberinto.celdas[jugador.x][jugador.y].tipo='V';
        jugador.x=jugador.x-1;
        laberinto.celdas[jugador.x][jugador.y].tipo='J';
        laberinto.celdas[jugador.x][jugador.y].indexSprite=Rand_Mod_Sprite()+2;
    }else direccion = 0; 
}
else{
        laberinto.celdas[jugador.x][jugador.y].tipo='V';
        jugador.x=anchuraMundoVirtual-1;
        jugador.y=numeroAleatorio(0,alturaMundoVirtual-1);
        laberinto.celdas[jugador.x][jugador.y].tipo='J';
        laberinto.celdas[jugador.x][jugador.y].indexSprite=Rand_Mod_Sprite()+2;             


}

}



    
    
    
    
}
