package no.ntnu.IDATA2304_Networks.Group10.backEnd;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * A class which sends data to a Server. Creates a TCP socket to connect
 * to a server socket to send the data. Also does a simple formatting
 * of the data before it sends.
 *
 * @author Group 10
 * @version  03.12.2022
 */
public class Client {
    //The generator mimicking a sensor
    private static GeneratorUsage generatorUsage;
    private static Socket socket;
    //Sleep duration for data transmit. 1 hour
    private static final int SLEEP_DURATION = 3600000;

    /**
     * Main method for initiating the client end.
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
                Thread.sleep(SLEEP_DURATION); // 60 minutes sleep
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
