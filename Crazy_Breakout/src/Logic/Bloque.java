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
    //private int sub_ancho;
    //private int sub_alto;
    
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
        //setImagen(a.getImage()); Eliminar, no se ocupa, solo en interfaz

        setAncho(getImagen().getWidth(null));
        setAlto(getImagen().getHeight(null));
    }
    public Bloque(int x, int y, int res, boolean sorpresa){
        this.x = x;
        this.y = y;
        resistencia = res;
        
    }

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
