package edu.escuelaing.arsw.ASE.app;

import java.net.*;
import java.io.*;
import java.lang.Math;

public class EchoServerFuncionsExercise4 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        String currentFunction = "cos";

        while ((inputLine = in.readLine()) != null) {
            if (inputLine.startsWith("fun:")) {
                currentFunction = inputLine.substring(4).trim();
                out.println("Operation changed to: " + currentFunction);
            } else {
                try {
                    double number = Double.parseDouble(inputLine);
                    double result = calculateFunction(currentFunction, number);
                    out.println("Result: " + result);
                } catch (NumberFormatException e) {
                    out.println("Invalid number format");
                }
            }
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }

    public static double calculateFunction(String function, double number) {
        switch (function) {
            case "sin":
                return Math.sin(number);
            case "cos":
                return Math.cos(number);
            case "tan":
                return Math.tan(number);
            default:
                return Math.cos(number); 
        }
    }
}
