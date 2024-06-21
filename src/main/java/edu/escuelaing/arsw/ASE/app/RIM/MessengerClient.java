package edu.escuelaing.arsw.ASE.app.RIM;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class MessengerClient {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java MessengerClient <127.0.0.1> <1099>");
            
        }

        String host = "127.0.0.1";
        int port = 1099;

        try {
            Registry registry = LocateRegistry.getRegistry(host, port);
            MessengerService stub = (MessengerService) registry.lookup("MessengerService");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("You: ");
                String message = scanner.nextLine();
                stub.receiveMessage(message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
