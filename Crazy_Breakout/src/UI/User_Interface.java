/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 * En esta clase invoca un Runnable que genera una nuva pantalla principal.
 * @author gustavohg
 */
public class User_Interface {
    /**
     * Se hace un override al método <code>run()</code> de la clase Runnable donde se
     * crea un nuevo objeto Pantalla_princ.
     * @param args 
     */
    public static void main (String args[]){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Pantalla_princ nueva_pantalla = new Pantalla_princ();
            }
        });
    }


}
