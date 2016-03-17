package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import Logic.*;


/**
 * Clase que maneja cada hilo inicializado en la clase Servidor, extiende de
 * clase Thread
 * @author gustavohg
 */

public class ServidorHilo extends Thread implements ConstantesCB{
    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;
    private int idSessio;
    private Bola bola;
    private int state;
    private String[] lista;
    
    /**
     * Método que asigna un socket y un id que dio la clase Servidor a los mismos
     * atributos pero de la clase ServidorHilo, además abre un puerto para envío
     * de mensajes y otro para recibimiento de mensajes en el socket
     * @param socket Asigna un socket a que acepta conexiones a la variable <code>socket</code>
     * de esta clase
     * @param id Asigna un identificador al socket que va a ser el id del cliente que solicita
     * la conexión
     * @param nueva_bola
     */ 
    public ServidorHilo(Socket socket, int id, Bola nueva_bola) {
        this.bola = nueva_bola;
        this.socket = socket;
        this.idSessio = id;
        this.state = 0;
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            
        } 
        catch (IOException ex) {
            Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Se le hace un Override al método <code>run()</code> de la clase Thread, llama a otros
     * métodos dependiendo de el mensaje que reciba del cliente.
     */ 
    @Override
    public void run() {
        String msg;
        System.out.println("Cliente #"+this.idSessio+" >>> Se ha conectado");
        while (true){
        	try{
	            msg = dis.readUTF();
                    if(msg.equals("Nuevo Jugador")){                      
                        System.out.println("Cliente #"+this.idSessio+" >>> "+msg);
                        if (this.idSessio==0){
                            dos.writeUTF(this.idSessio +"#"+ POS_INICIAL_BOLAX+"#"+POS_INICIAL_BOLAY+"#"+
                                     POS_INICIAL_BARRAX+"#"+POS_INICIAL_BARRAY+"#"+CANTIDAD_BLOQUES);
                        }
                        while(true){
                            if (state == 0){
                                actual();
                                Thread.sleep(50);
                            }
                            else{
                                break;
                            }
                        }
                    }
                    if(msg.equals("Desconectar")){
                        System.out.println("Cliente #"+this.idSessio+" >>> "+msg);
                        desconectar();
                        break;
                    }
                    if(msg!=null){
		        //System.out.println("Cliente #"+this.idSessio+" >>> "+msg);
                        dos.writeUTF("Mensaje recibido: "+msg);
		    }
		}
        	catch(Exception e){
 	       	}
        }
    }
    
    /**
     * Cuando el Servidor recibe una solicitud de cerrar la conexión de parte del
     * cliente este método cierra el socket y ya no pueda haber intercambio de 
     * datos.
     */
    public void desconectar() {
        try { 
            this.state=1;
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
        dos.writeUTF(this.bola.getX()+"#"+this.bola.getY());
    }
    
    
}
