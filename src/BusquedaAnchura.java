
import java.io.IOException;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BusquedaAnchura extends TimerTask implements Constantes {
     
    public Laberinto laberinto;
    public ArrayList<Estado> ColaEstados;
    public ArrayList<Estado> Historial;
    public ArrayList<Character> pasos;
    public int index_pasos;
    public Estado inicial;
    public Estado objetivo;
    public Estado temp;
    public boolean exito;
   
    public BusquedaAnchura(Laberinto laberinto){
    
    this.laberinto = laberinto;
    ColaEstados= new ArrayList<>();
    Historial=new ArrayList<>();
    pasos= new ArrayList<>();
    index_pasos = 0;
    inicial=new Estado(0,0,'N',null);
    ColaEstados.add(inicial);
    Historial.add(inicial);
    
    objetivo=new Estado(alturaMundoVirtual-1,anchuraMundoVirtual-1,'N',null);//MODIFICAR
    exito=false; 
    }
    
   public void moverArriba(Estado e){
    if(e.y > 0 ){
        if(laberinto.celdas[e.x][e.y-1].tipo !='O'){
        Estado arriba = new Estado(e.x,e.y-1,'U',e);
        if(!Historial.contains(arriba)){
        ColaEstados.add(arriba);
        Historial.add(arriba);
        if(arriba.equals(objetivo)){
         //   laberinto.celdas[e.x][e.y-1].tipo='J';
            objetivo= arriba;
            exito=true;
        }
        }
        }
    }
    };
   public void moverAbajo(Estado e){
      if(e.y < alturaMundoVirtual-1){
     if(laberinto.celdas[e.x][e.y+1].tipo !='O'){
      Estado abajo = new Estado(e.x,e.y+1,'D',e);
      if(!Historial.contains(abajo)){
      ColaEstados.add(abajo);
      Historial.add(abajo);
      if(abajo.equals(objetivo)){
    //  laberinto.celdas[e.x][e.y+1].tipo='J';
      objetivo= abajo;
      exito=true;
        }
        }
        }
    }
};
   public void moverIzquierda(Estado e){
      if(e.x > 0 ){
      if(laberinto.celdas[e.x-1][e.y].tipo !='O'){
      Estado izquierda = new Estado(e.x-1,e.y,'L',e);
      if(!Historial.contains(izquierda)){
      ColaEstados.add(izquierda);
      Historial.add(izquierda);
      if(izquierda.equals(objetivo)){
    //  laberinto.celdas[e.x-1][e.y].tipo='J';/*Poner en la ultima posicion donde deveria estar o llegar*/
      objetivo= izquierda;
      exito=true;
        }
        }
        }
    
    }
   
   };
   public void moverDerecha(Estado e){
         if(e.x < alturaMundoVirtual-1 ){
      if(laberinto.celdas[e.x+1][e.y].tipo !='O'){
      Estado derecha = new Estado(e.x+1,e.y,'R',e);
      if(!Historial.contains(derecha)){
      ColaEstados.add(derecha);
      Historial.add(derecha);
      if(derecha.equals(objetivo)){
      //laberinto.celdas[e.x+1][e.y].tipo='J';
      objetivo= derecha;
      exito=true;
        }
        }
        }
    
    }
   
   
   };
    
   public void buscar(){
    if (inicial.equals(objetivo)==true){
        exito=true;
    }
    while(!ColaEstados.isEmpty() && !exito){
    temp=ColaEstados.get(0);
    ColaEstados.remove(0);
    moverArriba(temp);
    moverAbajo(temp);
    moverIzquierda(temp);
    moverDerecha(temp);   
    }
    if(exito==true){
        System.out.println("Ruta Calculada");
       this.calcularRuta();
    }else System.out.println("no hay ruta");
} 
   public void calcularRuta(){
   Estado predecesor=objetivo;
   do{
   pasos.add(predecesor.oper);
   predecesor=predecesor.predecesor;
   
   }while(predecesor !=null);
   index_pasos=pasos.size()-1;
       System.out.println("Index_pasos" + index_pasos);
   }

  

  @Override
    public void run() {
        if (index_pasos ==0 ) {
           this.buscar();
      }
       
      if(index_pasos >= 0){            
          switch(pasos.get(index_pasos)){
              case 'D': this.laberinto.LienzoPadre.Hero.moverCeldaAbajo(); break;
              case 'U': this.laberinto.LienzoPadre.Hero.moverCeldaArriba(); ;break;
              case 'R': this.laberinto.LienzoPadre.Hero.moverCeldaDerecha();break;
              case 'L': this.laberinto.LienzoPadre.Hero.moverCeldaIzquierda();break;
                  
          }
          this.laberinto.LienzoPadre.repaint();
          index_pasos--;
        }else{this.cancel();}



//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
