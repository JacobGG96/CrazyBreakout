package Logic;

import java.awt.Rectangle;
import java.awt.geom.Line2D;
import javax.swing.ImageIcon;
import java.awt.geom.Line2D.Double;

/**
 * Clase para manejo de los bloques
 * 
 * @version 1.1
 */

public class Bloque extends General{
    
    private boolean destruido;
    private int resistencia;
    private boolean sorpresa;
    
    /**
     * Constructor de la clase, asigna a los bloques una imagen
     * 
     * @param x coordenada x del bloque
     * @param y coordenada y del bloque
     */
    public Bloque(int x, int y, int res) {
        
                
        this.x = x;
        this.y = y;
        resistencia = res;
        
        destruido = false;
        
        ImageIcon a = new ImageIcon("bloque.png");
              
        setAncho(4);
        setAlto(2);
    }
    
    /**
     * Constructor sobrecargado
     * @param x coordenada x del bloque
     * @param y coordenada y del bloque
     * @param res resistencia del bloque
     * @param sorpresa tipo de sorpresa que trae el bloque
     */
    public Bloque(int x, int y, int res, boolean sorpresa){
        this.x = x;
        this.y = y;
        resistencia = res;
        
    }

    /**
     * Configura la resistencia del bloque
     * @param daño el daño recibido por la <code>bola</code>
     */
    public void setResistencia(int daño) {
        this.resistencia += daño;
        if(this.resistencia == 0){
            setDestruido(true);
        }
    }    
       
    /**
     * Devuelve el estado del bloque
     * @return si el <code>bloque</code>
     */
    public boolean getDestruido() {
        return destruido;
    }
    
    /**
     * Configura el estado del bloque
     * @param valor configura si el <code>bloque</code> esta destruido
     */
    public void setDestruido(boolean valor) {
        destruido = valor;
    } 
    
}
