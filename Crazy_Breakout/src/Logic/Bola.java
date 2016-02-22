
package Logic;

public class Bola extends General {
    
    private int x_aux;
    private int y_aux;
    
    public Bola(){
        
        x_aux = 1;
        y_aux = -1;

        //ImageIcon ii = new ImageIcon("ball.png");
        //imagen = ii.getImage();

        //ancho = image.getWidth(null);
        //largo = image.getHeight(null);

        iniciarPos();
    }

    private void iniciarPos() {
        
    }
    
    public void moverse(){
        
    }

    public void setX_aux(int x_aux) {
        this.x_aux = x_aux;
    }

    public void setY_aux(int y_aux) {
        this.y_aux = y_aux;
    }
    
    
    
    
}
