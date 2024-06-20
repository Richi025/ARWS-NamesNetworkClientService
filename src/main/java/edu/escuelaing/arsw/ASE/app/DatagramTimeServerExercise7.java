package edu.escuelaing.arsw.ASE.app;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatagramTimeServerExercise7 {

    DatagramSocket socket;

    public DatagramTimeServerExercise7() {
        try {
            socket = new DatagramSocket(4445);
        } catch (SocketException ex) {
            Logger.getLogger(DatagramTimeServerExercise7.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void startServer() {
        byte[] buf = new byte[256];
        try {
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);

            String dString = new Date().toString();
            buf = dString.getBytes();
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(buf, buf.length, address, port);
            socket.send(packet);

        } catch (IOException ex) {
            Logger.getLogger(DatagramTimeServerExercise7.class.getName()).log(Level.SEVERE, null, ex);
        }
        socket.close();
    }

    public static void main(String[] args) {
        DatagramTimeServerExercise7 ds = new DatagramTimeServerExercise7();
        ds.startServer();
    }
}
