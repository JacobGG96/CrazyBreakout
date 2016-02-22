package Logic;

import java.awt.Image;
import java.awt.Rectangle;

public class General {
    
    protected int ancho;
    protected int largo;
    protected int x;
    protected int y;
    protected Image imagen;

    public Image getImagen() {
        return imagen;
    }
    
    public Rectangle getRect(){
        return new Rectangle(x, y, imagen.getWidth(null), imagen.getHeight(null));
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
}
