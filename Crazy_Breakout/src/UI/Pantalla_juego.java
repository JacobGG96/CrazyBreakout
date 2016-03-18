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
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
        
        DrawPanel dpnBola = new DrawPanel();
        dpnBola.setSize(25, 50);
        pantalla_juego.getContentPane().add(dpnBola).setLocation(50, 70);
        pantalla_juego.repaint();
        
    }
    
    
}
