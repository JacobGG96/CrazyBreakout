package Logic;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * Clase para manejo de los bloques
 * 
 * @version 1.1
 */

public class Bloque extends General{
    
    private boolean destruido;
    private int resistencia;
    private Rectangle rect1;
    private Rectangle rect2;
    private Rectangle rect3;
    private Rectangle rect4;
    private boolean sorpresa;
    private int sub_ancho;
    private int sub_alto;
    
    /**
     * Constructor de la clase, asigna a los bloques una imagen
     * 
     * @param x coordenada x del bloque
     * @param y coordenada y del bloque
     */
    public Bloque(int x, int y, int res) {
        
        sub_ancho = getAncho() / 2;
        sub_alto = getAlto() / 2;
        
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
        if(this.resistencia == 0){
            setDestruido(true);
        }
        
        this.resistencia += daño;
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
    
    public Rectangle getRect1() {
        return new Rectangle(x, y, sub_ancho , sub_alto);
    }

    public Rectangle getRect2() {
        return new Rectangle(x + sub_ancho, y, sub_ancho , sub_alto);
    }

    public Rectangle getRect3() {
        return new Rectangle(x, y + sub_alto, sub_ancho , sub_alto);
    }

    public Rectangle getRect4() {
        return new Rectangle(x + sub_ancho, y + sub_alto, sub_ancho , sub_alto);
    }
    
    
    
}
