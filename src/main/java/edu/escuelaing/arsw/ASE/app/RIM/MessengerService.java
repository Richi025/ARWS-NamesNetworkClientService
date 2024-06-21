package edu.escuelaing.arsw.ASE.app.RIM;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MessengerService extends Remote {
    public String sendMessage(String clientMessage) throws RemoteException;
    public Message sendMessage(Message clientMessage) throws RemoteException;
    public void receiveMessage(String message) throws RemoteException;
}
