package edu.escuelaing.arsw.ASE.app.RIM;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 * MessengerClient class implements the message interface and acts as a message client in the RMI-based message application.
 * This class connects to the message server, sends messages, and receives messages.
 */
public class MessengerClient extends UnicastRemoteObject implements Message {
    /**
     * Constructor for MessengerClient.
     * 
     * @throws RemoteException if a remote communication error occurs
     */
    protected MessengerClient() throws RemoteException {
        super();
    }

    /**
     * Method to send a message. Not implemented for the client.
     * 
     * @param message the message to be sent
     * @param sender the client sending the message
     * @throws RemoteException if a remote communication error occurs
     */
    @Override
    public void sendMessage(String message, Message sender) throws RemoteException {
        // Not implemented in the client
    }

    /**
     * Receives a message from the message server.
     * 
     * @param message the message received
     * @throws RemoteException if a remote communication error occurs
     */
    @Override
    public void receiveMessage(String message) throws RemoteException {
        System.out.println(message);
    }

    /**
     * Method to register a client. Not implemented for the client.
     * 
     * @param client the client to be registered
     * @throws RemoteException if a remote communication error occurs
     */
    @Override
    public void registerClient(Message client) throws RemoteException {
        // Not implemented in the client
    }

    /**
     * Main method to start the MessengerClient.
     * Connects to the message server and starts sending/receiving messages.
     * 
     * @param args the command line arguments (server IP and server port)
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java MessengerClient <server_ip> <server_port>");
            return;
        }

        String serverIp = args[0];
        int serverPort = Integer.parseInt(args[1]);

        try {
            Registry registry = LocateRegistry.getRegistry(serverIp, serverPort);
            Message messager = (Message) registry.lookup("MessagerService");

            MessengerClient client = new MessengerClient();
            messager.registerClient(client);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your messages: ");
            while (true) {
                String message = scanner.nextLine();
                messager.sendMessage(message, client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}