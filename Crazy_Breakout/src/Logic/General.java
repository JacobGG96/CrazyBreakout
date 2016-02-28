package Logic;

import java.awt.Image;
import java.awt.Rectangle;

/**
 * Clase General que contiene los comportamientos y atributos
 * en común entre las clases principales
 * 
 */

public class General {
    private int ancho;
    private int largo;
    protected int x;
    protected int y;
    private int x_aux;
    private int y_aux;
    private Image imagen;
    
    /**
     * Pone al objeto en una posición inicial predefinida
     * @param x coordenada x 
     * @param y coordenada y
     */    
    public void iniciarPos(int x, int y){
        setX(x);
        setY(y);
    }                
    
    /**
     * Devuelve la referencia de la imagen que corresponde al objeto
     * @return imagen 
     */
    public Image getImagen() {
        return imagen;
    }
    
    /**
     * Asigna un nuevo objeto Image a la variable imagen
     * @param imagen 
     */
    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
    
    /**
     * 
     * @return 
     */ 
    public Rectangle getRect(){
        return new Rectangle(x, y, imagen.getWidth(null), imagen.getHeight(null));
    }
    
    /**
     * 
     * @return 
     */
    public int getAncho() {
        return ancho;
    }
    
    /**
     * 
     * @param ancho 
     */
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    
    /**
     * 
     * @return 
     */
    public int getLargo() {
        return largo;
    }

    /**
     * 
     * @param largo 
     */    
    public void setLargo(int largo) {
        this.largo = largo;
    }

    /**
     * 
     * @return 
     */
    public int getX() {
        return x;
    }

    /**
     * 
     * @param x 
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * 
     * @return 
     */
    public int getY() {
        return y;
    }

    /**
     * 
     * @param y 
     */
    public void setY(int y) {
        this.y = y;
    }

    public int getX_aux() {
        return x_aux;
    }

    /**
     * Configura <code> x_aux </code> 
     * @param x_aux permite mover la bola al sumarle una unidad a la 
     * variable <code>x</code> que define la posición de la bola
     */
    public void setX_aux(int x_aux) {
        this.x_aux = x_aux;
    }

    public int getY_aux() {
        return y_aux;
    }

    /**
     * Configura <code> y_aux </code> 
     * @param y_aux permite mover la bola al sumarle una unidad a la 
     * variable <code>y</code> que define la posición de la bola
     */
    public void setY_aux(int y_aux) {
        this.y_aux = y_aux;
    }
    
    
    
    
    
}
