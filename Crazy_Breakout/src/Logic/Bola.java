package Logic;

import java.awt.geom.Line2D;
import javax.swing.ImageIcon;
import java.awt.geom.Line2D.Double;

/**
 * Clase para manejo de la bola
 * 
 * @version 1.1
 */

public class Bola extends General implements ConstantesCB {
    private double max_x;
    private double max_y;
    
    
    /**Constructor de la clase, inicializa los atributos <code>x_aux</code> y
     * <code>y_aux</code> heredados de la clase <code>General</code>
     * 
     */
    public Bola(){
        setX_aux(1);
        setY_aux(-1);
        
        max_x = x + getAncho();
        max_y = y + getAlto();

        ImageIcon a = new ImageIcon("bola.png");
        setImagen(a.getImage());

        setAncho(getImagen().getWidth(null));
        setAlto(getImagen().getHeight(null));
        iniciarPos(POS_INICIAL_BOLAX, POS_INICIAL_BOLAY);
    }    
    
    /**
     * Permite que la bola se mueva, sumándole las variables auxiliares
     * <code>x_aux</code> y <code>y_aux</code> a las coordenas <code>x</code> y
     * <code>y</code> que pertenecen a la bola
     */
    public void moverse(){
        x += getX_aux();
        y += getY_aux();

        if (x == 0) {
            setX_aux(1);
        }

        if (x == ANCHO_PANTALLA - getAncho()) {
            setX_aux(-1);
        }

        if (y == 0) {
            setY_aux(1);
        }   
    }
    
    /**
     * Devuelve un objeto Double, el cual es una linea que sigue a la bola
     * @return 
     */
    public Line2D getLineaIzq (){
        return new Double(x - 1, y , x - 1, max_y);
    }
    
    public Line2D getLineaSup (){
        return new Double(x, y - 1, max_x, y - 1);
    }
    
    public Line2D getLineaInf (){
        return new Double(x, max_y + 1, max_x, max_y + 1);
    }
    
    public Line2D getLineaDer (){
        return new Double(max_x + 1, y, max_x + 1, max_y);
    }
    
    
}
