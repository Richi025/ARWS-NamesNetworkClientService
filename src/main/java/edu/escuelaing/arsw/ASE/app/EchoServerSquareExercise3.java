package edu.escuelaing.arsw.ASE.app;

import java.net.*;
import java.io.*;


/**
 * A server that receives a number and responds with the square of this number.
 */
public class EchoServerSquareExercise3 {

    /**
     * The main method that starts the server, accepts client connections,
     * reads numbers from the client, calculates their squares, and sends
     * the results back to the client.
     * @param args Command line arguments (not used in this example).
     * @throws IOException If any I/O error occurs.
     */
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
        String inputLine, outputLine;

        while ((inputLine = in.readLine()) != null) {
            int convertedNumber = Integer.parseInt(inputLine); 
            int square = convertedNumber * convertedNumber;
            System.out.println("Mensaje: " + square);
            outputLine = "Respuesta: " + square;
            out.println(square);
            if (outputLine.equals("Respuesta: Bye."))
                break;
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}

