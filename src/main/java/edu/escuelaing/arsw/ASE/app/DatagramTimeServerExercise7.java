package edu.escuelaing.arsw.ASE.app;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The DatagramTimeServerExercise7 class implements a simple UDP server that listens for datagrams from clients and sends the current time upon request.
 */
public class DatagramTimeServerExercise7 {

    DatagramSocket socket;

    /**
     * Constructor for DatagramTimeServerExercise7.
     * Initializes the DatagramSocket on port 4445.
     */
    public DatagramTimeServerExercise7() {
        try {
            socket = new DatagramSocket(4445);
        } catch (SocketException ex) {
            Logger.getLogger(DatagramTimeServerExercise7.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Starts the UDP time server.
     * Listens for incoming datagrams, sends the current time to the client upon request.
     */
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

    /**
     * Main method that creates an instance of DatagramTimeServerExercise7 and starts the server.
     * @param args Command line arguments (not used in this example).
     */
    public static void main(String[] args) {
        DatagramTimeServerExercise7 ds = new DatagramTimeServerExercise7();
        ds.startServer();
    }
}
