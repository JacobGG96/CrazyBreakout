package Server;

import java.io.*;
import java.net.*;
import java.util.logging.*;

/**
 * Clase que maneja cada hilo inicializado en la clase Servidor, extiende de
 * clase Thread
 * @author gustavohg
 */

public class ServidorHilo extends Thread {
    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;
    private int idSessio;
    
    /**
     * Método que asigna un socket y un id que dio la clase Servidor a los mismos
     * atributos pero de la clase ServidorHilo, además abre un puerto para envío
     * de mensajes y otro para recibimiento de mensajes en el socket
     * @param socket Asigna un socket a que acepta conexiones a la variable <code>socket</code>
     * de esta clase
     * @param id Asigna un identificador al socket que va a ser el id del cliente que solicita
     * la conexión
     */ 
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
     * Se le hace un Override al método <code>run()</code> de la case Thread, llama a otros
     * métodos dependiendo de el mensaje que reciba del cliente.
     */
    @Override
    public void run() {
        String msg;
        while (true){
        	try{
	            msg = dis.readUTF();
                    if(msg.equals("Actualizacion")){                      
                        System.out.println("Cliente #"+this.idSessio+" >>> "+msg);
                        actual();
                    }
                    if(msg.equals("Desconectar")){
                        System.out.println("Cliente #"+this.idSessio+" >>> "+msg);
                        desconectar();
                        break;
                    }
                    if(msg!=null){
		        System.out.println("Cliente #"+this.idSessio+" >>> "+msg);
                        dos.writeUTF("Mensaje recibido: "+msg);
		    }
		}
        	catch(Exception e){
 	       	}
        }
    }
    
    /**
     * Cuando el Servidor recibe una solicitud de cerrar la conexión de parte del
     * cliente este método cierra el socket y ya no pueden haber intercambio de 
     * datos.
     */
    private void desconectar() {
        try {            
            dos.writeUTF("Desconectado");
            socket.close();
            System.out.println("Cliente #"+this.idSessio+" >>> Se ha desconectado");
        } catch (IOException ex) {
            Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Este método envía al cliente una actualización del juego cuando él la solicita.
     * @throws IOException 
     */
    private void actual() throws IOException{
        dos.writeUTF("Enviando actualización");
    }
    
    
}
