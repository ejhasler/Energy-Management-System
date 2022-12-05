package no.ntnu.IDATA2304_Networks.Group10.Backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A class for hosting the java server which sends data to a client. Creates a TCP socket so
 * client can connect to.
 * @author Group 10
 * @version  03.12.2022
 */
public class Client {
    private static GeneratorUsage generatorUsage;
    private static Socket socket;

    /**
     * Main method for initiating the server end.
     *
     * @param args
     * @throws IOException if the system can't sleep
     */
    public static void main(String[] args) throws IOException {
        generatorUsage = new GeneratorUsage();
        socket = new Socket("localhost",4999);
        while(true) {
            System.out.println("Connected");
            Client.sendData();

            try {
                Thread.sleep(3600000); // 60 minutes sleep between
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    /**
     * Send data to the receiver socket for further handling.
     * Crashes if the socket can't send information to the receiver.
     */
    private static void sendData(){
        try {
            String dateAndTime = generatorUsage.getDate()+" " + generatorUsage.getCurrentHour();
            PrintWriter pr = new PrintWriter(socket.getOutputStream());
            pr.println(generatorUsage.getUsage());
            pr.flush();
            pr.println(dateAndTime);
            pr.flush();
            double price = (Double.parseDouble(generatorUsage.getSpotPrice()) * Double.parseDouble(generatorUsage.getUsage()))/100;
            pr.println(price);
            pr.flush();

            pr.println(generatorUsage.getSpotPrice());
            pr.flush();
            pr.println(dateAndTime);
            pr.flush();
        }catch (IOException ioException){
            System.out.println("Something went wrong, could not send data: "+ioException.getMessage());
        }
    }
}
