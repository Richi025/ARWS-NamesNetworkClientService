package edu.escuelaing.arsw.ASE.app.RIM;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * message interface for RMI-based message application.
 * Defines methods for sending and receiving messages and registering clients.
 */
public interface Message extends Remote {

    /**
     * Sends a message to the messenger server.
     * 
     * @param message the message to be sent
     * @param sender the client sending the message
     * @throws RemoteException if a remote communication error occurs
     */
    void sendMessage(String message, Message sender) throws RemoteException;

     /**
     * Registers a new client with the messenger server.
     * 
     * @param client the client to be registered
     * @throws RemoteException if a remote communication error occurs
     */
    void registerClient(Message client) throws RemoteException;

    /**
     * Receives a message from the messenger server.
     * 
     * @param message the message received
     * @throws RemoteException if a remote communication error occurs
     */
    void receiveMessage(String message) throws RemoteException;
}