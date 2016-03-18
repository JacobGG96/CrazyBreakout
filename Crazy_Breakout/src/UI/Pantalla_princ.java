/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Logic.ConstantesCB;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Esta clase se utiliza para generar la pantalla principal del juego.
 * @author gustavohg
 */
public class Pantalla_princ implements ConstantesCB {

    /**
     * Acá se instancian un conjunto de objetos para generar la pantalla principal del juego
     * y darle una funcionalidad a dos botones que se utilizarán para generar un nuevo juego
     * o para salir de la pantalla principal.
     */
    public Pantalla_princ() {

        JFrame pantalla_princ = new JFrame();
        pantalla_princ.setSize(ANCHO_PANTALLA, ALTO_PANTALLA);
        pantalla_princ.setResizable(false);
        pantalla_princ.setTitle("Crazy Breakout");
        pantalla_princ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pantalla_princ.setVisible(true);
        
        JButton Iniciar_juego = new JButton("Iniciar Juego");
        Iniciar_juego.setToolTipText("Haga click si desea iniciar un nuevo juego");
        JButton Salir = new JButton("Salir");
        
        Iniciar_juego.setSize(50, 30);
        Salir.setSize(50, 30);
        
        JPanel panel_botonIniciar = new JPanel();
        JPanel panel_botonSalir = new JPanel();
        panel_botonIniciar.add(Iniciar_juego);
        panel_botonSalir.add(Salir);
        
        pantalla_princ.getContentPane().add(panel_botonIniciar, BorderLayout.WEST);
        pantalla_princ.getContentPane().add(panel_botonSalir, BorderLayout.EAST);
        
        Salir.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        System.exit(0);
                    }
                });
        
        Iniciar_juego.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                  
                pantalla_princ.getContentPane().remove(panel_botonIniciar);
                pantalla_princ.getContentPane().repaint();
                pantalla_princ.setVisible(false);
                
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Pantalla_juego pantallaJuego = new Pantalla_juego();
                } catch (IOException ex) {
                    Logger.getLogger(Pantalla_princ.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
                               
                /*Salir.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        try {
                            Jugador.dos.writeUTF("Desconectar");
                            System.exit(0);
                        } catch (IOException ex) {
                            Logger.getLogger(Pantalla_princ.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });*/
            }
        });
    }
}
    
