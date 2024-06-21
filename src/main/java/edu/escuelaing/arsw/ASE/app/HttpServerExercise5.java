package edu.escuelaing.arsw.ASE.app;

import java.net.*;
import java.io.*;

/**
 * It is a simple HTTP server program that accepts connections from clients, reads the HTTP request, and sends a basic HTML response.
 */
public class HttpServerExercise5 {
    
    /**
     * The main method that starts the HTTP server, accepts client connections,
     * reads the HTTP request, and sends a basic HTML response.
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
            System.out.println("Listo para recibir ...");
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;

        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
            if (!in.ready()) {
                break;
            }
        }

        outputLine = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Title of the document</title>\n" + "</head>"
                + "<body>"
                + "My Web Site"
                + "<br></br>"
                + "<img src=https://static.abc.es/media/peliculas/000/034/797/the-amazing-spider-man-2-2.jpg>"
                + "</body>"
                + "</html>"; 

        out.println(outputLine);

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }

}
