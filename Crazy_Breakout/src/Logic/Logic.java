package Logic;

import java.util.ArrayList;
import java.util.Random;
import java.awt.Point;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Clase que controla la lógica del juego
 * 
 */
public class Logic extends Thread implements ConstantesCB{
    private Bola bola;
    private Bloque bloque[];
    private ArrayList listaj;
    private boolean en_juego;
    private Timer tiempo;
    private int turnos;
    
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
        bloque = new Bloque[30];
        en_juego = true;
        listaj = new ArrayList();
        turnos = 3;
        
        Timer tiempo = new Timer();
        
        Random aleatorio = new Random();
        
        int a = 0;
        for(int i = 0; i < 5; i++){
            for(int j = 0 ; j < 6 ; j++){
                bloque[a] = new Bloque(170 + 10 * j, 20 + i * 4, aleatorio.nextInt(3) );
                a++;
            }
        } 
    }

    public Bola getBola() {
        return bola;
    }
    
       
    
    /**
     * Crea un objeto barra, el cual está asociado con el nuevo jugador y se 
     * agrega a una estructura de datos
     * @param idJug id del jugador nuevo el cual va a ser el nombre del objeto
     * barra
     */
    public void nuevoJugador(){
        int num_jug = 1;
        Barra a = new Barra(num_jug);
        listaj.add(a);
        num_jug ++;
    }    
    
    /**
     * Mediante este método la clase Servidor envía información acerca 
     * del movimiento de una barra específica.
     * @param id nombre de la barra a modificar
     * @param x_aux mediante esta variable se puede ver a donde se mueve
     * la barra, mediante los valores 1 ó -1
     */
    public void modifBarra(Barra id, int x_aux){
        id.setX_aux(x_aux);        
    }
    
    /**
     * Este método debe ser llamado por el servidor cuando se vaya a 
     * eliminar un jugador, esto puede ser porque se retira un jugador
     * del juego
     * @param id identificación del jugador que se desea eliminar 
     */
    public void eliminarJugador(int id){
        for(int i = 0 ; i < listaj.size() ; i++){
            if(getBarra(i).id_jug == id){
                listaj.remove(i);
            }
        }   
        
    }
    
    @Override
    public void run(){
        while(en_juego == true){
            try {
                bola.moverse();
                verificarColision();
                System.out.println("x : " + bola.getX());
                System.out.println("y : " + bola.getY());
                
                for(int i = 0 ; i < listaj.size() ; i++) {
                    getBarra(i).moverse();
                }
                
                Thread.sleep(1);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Verifica todas las posibles colisiones en el juego y analiza si el 
     * juego debe terminar, ya sea que la bola cruce el borde de la pantalla
     * o se hayan destruido todos los bloques
     */
    public void verificarColision(){
           
        if(bola.getRect().getMaxY() >  ALTO_PANTALLA){
            turnos -= 1 ;   
            comenzarJuego();
            //terminarJuego();
            if(turnos <= 0){
                terminarJuego();
            }
            
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
                System.out.println("Colision barra");
                int posBarra = (int) barra_aux.getRect().getMinX();
                int posBola = (int) bola.getRect().getMinX();

                int int1 = posBarra + sub_parte;
                int int2 = posBarra + 2 * sub_parte;
                int int3 = posBarra + 3 * sub_parte;
                int int4 = posBarra + barra_aux.getAncho();

                if(posBola < int1){
                    bola.setX_aux(-1);
                    bola.setY(-1);                    
                }

                if(posBola >= int1 && posBola < int2){
                    bola.setY_aux(-1);
                }

                if(posBola >= int2 && posBola < int3){
                    bola.setX_aux(0);
                    bola.setY_aux(-1);
                }

                if(posBola >= int3 && posBola < int4){
                    bola.setX_aux(1);
                    bola.setY_aux(-1);
                }

            }
        }
        
        for(int i = 0; i < CANTIDAD_BLOQUES; i++){
            Bloque act_bloque = bloque[i];
            
            if( bola.getRect().intersects(act_bloque.getRect())){   
                int ballLeft = (int) bola.getRect().getMinX();
                int ballHeight = (int) bola.getRect().getHeight();
                int ballWidth = (int) bola.getRect().getWidth();
                int ballTop = (int) bola.getRect().getMinY();

                Point pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
                Point pointLeft = new Point(ballLeft - 1, ballTop);
                Point pointTop = new Point(ballLeft, ballTop - 1);
                Point pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);

                if (!act_bloque.getDestruido()) {
                    System.out.println("Colision bloque");
                    if (act_bloque.getRect().contains(pointRight)) {
                        System.out.println("Choque punto derecho");
                        bola.setX_aux(-1);
                    } else if (act_bloque.getRect().contains(pointLeft)) {
                        System.out.println("Choque pto izq");
                        bola.setX_aux(1);
                    }

                    if (act_bloque.getRect().contains(pointTop)) {
                        System.out.println("Choque punto sup");
                        bola.setY_aux(1);
                        
                    } else if (act_bloque.getRect().contains(pointBottom)) {
                        System.out.println("Choq punto inferior");
                        bola.setY_aux(-1);
                    }

                    
                    
                    
                    
                    /*if(act_bloque.getRect().intersectsLine(bola.getLineaSup())){
                        System.out.println("Choque linea sup");
                        bola.setY_aux(1);
                    }
                    
                    else if(act_bloque.getRect().intersectsLine(bola.getLineaIzq())){
                        System.out.println("Choque linea izq");
                        bola.setX_aux(1);
                    }
                    
                    if(act_bloque.getRect().intersectsLine(bola.getLineaInf())){
                        System.out.println("Choque linea inf");
                        bola.setY_aux(-1);
                    }
                    
                    else if(act_bloque.getRect().intersectsLine(bola.getLineaDer())){
                        System.out.println("Choque linea der");
                        bola.setX_aux(-1);
                    }  */
                
                
                act_bloque.setResistencia(1);
                
                }
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
    
    /**
     * Metodo que termina el juego
     */    
    public void terminarJuego(){
        en_juego = false;
        System.out.println("Game Over");
    }
    
}


