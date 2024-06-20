package edu.escuelaing.arsw.ASE.app;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatagramTimeClientExercise7 {

    public static void main(String[] args) {
        byte[] sendBuf = new byte[256];
        String lastReceivedTime = "No time received yet";
        InetAddress address = null;

        try {
            address = InetAddress.getByName("127.0.0.1");
        } catch (UnknownHostException ex) {
            Logger.getLogger(DatagramTimeClientExercise7.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (true) {
            try (DatagramSocket socket = new DatagramSocket()) {
                byte[] buf = new byte[256];
                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
                socket.send(packet);

                packet = new DatagramPacket(buf, buf.length);
                socket.setSoTimeout(5000); // Set timeout for 5 seconds

                try {
                    socket.receive(packet);
                    lastReceivedTime = new String(packet.getData(), 0, packet.getLength());
                } catch (IOException e) {
                    System.out.println("No response received, maintaining last received time.");
                }

                System.out.println("Date: " + lastReceivedTime);
            } catch (SocketException ex) {
                Logger.getLogger(DatagramTimeClientExercise7.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnknownHostException ex) {
                Logger.getLogger(DatagramTimeClientExercise7.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DatagramTimeClientExercise7.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                Thread.sleep(5000); // Wait for 5 seconds before the next update
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted, failed to complete operation");
            }
        }
    }
}
