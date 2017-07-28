import java.util.Random;

/*Clase Adversario*/
public class Adversario implements Constantes{
public Laberinto laberinto;
public Celda adversario;
public BusquedaAnchura2Adversario BA;
public int direccion;
//public int Cont = 0;

/*Construtor de Adversario*/
public Adversario(Laberinto laberinto) {
this.laberinto=laberinto;
adversario=new Celda(anchuraMundoVirtual-22,numeroAleatorio(0,alturaMundoVirtual-1),'A');
laberinto.celdas[adversario.x][adversario.y].tipo='A';
 BA = new BusquedaAnchura2Adversario(laberinto,this);
}

    public static int Rand_Mod_Sprite(){
        Random rand = new Random();
        int sprite = rand.nextInt(8);
        while(sprite%4 != 0){
        sprite = rand.nextInt(8);
            }
        return sprite;
    } 
    
/*Seccion Movimientos Adversario*/

    public void moverCeldaArriba(){
        if (adversario.y > 0) {
            System.out.println("arriba-paret");
            if ( laberinto.celdas[adversario.x][adversario.y-1].tipo != 'O' && laberinto.celdas[adversario.x][adversario.y-1].tipo != 'J'&& laberinto.celdas[adversario.x][adversario.y-1].tipo != 'A'&& laberinto.celdas[adversario.x][adversario.y-1].tipo != 'C'){
                System.out.println("arriva");
                if (laberinto.celdas[adversario.x][adversario.y-1].tipo == 'I' ) {
                      System.out.println("celda" + (adversario.y-2));
                      if ( adversario.y-2 == 0 || laberinto.celdas[adversario.x][adversario.y-3].tipo == 'O' || laberinto.celdas[adversario.x][adversario.y-3].tipo == 'J') {
                       //  laberinto.celdas[adversario.x][adversario.y].tipo = 'V';
                        // laberinto.celdas[adversario.x][adversario.y-1].tipo = 'I';
                        // adversario.y=adversario.y-2;
                         //laberinto.celdas[adversario.x][adversario.y].tipo = 'A';
                      }
                      if ( adversario.y-2 >0 &&laberinto.celdas[adversario.x][adversario.y-2].tipo != 'O' && laberinto.celdas[adversario.x][adversario.y-2].tipo != 'J') {
                        // laberinto.celdas[adversario.x][adversario.y-2].tipo = 'I';
                         laberinto.celdas[adversario.x][adversario.y-1].tipo = 'V';
                    }
                      
                }else{
                    laberinto.celdas[adversario.x][adversario.y].tipo = 'V';
                    adversario.y=adversario.y-1;
                    laberinto.celdas[adversario.x][adversario.y].tipo = 'A';
                    laberinto.celdas[adversario.x][adversario.y].indexSprite=Rand_Mod_Sprite()+3;
                }
                
            }
            
        }
         
    }
    public void moverCeldaAbajo() {
        System.out.println("Mover Abajo");
        if (adversario.y < alturaMundoVirtual-1 ) {
            if (laberinto.celdas[adversario.x][adversario.y+1].tipo != 'O' && laberinto.celdas[adversario.x][adversario.y+1].tipo != 'J'&& laberinto.celdas[adversario.x][adversario.y+1].tipo != 'A'&& laberinto.celdas[adversario.x][adversario.y+1].tipo != 'C') {
                if (laberinto.celdas[adversario.x][adversario.y+1].tipo =='I'){
                    if ( adversario.y+2 ==  alturaMundoVirtual-1 || laberinto.celdas[adversario.x][adversario.y+3].tipo == 'O' || laberinto.celdas[adversario.x][adversario.y+3].tipo == 'J') {
                         //laberinto.celdas[adversario.x][adversario.y].tipo = 'V';
                         //laberinto.celdas[adversario.x][adversario.y+1].tipo = 'I';
                         ///adversario.y=adversario.y+2;
                         //laberinto.celdas[adversario.x][adversario.y].tipo = 'A';
                      }
                    if (adversario.y+2 < alturaMundoVirtual-1 && laberinto.celdas[adversario.x][adversario.y+2].tipo != 'O' && laberinto.celdas[adversario.x][adversario.y+2].tipo != 'J' ) {
                        //laberinto.celdas[adversario.x][adversario.y+2].tipo ='I';
                        //laberinto.celdas[adversario.x][adversario.y+1].tipo ='V';
                        
                    }
                    
                    
                }else{
                    laberinto.celdas[adversario.x][adversario.y].tipo ='V';
                    adversario.y=adversario.y+1;
                    laberinto.celdas[adversario.x][adversario.y].tipo ='A'; 
                    laberinto.celdas[adversario.x][adversario.y].indexSprite= Rand_Mod_Sprite();
    
                }
                
            }
            
        }        
      }
    public void moverCeldaIzquierda() {
         System.out.println("Mover Izquierda");
         if (adversario.x > 0) {
             if (laberinto.celdas[adversario.x-1][adversario.y].tipo != 'O' && laberinto.celdas[adversario.x-1][adversario.y].tipo != 'J'&& laberinto.celdas[adversario.x-1][adversario.y].tipo != 'A'&& laberinto.celdas[adversario.x-1][adversario.y].tipo != 'C') {
                 if (laberinto.celdas[adversario.x-1][adversario.y].tipo == 'I') {
                     
                      if ( adversario.x-2 == 0 || laberinto.celdas[adversario.x-3][adversario.y].tipo == 'O' || laberinto.celdas[adversario.x-3][adversario.y].tipo == 'J') {
                         //laberinto.celdas[adversario.x][adversario.y].tipo = 'V';
                        // laberinto.celdas[adversario.x-1][adversario.y].tipo = 'I';
                         //adversario.x=adversario.x-2;
                         //laberinto.celdas[adversario.x][adversario.y].tipo = 'A';
                      }
                     
                     
                     if (adversario.x-2 > 0 && laberinto.celdas[adversario.x-2][adversario.y].tipo != 'O' && laberinto.celdas[adversario.x-2][adversario.y].tipo != 'J') {
                        // laberinto.celdas[adversario.x-2][adversario.y].tipo = 'I';
                         //laberinto.celdas[adversario.x-1][adversario.y].tipo = 'V';
                           
                     }
                     
                 }else{
                 laberinto.celdas[adversario.x][adversario.y].tipo = 'V';
                 adversario.x=adversario.x-1;
                 laberinto.celdas[adversario.x][adversario.y].tipo = 'A';
                 laberinto.celdas[adversario.x][adversario.y].indexSprite=Rand_Mod_Sprite()+1;
    
                 }
 
             }
            
        }
     }
    public void moverCeldaDerecha() {
         System.out.println("Mover Derecha");
           if (adversario.x < anchuraMundoVirtual-1){
               System.out.println("pared");
               if(laberinto.celdas[adversario.x+1][adversario.y].tipo != 'O' && laberinto.celdas[adversario.x+1][adversario.y].tipo != 'J'&& laberinto.celdas[adversario.x+1][adversario.y].tipo != 'A'&& laberinto.celdas[adversario.x+1][adversario.y].tipo != 'C'){
                   System.out.println("O & A");
                   if (laberinto.celdas[adversario.x+1][adversario.y].tipo == 'I' ) {
                       
                         if ( (adversario.x+2 == anchuraMundoVirtual-1) || laberinto.celdas[adversario.x+3][adversario.y].tipo == 'O' || laberinto.celdas[adversario.x+3][adversario.y].tipo == 'J') {
                         //laberinto.celdas[adversario.x][adversario.y].tipo = 'V';
                       //  laberinto.celdas[adversario.x+1][adversario.y].tipo = 'I';
                         ///adversario.x=adversario.x+2;
                         //laberinto.celdas[adversario.x][adversario.y].tipo = 'A';
                      }
                       
                       
                       
                       
                       if (adversario.x+2 < anchuraMundoVirtual-1 && laberinto.celdas[adversario.x+2][adversario.y].tipo != 'O' && laberinto.celdas[adversario.x+2][adversario.y].tipo != 'J') {
                       //System.out.println("Item");
                      // laberinto.celdas[adversario.x+2][adversario.y].tipo = 'I';
                       //laberinto.celdas[adversario.x+1][adversario.y].tipo = 'V';
                       //laberinto.celdas[adversario.x][adversario.y].indexSprite=Rand_Mod_Sprite()+2;
                       //laberinto.celdas[adversario.x][adversario.y].tipo='A';
                         }
                   }
                   else{
                       laberinto.celdas[adversario.x][adversario.y].tipo='V';
                       adversario.x= adversario.x +1;
                       laberinto.celdas[adversario.x][adversario.y].tipo='A';
                        laberinto.celdas[adversario.x][adversario.y].indexSprite=Rand_Mod_Sprite()+2;
                   
                   
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
    
    /*Otros movimientos*/
       
    private void AdversarioMoverDerecha(){

if (adversario.x > 0 ) {
    if (laberinto.celdas[adversario.x-1][adversario.y].tipo!='J') {
        laberinto.celdas[adversario.x][adversario.y].tipo='V';
        adversario.x=adversario.x-1;
        laberinto.celdas[adversario.x][adversario.y].tipo='A';
        laberinto.celdas[adversario.x][adversario.y].indexSprite=Rand_Mod_Sprite()+1;
        
    }else direccion=1;
}
else {
    laberinto.celdas[adversario.x][adversario.y].tipo='V';
    adversario.x=anchuraMundoVirtual-1;
    adversario.y=numeroAleatorio(0,alturaMundoVirtual-1);
    laberinto.celdas[adversario.x][adversario.y].tipo='A';
    laberinto.celdas[adversario.x][adversario.y].indexSprite=Rand_Mod_Sprite()+1;
}
}  
    private void AdversarioMoverIzquierda(){
           
       if (adversario.x < anchuraMundoVirtual-1 ) {
    if (laberinto.celdas[adversario.x+1][adversario.y].tipo!='J') {
        laberinto.celdas[adversario.x][adversario.y].tipo='V';
        adversario.x=adversario.x+1;
        laberinto.celdas[adversario.x][adversario.y].tipo='A';
        laberinto.celdas[adversario.x][adversario.y].indexSprite=Rand_Mod_Sprite()+2;
        
    }else direccion=0;
}
else {
    laberinto.celdas[adversario.x][adversario.y].tipo='V';
    adversario.x=anchuraMundoVirtual-1;
    adversario.y=numeroAleatorio(0,alturaMundoVirtual-1);
    laberinto.celdas[adversario.x][adversario.y].tipo='A';
    laberinto.celdas[adversario.x][adversario.y].indexSprite=Rand_Mod_Sprite()+2;
}
       
       
       
       }
       
}
  /*  public void moverCeldaArriba(){
        if (adversario.y > 0) {
            if (laberinto.celdas[adversario.x][adversario.y-1].tipo != 'O' && laberinto.celdas[adversario.x][adversario.y-1].tipo !='J') {
                if (laberinto.celdas[adversario.x][adversario.y-1].tipo == 'I') {
                    if (adversario.y-2 > 0) {
                        laberinto.celdas[adversario.x][adversario.y-2].tipo = 'I';
                        laberinto.celdas[adversario.x][adversario.y-1].tipo = 'V';
                    }
                }else{
                laberinto.celdas[adversario.x][adversario.y].tipo = 'V';
                adversario.y=adversario.y-1;
                laberinto.celdas[adversario.x][adversario.y].tipo = 'A';
                laberinto.celdas[adversario.x][adversario.y].indexSprite=Rand_Mod_Sprite()+3;
                }  
            }   
        }
    }
*/
  