
import java.util.ArrayList;
import java.util.TimerTask;


public class BusquedaAnchuraBall extends TimerTask implements Constantes {
    
public Laberinto laberinto;
public ArrayList<Estado> colaEstados;
public ArrayList<Estado> historial;
public ArrayList<Character> pasos;
public int index_pasos;
public ArrayList<Estado> destinos;/*Multiples destinos*/
public ArrayList<Estado> destinos2;/*Multiples destinos*/
public ArrayList<Estado> destinos3;/*Multiples destinos*/
public Estado inicial;
public Estado objetivo;
public Estado temp;
public boolean exito;
public boolean parar;
public Item Ball;
  




public BusquedaAnchuraBall(Laberinto laberinto, Item Ball) {
    this.laberinto=laberinto;
    this.Ball = Ball;
    colaEstados=new ArrayList<>();
    historial=new ArrayList<>();
    pasos=new ArrayList<>();
    index_pasos=0;
    exito=false;
    /*Inicializacion*/
    destinos = new ArrayList<>();
    destinos2 = new ArrayList<>();
    destinos3 = new ArrayList<>();
    parar = false;
}

public boolean buscar2(Estado inicial, Estado objetivo){
    index_pasos = 0;
    colaEstados.add(inicial);
    historial.add(inicial);
    this.objetivo = objetivo;
    exito=false;
    //si el inicial es final, salimos
    if ( inicial.equals(objetivo)) exito=true;
    // si no mientras que la cola no este vacia y no hayamos
    // alcanzado el meta hacemos lo siguiente
    while ( !colaEstados.isEmpty() && !exito ){
    //tomamos el primero y lo quitamos de cola de estad
    temp=colaEstados.get(0);
    colaEstados.remove(0);
    //lo exploramos, es decir, generamos sus sucesores,
    // es decir, los estados a los que podemos ir desde el
    // estado actual
    moverArriba(temp);
    moverAbajo(temp);
    moverIzquierda(temp);
    moverDerecha(temp);
    }
        if (exito) {
            System.out.println("Ruta Calculada");
            this.calcularRuta2();
            return true;
        }
        else{

            System.out.println("La ruta no pudo carcular");
            return false;
        }

}


/* public void buscar(int x1,int y1,int x2,int y2) {
//creamos el estado inicial y el objetivo
inicial=new Estado(x1,y1,'N',null);
objetivo=new Estado(x2,y2,'P',null);
//los añadimos a la cola de estados y al historial
colaEstados.add(inicial);
historial.add(inicial);
//si el inicial es final, salimos
if ( inicial.equals(objetivo)) exito=true;
// si no mientras que la cola no este vacia y no hayamos
// alcanzado el meta hacemos lo siguiente
while ( !colaEstados.isEmpty() && !exito ){
//tomamos el primero y lo quitamos de cola de estad
temp=colaEstados.get(0);
colaEstados.remove(0);
//lo exploramos, es decir, generamos sus sucesores,
// es decir, los estados a los que podemos ir desde el
// estado actual
moverArriba(temp);
moverAbajo(temp);
moverIzquierda(temp);
moverDerecha(temp);
}
if ( exito ) System.out.println("Ruta calculada");
else System.out.println("La ruta no pudo calcularse");
}*/


/*Movimientos*/
private void moverArriba(Estado e) {
    if ( e.y > 0 ) {
    if ( laberinto.celdas[e.x][e.y-1].tipo != 'O'&& laberinto.celdas[e.x][e.y-1].tipo != 'P'&& laberinto.celdas[e.x][e.y-1].tipo != 'A'&& laberinto.celdas[e.x][e.y-1].tipo != 'J' ) {
        Estado arriba=new Estado(e.x,e.y-1,'U',e);
            if ( !historial.contains(arriba)) {
            colaEstados.add(arriba);
            historial.add(arriba);
                if ( arriba.equals(objetivo)) {
                objetivo=arriba;
                exito=true;
                }
            }
        }
    }
}//fin del metodo moverArriba
private void moverAbajo(Estado e) {
    if ( e.y+1 < alturaMundoVirtual ) {
        if ( laberinto.celdas[e.x][e.y+1].tipo != 'O'&& laberinto.celdas[e.x][e.y+1].tipo != 'P' && laberinto.celdas[e.x][e.y+1].tipo != 'A'&& laberinto.celdas[e.x][e.y+1].tipo != 'J' ) {
        Estado abajo=new Estado(e.x,e.y+1,'D',e);
            if ( !historial.contains(abajo)) {
            colaEstados.add(abajo);
            historial.add(abajo);
                if ( abajo.equals(objetivo)) {
                objetivo=abajo;
                exito=true;
                }
            }
        }
    }
}
private void moverIzquierda(Estado e) {
    if ( e.x > 0 ) {
        if ( laberinto.celdas[e.x-1][e.y].tipo != 'O' && laberinto.celdas[e.x-1][e.y].tipo != 'P' && laberinto.celdas[e.x-1][e.y].tipo != 'A' && laberinto.celdas[e.x-1][e.y].tipo != 'J') {
        Estado izquierda=new Estado(e.x-1,e.y,'L',e);
            if ( !historial.contains(izquierda)) {
            colaEstados.add(izquierda);
            historial.add(izquierda);
                if ( izquierda.equals(objetivo)) {
                objetivo=izquierda;
                exito=true;
                }
            }
        }
    }
}// fin del metodo izquierda
private void moverDerecha(Estado e) {
    if ( e.x < anchuraMundoVirtual-1 ) {
        if ( laberinto.celdas[e.x+1][e.y].tipo != 'O' && laberinto.celdas[e.x+1][e.y].tipo != 'P' && laberinto.celdas[e.x+1][e.y].tipo != 'A' && laberinto.celdas[e.x+1][e.y].tipo != 'J' ) {
        Estado derecha=new Estado(e.x+1,e.y,'R',e);
            if ( !historial.contains(derecha)){
            colaEstados.add(derecha);
            historial.add(derecha);
                if ( derecha.equals(objetivo)) {
                objetivo=derecha;
                exito=true;
                }
            }
        }
    }
}
    

public void calcularRuta() {
Estado predecesor=objetivo;
do{
pasos.add(predecesor.oper);
predecesor=predecesor.predecesor;
}while ( predecesor != null);
index_pasos=pasos.size()-1;
}

public void calcularRuta2() {
Estado predecesor=objetivo;
do{
pasos.add(0,predecesor.oper);
predecesor=predecesor.predecesor;
}while ( predecesor != null);
index_pasos=pasos.size()-1;
}

/*Para Orientar el Hilo*/
public boolean Contacofail(int x,int y){
    Estado ActualPelota;
ActualPelota = new Estado(Ball.item.x,Ball.item.y,'N',null);
 
 if (ActualPelota.equals(new Estado(x-1,y,'N',null))) {
        System.out.println("Izquierda"); 
    // laberinto.LienzoPadre.adversario.moverCeldaArriba();
      // laberinto.LienzoPadre.adversario.moverCeldaIzquierda();
      //laberinto.LienzoPadre.repaint();
        return true;
    }
return false;
}

public boolean Contacofail2(int x,int y){
    Estado ActualPelota;
ActualPelota = new Estado(Ball.item.x,Ball.item.y,'N',null);
 
 if (ActualPelota.equals(new Estado(x,y-1,'N',null))) {
        System.out.println("contactofail2"); 
    // laberinto.LienzoPadre.adversario.moverCeldaArriba();
      // laberinto.LienzoPadre.adversario.moverCeldaIzquierda();
      //laberinto.LienzoPadre.repaint();
        return true;
    }
return false;
}

public boolean ContactoPelotajugador(int x,int y,int j,int k){
Estado ActualPelota;
ActualPelota = new Estado(Ball.item.x,Ball.item.y,'N',null);

 if (ActualPelota.equals(new Estado(x+1,y,'N',null))==true && ActualPelota.equals(new Estado(j-1,k,'N',null))==true) {
        System.out.println("Con los 2 maricones al lado");          
        return true;
    }
 return false;
}


public boolean ContactoPelota(int x,int y){
Estado ActualPelota;
ActualPelota = new Estado(Ball.item.x,Ball.item.y,'N',null);



    if (ActualPelota.equals(new Estado(x,y-1,'N',null))) {
        System.out.println("Arriba");  
      
        
        return true;
    }
    if (ActualPelota.equals(new Estado(x,y+1,'N',null))) {
        System.out.println("Abajo");  
        return true;
    }
    if (ActualPelota.equals(new Estado(x-1,y,'N',null))) {
        System.out.println("Izquierda"); 
    // laberinto.LienzoPadre.adversario.moverCeldaArriba();
      // laberinto.LienzoPadre.adversario.moverCeldaIzquierda();
      //laberinto.LienzoPadre.repaint();
        return true;
    }
    if (ActualPelota.equals(new Estado(x+1,y,'N',null))) {
        System.out.println("Derecha"); 
      //laberinto.LienzoPadre.adversario.moverCeldaAbajo();
    //laberinto.LienzoPadre.adversario.moverCeldaDerecha();
       
        // laberinto.LienzoPadre.adversario.moverCeldaIzquierdaArriba();
    //   laberinto.LienzoPadre.repaint();
        return true;
    }
    
    

    return false;
}


@Override
public synchronized void run() {
    if (!parar && ContactoPelotajugador(laberinto.LienzoPadre.adversario.adversario.x,laberinto.LienzoPadre.adversario.adversario.y,laberinto.LienzoPadre.Hero.jugador.x ,laberinto.LienzoPadre.Hero.jugador.y)==true) {
        this.laberinto.LienzoPadre.Pelota.REBOTECTM();
        laberinto.LienzoPadre.repaint();
    }
    /*modificacion*/
    /*if (!parar && ContactoPelota(laberinto.LienzoPadre.adversario.adversario.x,laberinto.LienzoPadre.adversario.adversario.y) ==true ) {
       
    
        
    }
     if (!parar && Contacofail2(laberinto.LienzoPadre.Hero.jugador.x ,laberinto.LienzoPadre.Hero.jugador.y ) == true) {
         
     this.laberinto.LienzoPadre.Pelota.REBOTEfail2();
             laberinto.LienzoPadre.repaint();
     }*/
    
     if (!parar && Contacofail(laberinto.LienzoPadre.adversario.adversario.x,laberinto.LienzoPadre.adversario.adversario.y) == true) {
         
     this.laberinto.LienzoPadre.Pelota.REBOTE2();
             laberinto.LienzoPadre.repaint();
     }
    
    
         if (!parar && ContactoPelota(laberinto.LienzoPadre.adversario.adversario.x,laberinto.LienzoPadre.adversario.adversario.y) == true && ContactoPelota(laberinto.LienzoPadre.Hero.jugador.x,laberinto.LienzoPadre.Hero.jugador.y) == true ) {
        System.out.println("Rebote");
        
            //subinicial = new Estado(laberinto.LienzoPadre.Hero.jugador.x,laberinto.LienzoPadre.Hero.jugador.y,'N',null);
this.laberinto.LienzoPadre.Pelota.REBOTE();
       /* this.Ball.laberinto.celdas[Ball.item.x][Ball.item.y].tipo='V';
        int y = numeroAleatorio(Ball.item.y+2,Ball.item.y+4);
        int x = numeroAleatorio(Ball.item.x+2,Ball.item.x+4);
        this.Ball.laberinto.celdas[x][y].tipo='I';
            
         */
        laberinto.LienzoPadre.repaint();
    }
    
    
   
    
    

        
    
  
    
    
    if (!parar && ContactoPelota(laberinto.LienzoPadre.adversario.adversario.x,laberinto.LienzoPadre.adversario.adversario.y) == true ) {
        System.out.println("El loco esta serca");
       // this.laberinto.LienzoPadre.Pelota.BAB.destinos.add(new Estado(laberinto.LienzoPadre.Hero.jugador.x,laberinto.LienzoPadre.Hero.jugador.y,'N',null));
        Estado subinicial,subobjetivo;
        boolean resultado;
        colaEstados.clear();
        historial.clear();
        pasos.clear();
        
        
        do {
            //subinicial = new Estado(laberinto.LienzoPadre.Hero.jugador.x,laberinto.LienzoPadre.Hero.jugador.y,'N',null);
            subinicial = new Estado(Ball.item.x,Ball.item.y,'N',null);
            
            
            subobjetivo = destinos.get(0);
            
            
            resultado = this.buscar2(subinicial, subobjetivo);
            
            if (resultado == false ) {
            destinos.remove(subobjetivo);
            colaEstados.clear();
            historial.clear();
            pasos.clear();
                
            }
            
       
            if (subinicial.equals(subobjetivo)) {
                destinos.remove(subobjetivo);
                
            }
            if (destinos.isEmpty()) {
                System.out.println("se acabo a donde ir");
                parar = true;
                this.cancel();
                
            }
        } while (!resultado && !destinos.isEmpty());
        if (pasos.size()> 1) {
            switch(pasos.get(1)) {
            case 'D': laberinto.LienzoPadre.Pelota.moverCeldaAbajo();break;
            case 'U': laberinto.LienzoPadre.Pelota.moverCeldaArriba();break;
            case 'R': laberinto.LienzoPadre.Pelota.moverCeldaDerecha();break;
            case 'L': laberinto.LienzoPadre.Pelota.moverCeldaIzquierda();break;
            
        }
        laberinto.LienzoPadre.repaint();
    }
    
    
    
    
    
    
    
    /*
    
if ( index_pasos >= 0 ) {
switch(pasos.get(index_pasos)) {
case 'D': laberinto.LienzoPadre.Hero.moverCeldaAbajo();break;
case 'U': laberinto.LienzoPadre.Hero.moverCeldaArriba();break;
case 'R': laberinto.LienzoPadre.Hero.moverCeldaDerecha();break;
case 'L': laberinto.LienzoPadre.Hero.moverCeldaIzquierda();break;
}
laberinto.LienzoPadre.repaint();
index_pasos--;
}else {
this.cancel();*/
}  
  /*
       if (!parar && ContactoPelota(laberinto.LienzoPadre.Hero.jugador.x,laberinto.LienzoPadre.Hero.jugador.y) == true ) {
        System.out.println("El HERO esta serca");
       // this.laberinto.LienzoPadre.Pelota.BAB.destinos.add(new Estado(laberinto.LienzoPadre.Hero.jugador.x,laberinto.LienzoPadre.Hero.jugador.y,'N',null));
        Estado subinicial,subobjetivo;
        boolean resultado;
        colaEstados.clear();
        historial.clear();
        pasos.clear();
        
        
        do {
            //subinicial = new Estado(laberinto.LienzoPadre.Hero.jugador.x,laberinto.LienzoPadre.Hero.jugador.y,'N',null);
            subinicial = new Estado(Ball.item.x,Ball.item.y,'N',null);
            
            
            subobjetivo = destinos2.get(0);
            
            
            resultado = this.buscar2(subinicial, subobjetivo);
            
            if (resultado == false ) {
            destinos2.remove(subobjetivo);
            colaEstados.clear();
            historial.clear();
            pasos.clear();
                
            }
            
       
            if (subinicial.equals(subobjetivo)) {
                destinos2.remove(subobjetivo);
                
            }
            if (destinos2.isEmpty()) {
                System.out.println("se acabo a donde ir");
                parar = true;
                this.cancel();
                
            }
        } while (!resultado && !destinos2.isEmpty());
        if (pasos.size()> 1) {
            switch(pasos.get(1)) {
            case 'D': laberinto.LienzoPadre.Pelota.moverCeldaAbajo();break;
            case 'U': laberinto.LienzoPadre.Pelota.moverCeldaArriba();break;
            case 'R': laberinto.LienzoPadre.Pelota.moverCeldaDerecha();break;
            case 'L': laberinto.LienzoPadre.Pelota.moverCeldaIzquierda();break;
            
        }
        laberinto.LienzoPadre.repaint();
    }
    
    
    
    
    
 
}
        */
    
    
    
    
    
}
    
    
    
    
  
    
}
