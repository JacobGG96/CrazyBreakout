package Logic;

import java.util.ArrayList;

/**
 *Clase que controla la lógica del juego
 * 
 */
public class Logic extends ArrayList implements ConstantesCB{
    private Bola bola;
    private Bloque bloque[];
    private Barra b;
    private ArrayList listaj;
    
    public Logic(){
        comenzarJuego();
    }
    
    public void comenzarJuego(){
        bola = new Bola();
        
        int a = 0;
        for(int i = 0; i < 5; i++){
            for(int j = 0 ; j < 6 ; j++){
                bloque[a] = new Bloque(j, j, j);
            }
        } 
    }
    
    public void nuevoJugador(Barra idJug){
        idJug = new Barra();
        listaj.add(idJug);
    }    
    
    
    public static void modifBarra(Barra id, int x_aux){
        id.setX_aux(x_aux);        
    }
    
    public void verificarColision(){
           
        if(bola.getRect().getMaxX() > ANCHO_PANTALLA){
            terminarJuego();
        }        
        
        for(int i = 0, j = 0 ; i < CANTIDAD_BLOQUES ; i++){
            
            if (bloque[i].getDestruido()) {
                j++;
            }
            
            if (j == CANTIDAD_BLOQUES) {
               terminarJuego();
            }  
        }
        
        for(int i = 0 ; i < listaj.size() ; i++){
            Barra barra_aux = getBarra(i);
            if(bola.getRect().intersects(barra_aux.getRect())){
                int posBarra = (int) barra_aux.getRect().getMinX();
                int posBola = (int) bola.getRect().getMinX();
                
                int int1 = posBarra + 4 ;
                int int2 = posBarra + 8;
                int int3 = posBarra + 12;
                int int4 = posBarra + 16;
                
                
            }
        }
        
        
    
    }
    
    public Barra getBarra(int i){
        return (Barra) listaj.get(i);
    }
    
    public void terminarJuego(){
        
    }
        
}


