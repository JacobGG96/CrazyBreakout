/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.*;
import java.net.*;
import java.util.logging.*;

public class ServidorHilo extends Thread {
    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;
    private int idSessio;
    
    //constructor  que inicializar el socket y asigna  el id al numero de sesion 
    public ServidorHilo(Socket socket, int id) {
        this.socket = socket;
        this.idSessio = id;
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
        } 
        catch (IOException ex) {
            Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * el metodo  run  mediante  el override sobresccribe la acci�n
     * y  hace la asignacion al  archivo y   se lo envia al cliente que hizo esa  solicitud  
     
     */
    @Override
    public void run() {
        String msg;
        while (true){
        	try{
	            msg = dis.readUTF();
//		    if(msg!=null){
//		        System.out.println("Cliente #"+this.idSessio+" >>> "+msg);
//		        dos.writeUTF("Mensaje recibido");
//		    }
                    if(msg.equals("Actualizacion")){
                        System.out.println("Cliente #"+this.idSessio+" >>> "+msg);
                        actual();
                    }
                    if(msg.equals("Desconectar")){
                        desconectar();
                    }
		}
        	catch(Exception e){
 	       	}
        }
    }
    
    /**
     * metodo que se   encarga de  cerrar todas las  conexiones  que se  realizaron en el socket  
     * 
     * 
     */
    private void desconectar() {
        try {
            socket.close();
            System.out.println("Cliente #"+this.idSessio+" >>> Se ha desconectado");
        } catch (IOException ex) {
            Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void actual() throws IOException{
        dos.writeUTF("Enviando actualización");
    }
}
