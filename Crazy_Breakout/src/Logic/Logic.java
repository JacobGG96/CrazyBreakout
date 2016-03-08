package Logic;

import java.util.ArrayList;
import java.util.Random;

/**
 *Clase que controla la lógica del juego
 * 
 */
public class Logic extends ArrayList implements ConstantesCB{
    private Bola bola;
    private Bloque bloque[];
    private Barra b;
    private ArrayList listaj;
    
    /**
     * Constructor de la clase Logic, llama al método comenzarJuego()
     */
    public Logic(){
        comenzarJuego();
    }
    
    /**
     * Crea un objeto Bola e inicializa y asigna coordenadas a los bloques del 
     * juego
     */
    public void comenzarJuego(){
        bola = new Bola();
        
        Random aleatorio = new Random();
        
        int a = 0;
        for(int i = 0; i < 5; i++){
            for(int j = 0 ; j < 6 ; j++){
                bloque[a] = new Bloque(j, j, aleatorio.nextInt(3) );
            }
        } 
    }
    
       
    
    /**
     * Crea un objeto barra, el cual está asociado con el nuevo jugador
     * @param idJug id del jugador nuevo el cual va a ser el nombre del objeto
     * barra
     */
    public void nuevoJugador(Barra idJug){
        idJug = new Barra();
        listaj.add(idJug);
    }    
    
    /**
     * Mediante este método la clase Servidor envía información acerca 
     * del movimiento de una barra específica.
     * @param id nombre de la barra a modificar
     * @param x_aux mediante esta variable se puede ver a donde se mueve
     * la barra, mediante los valores 1 ó -1
     */
    public static void modifBarra(Barra id, int x_aux){
        id.setX_aux(x_aux);        
    }
    
    /**
     * Verifica todas las posibles colisiones en el juego y analiza si el 
     * juego debe terminar, ya sea que la bola cruce el borde de la pantalla
     * o se hayan destruido todos los bloques
     */
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
            int sub_parte = barra_aux.getAncho() / 4;
            
            if(bola.getRect().intersects(barra_aux.getRect())){
                int posBarra = (int) barra_aux.getRect().getMinX();
                int posBola = (int) bola.getRect().getMinX();
                
                int int1 = posBarra + sub_parte;
                int int2 = posBarra + 2 * sub_parte;
                int int3 = posBarra + 3 * sub_parte;
                int int4 = posBarra + barra_aux.getAncho();
                
                if(posBola < int1){
                    
                }
                
                if(posBola >= int1 && posBola < int2){
                    
                }
                
                if(posBola >= int2 && posBola < int3){
                    
                }
                
                if(posBola >= int3 && posBola < int4){
                    
                }
                
                
            }
            
        }
        
        for(int i = 0; i < CANTIDAD_BLOQUES; i++){
            Bloque act_bloque = bloque[i];
            
            if(bola.getRect().intersects(act_bloque.getRect())){
                
                if ( !act_bloque.getDestruido()){
                    
                    if(bola.getRect().intersects(act_bloque.getRect1())){
                        
                    } 
                    
                    if(bola.getRect().intersects(act_bloque.getRect2())){
                        
                    }
                    
                    if(bola.getRect().intersects(act_bloque.getRect3())){
                        
                    }
                    
                    if(bola.getRect().intersects(act_bloque.getRect4())){
                        
                    }
                    
                }
                
                //por el momento -1, puede haber mas daño 
                act_bloque.setResistencia(-1);
                
            }
            
            
        }
        
        
    
    }
    
    /**
     * Hace un casting del elemento Object que devuelve 
     * la <code>ArrayList</code> 
     * @param i posición de la lista
     * @return el objeto barra de la lista
     */
    public Barra getBarra(int i){
        return (Barra) listaj.get(i);
    }
    
    public void terminarJuego(){
        System.out.println("Game Over");
        
    }
        
}


