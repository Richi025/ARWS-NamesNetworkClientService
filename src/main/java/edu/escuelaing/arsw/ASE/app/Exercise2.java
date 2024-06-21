package edu.escuelaing.arsw.ASE.app;

import java.io.*;
import java.net.*;

/**
 * A browser application that asks the user for a URL address, reads data from that address, and stores them in a file named resultado.html.
 */
public class Exercise2{

    /**
     * The main method that demonstrates the use of the URL class in Java.
     * @param args Command line arguments (not used in this exercise).
     * @throws Exception If any error occurs during URL processing.
     */
    public static void main(String[] args) throws Exception {
        
        URL google = new URL("http://www.google.com/");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(google.openStream()))) {
            String inputLine = null;
            String rutaArchivo = "src/main/java/edu/escuelaing/arsw/ASE/app/resultado.html";
            BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo));
            while ((inputLine = reader.readLine()) != null) {
                writer.write(inputLine);
                writer.newLine();
                System.out.println(inputLine);
            }
            reader.close();
            writer.close();
        } catch (IOException x) {
            System.err.println(x);
        }
        

    }
 }



