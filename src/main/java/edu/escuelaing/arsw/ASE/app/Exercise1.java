package edu.escuelaing.arsw.ASE.app;

import java.io.*;
import java.net.*;

public class Exercise1 
{
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
