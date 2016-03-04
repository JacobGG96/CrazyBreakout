package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            while (true) {
                Socket socket;
                socket = ss.accept();
                System.out.println("Nueva conexi�n entrante: "+socket);
                ((ServidorHilo) new ServidorHilo(socket, idSession)).start();
                idSession++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}