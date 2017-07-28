
/*Clase de estado */
public class Estado {
    public int x;
    public int y;
    /*’N’=nada, ’L’: izquierda, ’R’: derecha, ’U’: Arriba, ’D’: abajo */
    public char oper; // N nada, l = izq aaaaaaa
    public Estado  predecesor;
    public double prioridad;
     
    
    
    public Estado(int x,int y,char oper, Estado predecesor){
        this.x=x;
        this.y =y;
        this.oper = oper;
        this.predecesor=predecesor;
      }

    @Override
        public boolean equals(Object x) {
        Estado e=(Estado)x;
        return this.x==e.x && this.y==e.y;
    }
    @Override
        public int hashCode(){
        
        int hash = 3;
        hash = 89*hash +this.x;
        hash = 89*hash +this.y;
        return hash;
        }
       @Override
        public String toString() {
        return "("+x+","+y+"): Prioridad= "+this.prioridad;
        }
        
        public int compareTo(Object o) {
        Estado e=(Estado)o;
        if ( this.prioridad == e.prioridad ) return 0;
        else {
        if ( this.prioridad > e.prioridad ) return 1;
        else return -1;
        }
}
        
        //public String toString(){
        //return 
        
       // }
        
        
   // Estado(int i, int i0, char c, Object object) {
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }
    

}
