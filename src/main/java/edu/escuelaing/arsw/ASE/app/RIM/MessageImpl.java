package edu.escuelaing.arsw.ASE.app.RIM;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * MessageImpl class implements the Message interface and acts as the server-side implementation of the message service.
 * Manages client registration and message broadcasting.
 */
public class MessageImpl extends UnicastRemoteObject implements Message {
    private List<Message> clients = new ArrayList<>();

    /**
     * Constructor for MessageImpl.
     * 
     * @throws RemoteException if a remote communication error occurs
     */
    protected MessageImpl() throws RemoteException {
        super();
    }

    /**
     * Sends a message to all registered clients.
     * 
     * @param message the message to be sent
     * @param sender the client sending the message
     * @throws RemoteException if a remote communication error occurs
     */
    @Override
    public synchronized void sendMessage(String message, Message sender) throws RemoteException {
        for (Message client : clients) {
            if (client.equals(sender)) {
                client.receiveMessage("Message sent: " + message);
            } else {
                client.receiveMessage("Message received: " + message);
            }
        }
    }

    /**
     * Registers a new client with the message server.
     * 
     * @param client the client to be registered
     * @throws RemoteException if a remote communication error occurs
     */
    @Override
    public synchronized void registerClient(Message client) throws RemoteException {
        clients.add(client);
    }

    /**
     * Receives a message from the message server.
     * 
     * @param message the message received
     * @throws RemoteException if a remote communication error occurs
     */
    @Override
    public void receiveMessage(String message) throws RemoteException {
        // Not implemented in the server
    }

}