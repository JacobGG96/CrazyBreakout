package Logic;

import javax.swing.ImageIcon;

/**
 * Clase para manejo de la bola
 * 
 * @version 1.1
 */

public class Bola extends General implements ConstantesCB {
    
    
    /**Constructor de la clase, inicializa los atributos <code>x_aux</code> y
     * <code>y_aux</code> heredados de la clase <code>General</code>
     * 
     */
    public Bola(){
        setX_aux(1);
        setY_aux(-1);

        ImageIcon a = new ImageIcon("bola.png");
        setImagen(a.getImage());

        setAncho(getImagen().getWidth(null));
        setLargo(getImagen().getHeight(null));
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
    
}
