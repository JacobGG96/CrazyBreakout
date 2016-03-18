/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Logic.ConstantesCB;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Image;
import javax.swing.JFrame;

/**
 *
 * @author gustavohg
 */
public class Pantalla_juego extends JFrame implements ConstantesCB {
    
    private Image imagenBola;
        
    public Pantalla_juego() throws IOException{
        JFrame pantalla_juego = new JFrame();
        pantalla_juego.setSize(ANCHO_PANTALLA, ALTO_PANTALLA);
        pantalla_juego.setResizable(false);
        pantalla_juego.setTitle("Crazy Breakout Game");
        pantalla_juego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pantalla_juego.setVisible(true);
        
        Nuevo_Jugador Jugador = new Nuevo_Jugador();
        Jugador.start();
        try {
            Thread.sleep(70);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pantalla_juego.class.getName()).log(Level.SEVERE, null, ex);
        }
        pantalla_juego.getContentPane().add(new DrawPanel(Jugador));
    }
    
    
}
