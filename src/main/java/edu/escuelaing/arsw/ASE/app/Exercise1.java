package edu.escuelaing.arsw.ASE.app;

import java.io.*;
import java.net.*;


/**
 * program in which you create a URL object and print on screen each of the data returned by the 8 methods: getProtocol, getAuthority, getHost, getPort, getPath, getQuery, getFile, getRef.
 */
public class Exercise1 
{

    /**
     * The main method that demonstrates the use of the URL class in Java.
     * It retrieves and prints various components of a URL.
     * @param args Command line arguments (not used in this example).
     * @throws Exception If any error occurs during URL processing.
     */
    public static void main(String[] args) throws Exception {
        
        URL url = new URL("http://www.google.com/");
        try{
            String Protocol = url.getProtocol();
            System.out.println(Protocol);
            String Authority= url.getAuthority();
            System.out.println(Authority);
            String Host = url.getHost();
            System.out.println(Host);
            int Port = url.getPort();
            System.out.println(Port);
            String Path = url.getPath();
            System.out.println(Path);
            String Query = url.getQuery();
            System.out.println(Query);
            String File = url.getFile();
            System.out.println(File);
            String Ref = url.getRef();
            System.out.println(Ref);
        }catch(Exception x) {
                System.err.println(x);
        }


     }
        
}
