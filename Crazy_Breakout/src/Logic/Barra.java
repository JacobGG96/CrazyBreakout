package Logic;

import javax.swing.ImageIcon;

/**
 * Clase para el manejo de la barra
 *
 */
public class Barra extends General implements ConstantesCB {
    int id_jug;
    
    /**
     * Asigna una imagen al objeto e inicializa la posición de la barra
     * en una coordenada predefinida
     */
    public Barra(int id_jug){
        this.id_jug = id_jug;
                
        ImageIcon a = new ImageIcon("barra.png");
        setImagen(a.getImage());

        setAncho(10);
        setAlto(2);

        //setAncho(getImagen().getWidth(null));
        //setAlto(getImagen().getHeight(null));
        
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

        if (x >= ANCHO_PANTALLA - getAncho()) {
            x = ANCHO_PANTALLA - getAncho();
        }  
    }

    public int getId_jug() {
        return id_jug;
    }

    public void setId_jug(int id_jug) {
        this.id_jug = id_jug;
    } 
    
    
}
