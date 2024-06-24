package edu.escuelaing.arsw.ASE.app.RIM;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * MessengerServer class to start the RMI message server.
 * Publishes the message service to the RMI registry.
 */
public class MessengerServer {
    /**
     * Main method to start the MessengerServer.
     * Binds the message service to the RMI registry.
     * 
     * @param args the command line arguments (server port)
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java MessengerServer <port>");
            return;
        }

        int port = Integer.parseInt(args[0]);

        try {
            MessageImpl message = new MessageImpl();
            Registry registry = LocateRegistry.createRegistry(port);
            registry.rebind("MessagerService", message);
            System.out.println("Message server is running on port " + port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
