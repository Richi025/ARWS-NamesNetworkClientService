package edu.escuelaing.arsw.ASE.app;

import java.io.*;
import java.net.*;

public class Exercise2{


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



