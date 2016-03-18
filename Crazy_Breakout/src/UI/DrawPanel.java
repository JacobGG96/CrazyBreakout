/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author gustavohg
 */
public class DrawPanel extends JPanel{
    
    private final String message = "Game Over";
    private Image Bola;
    private Image Barra;
    private int x_bola;
    private int y_bola;
    private int x_barra;
    private int y_barra;
    //private Image Bloque;

    public DrawPanel(Nuevo_Jugador Jugador) {
        
        this.x_bola = Jugador.getPos_bola_x();
        this.y_bola = Jugador.getPos_bola_y();
        
        this.x_barra = Jugador.getPos_barra_x();
        this.y_barra = Jugador.getPos_barra_y();
        
        System.out.println(this.x_bola);
        System.out.println(this.y_bola);
        System.out.println(this.x_barra);
        System.out.println(this.y_barra);
        
        ImageIcon ibo = new ImageIcon(getClass().getResource("/Images/Bola.jpg"));
        this.Bola = ibo.getImage();
        
        ImageIcon iba = new ImageIcon(getClass().getResource("/Images/Barra.jpg"));
        this.Barra = iba.getImage();

        initBoard();
        
    }

    private void initBoard() {

        setFocusable(true);
        setDoubleBuffered(true);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        drawObjects(g2d);

    }
    
    private void drawObjects(Graphics2D g2d) {
        
        g2d.drawImage(Bola, this.x_bola, this.y_bola,25, 25, this);
        
        g2d.drawImage(Barra, this.x_barra, this.y_barra, 50, 10, this);

        /*for (int i = 0; i < N_OF_BRICKS; i++) {
            if (!bricks[i].isDestroyed()) {
                g2d.drawImage(bricks[i].getImage(), bricks[i].getX(),
                        bricks[i].getY(), bricks[i].getWidth(),
                        bricks[i].getHeight(), this);
            }
        }*/
    }
    
}
