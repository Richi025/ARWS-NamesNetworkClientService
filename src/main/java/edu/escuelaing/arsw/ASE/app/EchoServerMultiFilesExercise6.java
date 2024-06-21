package edu.escuelaing.arsw.ASE.app;

import java.io.*;
import java.net.*;
import java.nio.file.Files;

/**
 * The EchoServerMultiFilesExercise6 class implements a simple multi-file web server that serves files based on HTTP GET requests.
 */
public class EchoServerMultiFilesExercise6 {

    /**
     * Main method that starts the multi-file web server on port 8080.
     * Continuously accepts client connections and handles requests.
     * @param args Command line arguments (not used in this example).
     * @throws IOException If any I/O error occurs.
     */
    public static void main(String[] args) throws IOException {
    
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Web server started on port 8080");

        while (true) {
            try (Socket clientSocket = serverSocket.accept()) {
                handleClientRequest(clientSocket);
            } catch (IOException e) {
                System.err.println("Error handling client request: " + e.getMessage());
            }
        }
    }

    /**
     * Handles the client request by reading the HTTP request, determining the requested file,
     * sending the appropriate HTTP response with the file content, or a 404 Not Found error.
     * @param clientSocket The socket connected to the client.
     * @throws IOException If any I/O error occurs.
     */
    private static void handleClientRequest(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
        OutputStream dataOut = clientSocket.getOutputStream();

        String inputLine = in.readLine();
        if (inputLine == null || !inputLine.startsWith("GET")) {
            return;
        }

        String[] requestParts = inputLine.split(" ");
        String filePath = requestParts[1].equals("/") ? "/index.html" : requestParts[1];

        File file = new File("src/main/java/edu/escuelaing/arsw/ASE/app/File" + filePath);
        if (file.exists() && !file.isDirectory()) {
            String contentType = getContentType(filePath);
            byte[] fileData = Files.readAllBytes(file.toPath());

        
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: " + contentType);
            out.println("Content-Length: " + fileData.length);
            out.println();
            out.flush();

            dataOut.write(fileData, 0, fileData.length);
            dataOut.flush();
        } else {
            String errorMessage = "HTTP/1.1 404 Not Found\r\n" +
                                  "Content-Type: text/html\r\n" +
                                  "\r\n" +
                                  "<h1>404 Not Found</h1>";
            out.println(errorMessage);
            out.flush();
        }

        in.close();
        out.close();
        dataOut.close();
        clientSocket.close();
    }

    /**
     * Determines the content type based on the file extension.
     * @param filePath The path of the requested file.
     * @return The content type string (e.g., "text/html", "image/jpeg").
     */
    private static String getContentType(String filePath) {
        if (filePath.endsWith(".html") || filePath.endsWith(".htm")) {
            return "text/html";
        } else if (filePath.endsWith(".jpg") || filePath.endsWith(".jpeg")) {
            return "image/jpeg";
        } else if (filePath.endsWith(".png")) {
            return "image/png";
        } else if (filePath.endsWith(".gif")) {
            return "image/gif";
        } else if (filePath.endsWith(".css")) {
            return "text/css";
        } else if (filePath.endsWith(".js")) {
            return "application/javascript";
        } else {
            return "application/indefinite";
        }
    }
}