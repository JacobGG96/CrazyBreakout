package Logic;

import javax.swing.ImageIcon;

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
        setImagen(a.getImage());

        setAncho(getImagen().getWidth(null));
        setLargo(getImagen().getHeight(null));
    }
    public Bloque(int x, int y, int res, boolean sorpresa){
        this.x = x;
        this.y = y;
        resistencia = res;
        
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
