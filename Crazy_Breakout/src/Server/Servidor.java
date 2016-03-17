package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import Logic.*;

/**
 * Clase Servidor que inicializa un nuevo servidor 
 * @author gustavohg
 */

public class Servidor {
    
    /**
     * Método que abre un socket, acepta una conexión de un nuevo cliente e
     * inicializa un hilo nuevo para manejar esa conexión mediante
     * <code>((ServidorHilo) new ServidorHilo(socket, idSession)).start();</code>
     * donde el método <code>start()</code> llama al método <code>run()</code> de la clase ServidorHilo
     * @param args 
     */
    public static void main(String args[]) {
        ServerSocket ss;
        System.out.print("Inicializando servidor... ");
        try {
            ss = new ServerSocket(8080);
            System.out.println("\t[OK]");
            int idSession = 0;
            Logic Nuevo_juego = new Logic();
            while (true) {
                System.out.println(idSession);
                if (idSession == 0){
                    Socket socket;
                    socket = ss.accept();
                    System.out.println("Nueva conexion entrante: "+socket);
                    ((ServidorHilo) new ServidorHilo(socket, idSession,Nuevo_juego.getBola())).start();
                    Nuevo_juego.nuevoJugador();
                    Nuevo_juego.start();
                    idSession++;
                }
                if (idSession>0){
                    Socket socket;
                    socket = ss.accept();
                    System.out.println("Nueva conexion entrante: "+socket);
                    ((ServidorHilo) new ServidorHilo(socket, idSession,Nuevo_juego.getBola())).start();
                    Nuevo_juego.nuevoJugador();
                    idSession++;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}