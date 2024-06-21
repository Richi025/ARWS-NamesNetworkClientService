package edu.escuelaing.arsw.ASE.app.RIM;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class MessengerServiceImpl implements MessengerService {

    public String sendMessage(String clientMessage) {
        String serverMessage = null;
        if (clientMessage.equals("Client Message")) {
            serverMessage = "Server Message";
        }
        return serverMessage;
    }

    public void createStubAndBind(String host, int port) throws RemoteException {
        MessengerService stub = (MessengerService) UnicastRemoteObject.exportObject(this, port);
        Registry registry = LocateRegistry.createRegistry(port);
        registry.rebind("MessengerService", stub);
    }

    public Message sendMessage(Message clientMessage) throws RemoteException {
        Message serverMessage = null;
        if (clientMessage.getMessageText().equals("Client Message")) {
            serverMessage = new Message("Server Message", "text/plain");
        }
        return serverMessage;
    }

    public void receiveMessage(String message) {
        System.out.println("Received: " + message);
    }
	

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java MessengerServiceImpl <127.0.0.1> <1099>");
        }

        String host = "127.0.0.1";
        int port = 1099;

        try {
            MessengerServiceImpl server = new MessengerServiceImpl();
            server.createStubAndBind(host, port);
            System.out.println("MessengerService is ready.");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("You: ");
                String message = scanner.nextLine();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
