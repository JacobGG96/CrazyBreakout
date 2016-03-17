/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.io.*;
import java.net.Socket;
import java.util.logging.*;
import java.util.*;

/**
 * Esta clase genera un nuevo jugador que se conecta con el servidor para el intercambio de datos.
 * @author gustavohg
 */
class Nuevo_Jugador extends Thread{
    protected Socket sk;
    protected DataOutputStream dos;
    protected DataInputStream dis;
    private int id;
    
    /**
     * 
     * Constructor de nuevo jugador 
     */
    public Nuevo_Jugador() {
        
    }
    
    /**
     * Hace un override al método <code>run()</code> de la clase Thread e inicializa la conexión
     * con el servidor y recibe los datos inciales.
     */
    @Override
    public void run() {
        try {
            sk = new Socket("127.0.0.1", 8080);
            dos = new DataOutputStream(sk.getOutputStream());
            dis = new DataInputStream(sk.getInputStream());
            dos.writeUTF("Nuevo Jugador");
            leer_inicial();
            leer();
            
        } catch (IOException ex) {
            Logger.getLogger(Nuevo_Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Cierra la conexión del jugador con el servidor.
     */
    public void close() {
        try {
            dis.close();
            dos.close();
            sk.close();
        } catch (IOException ex) {
            Logger.getLogger(Nuevo_Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Lee un Strinig que el servidor envía con los datos iniciales para poder crear un nuevo juego
     * y los separa en un arreglo utilizando un split cada vez que hay un # en el string.
     * @throws IOException 
     */
    public void leer_inicial() throws IOException{
        String e;
        while (true){
            e = dis.readUTF();
            if (e != null){
                String Inicial = e;
                //String[] InicialArray = Inicial.split("#");
                System.out.println(Inicial);
                /*for (int i = 0; i < InicialArray.length; i++) {
                    System.out.println(InicialArray[i]);
                }*/
                break;
            }
        }
        
    }
    
    /**
     * 
     * @throws IOException 
     */
     
    public void leer() throws IOException{
        String e;
        while (true){
            e = dis.readUTF();
            if (e != null){
                System.out.println(e);
            }
        }
        
    }
    
    
}
