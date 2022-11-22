package ntnu.no.ejhasler.backend.Server;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

import javax.xml.crypto.Data;

/**
 * Receives the data sendt from the Analyzer class where analyzer conatains atm dummy data. And
 * we will print it out in the terminal.
 * 
 * @author Even J.P Haslerud
 * @date 10.11.2022
 */
public class TCPReceiver {
    private final static int TCP_PORT = 8888;

    public static void main(String[] args) throws IOException{
        TCPReceiver receiver = new TCPReceiver();
        receiver.run();
        //log("Server exit");
    }

    private void run() throws IOException{
        
        Socket socket;
        DataInputStream dis;
        String message;
        ServerSocket serverSocket = new ServerSocket(TCP_PORT);

        while (true) {

            socket = serverSocket.accept();
            dis = new DataInputStream(socket.getInputStream());
            message = new String(dis.readAllBytes(), StandardCharsets.UTF_8);
            System.out.println(message);
        }
    }
}

