package Logic;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 * Clase para el manejo de la barra
 *
 */
public class Barra extends General implements ConstantesCB {

    /**
     * Asigna una imagen al objeto e inicializa la posición de la barra
     * en una coordenada predefinida
     */
    public Barra(){
        ImageIcon a = new ImageIcon("barra.png");
        setImagen(a.getImage());

        setAncho(getImagen().getWidth(null));
        setAlto(getImagen().getHeight(null));
        
        iniciarPos(POS_INICIAL_BARRAX, POS_INICIAL_BARRAY);
    }
    
    /**
     * Permite el movimiento de la barra mediante la modificación de la 
     * coordenada de esta al sumarle a la variable correspondiente la 
     * variable <code>x_aux</code>
     */
    public void moverse(){
        x += getX_aux();

        if (x <= 0) {
            x = 0;
        }

        if (x >= LARGO_PANTALLA - getAncho()) {
            x = LARGO_PANTALLA - getAncho();
        }  
    }
    
}
