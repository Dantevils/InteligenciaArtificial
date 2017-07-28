
import java.util.ArrayList;
import java.util.TimerTask;


public class BusquedaAnchura2Hero extends TimerTask implements Constantes {
      
public Laberinto laberinto;
    public ArrayList<Estado> colaEstados;
    public ArrayList<Estado> historial;
    public ArrayList<Character> pasos;
    public int index_pasos;
    public ArrayList<Estado> destinos;/*Multiples destinos*/
    public Estado inicial;
    public Estado objetivo;
    public Estado temp;
    public boolean exito;
    public boolean parar;
    public Jugador jugador;

public BusquedaAnchura2Hero(Laberinto laberinto, Jugador jugador) {
    this.laberinto=laberinto;
    this.jugador = jugador;
    colaEstados=new ArrayList<>();
    historial=new ArrayList<>();
    pasos=new ArrayList<>();
    index_pasos=0;
    exito=false;
    /*Inicializacion*/
    destinos = new ArrayList<>();
    parar = false;
}

public boolean buscar2(Estado inicial, Estado objetivo){
    index_pasos = 0;
    colaEstados.add(inicial);
    historial.add(inicial);
    this.objetivo = objetivo;
    exito=false; //si el inicial es final, salimos   
    if ( inicial.equals(objetivo)) exito=true; /* si no mientras que la cola no este vacia y no hayamos alcanzado el meta hacemos lo siguiente*/
    while ( !colaEstados.isEmpty() && !exito ){ //tomamos el primero y lo quitamos de cola de estad
    temp=colaEstados.get(0);
    colaEstados.remove(0);//lo exploramos, es decir, generamos sus sucesores // es decir, los estados a los que podemos ir desde el// estado actual
    moverArriba(temp);
    moverAbajo(temp);
    moverIzquierda(temp);
    moverDerecha(temp);
    }
        if (exito) {
            System.out.println("Ruta Calculada");
            this.calcularRuta2();
            return true;
        }else{
            System.out.println("La ruta no pudo carcular");
            return false;
        }

}


/*Movimientos*/
private void moverArriba(Estado e) {
    if ( e.y > 0 ) {
        if ( laberinto.celdas[e.x][e.y-1].tipo != 'O' && laberinto.celdas[e.x][e.y-1].tipo != 'P' &&laberinto.celdas[e.x][e.y-1].tipo != 'A' ) {
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
        if ( laberinto.celdas[e.x][e.y+1].tipo != 'O' && laberinto.celdas[e.x][e.y+1].tipo != 'P' && laberinto.celdas[e.x][e.y+1].tipo != 'A' ) {
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
        if ( laberinto.celdas[e.x-1][e.y].tipo != 'O' && laberinto.celdas[e.x-1][e.y].tipo != 'P' && laberinto.celdas[e.x-1][e.y].tipo != 'A' ) {
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
        if ( laberinto.celdas[e.x+1][e.y].tipo != 'O' && laberinto.celdas[e.x+1][e.y].tipo != 'P' && laberinto.celdas[e.x+1][e.y].tipo != 'A' ) {
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



@Override
public synchronized void run() {
    /*modificacion*/
    if (!parar) {
        Estado subinicial,subobjetivo;
        boolean resultado;
        colaEstados.clear();
        historial.clear();
        pasos.clear();
             
        //subinicial = new Estado(laberinto.LienzoPadre.Hero.jugador.x,laberinto.LienzoPadre.Hero.jugador.y,'N',null);
        subinicial = new Estado(jugador.jugador.x,jugador.jugador.y ,'N',null);
          /*Podemos consultar si el estado inicial al estado siguiente es igual al la pelota, lanzar el hilo de la pelota*/  
            
       // subobjetivo = new Estado(laberinto.LienzoPadre.Hero.jugador.x,laberinto.LienzoPadre.Hero.jugador.y,'N',null);
        
          subobjetivo = new Estado(laberinto.LienzoPadre.Pelota.item.x,laberinto.LienzoPadre.Pelota.item.y,'N',null);
        //subobjetivo = new Estado(laberinto.LienzoPadre.Pelota.item.x,laberinto.LienzoPadre.Pelota.item.y,'N',null);
        
        resultado = this.buscar2(subinicial, subobjetivo);
            
        if (pasos.size()> 1) {
            switch(pasos.get(1)) {
            case 'D':laberinto.LienzoPadre.Hero.moverCeldaAbajo();;break;
            case 'U':laberinto.LienzoPadre.Hero.moverCeldaArriba();break;
            case 'R':laberinto.LienzoPadre.Hero.moverCeldaDerecha();break;
            case 'L':laberinto.LienzoPadre.Hero.moverCeldaIzquierda();break;
            
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
}
    
    
    
    
  
  
}

/*Otras funciones*/

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


    
    
    
  
    

