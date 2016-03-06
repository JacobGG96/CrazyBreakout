/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;
import Logic.ConstantesCB;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author gustavohg
 */
public class Pantalla extends JFrame implements ConstantesCB {
    
    public Pantalla(){
        
        initUI();
    }
    
    public void initUI(){
        
        JButton new_game_b = new JButton("Nuevo Juego");
        
        
        setTitle("Crazy Breakout");
        setSize(LARGO_PANTALLA,ANCHO_PANTALLA);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }
    
}
