
package Logic;

public class Bloque extends General{
    
    private boolean destruido;

    public Bloque(int x, int y) {
        
        this.x = x;
        this.y = y;

       // ImageIcon a = new ImageIcon("brick.png");
       // imagen = a.getImage();

       // ancho = image.getWidth(null);
       // largo = image.getHeight(null);

        destruido = false;
    }

    public boolean esta_Destruido() {
        
        return destruido;
    }

    public void setDestruido(boolean valor) {
        
        destruido = valor;
    }
    
}
