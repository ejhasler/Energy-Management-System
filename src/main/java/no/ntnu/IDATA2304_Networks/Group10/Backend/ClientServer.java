package no.ntnu.IDATA2304_Networks.Group10.Backend;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Establishes a TCP connection with Server to receive information and sends the
 * information to the database
 *
 * @author Group 10
 * @version 03.12.2022
 */
public class ClientServer {

    //The url for the database
    private static final String DATABASE_URL = "jdbc:mariadb://mysql690.loopia.se/haslerud_tech";
    //Username used to connect to the database
    private static final String USERNAME = "group10@h328964";
    //Password used to connect to the database
    private static final String PASSWORD = "evensivert123";

    private static Statement st;

    //Name of the table that the data will go into
    private static final String tableName = "UserData";

    private static Connection con;

    //The name of the attributes in the table
    private static final String tableAttributes = "kWh,Date,Time,Year";
    private static Socket socket;
    private static ServerSocket serverSocket;

    /**
     * The main method to run the client class.
     * @param args
     * @throws IOException in case of buffered reader not able to read line
     * @throws SQLException if error when connecting to database
     */
    public static void main(String[] args) throws IOException, SQLException {
        serverSocket = new ServerSocket(4999);
        socket = serverSocket.accept();
        InputStreamReader in = new InputStreamReader(socket.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        ClientServer.connectToDatabase();
        Boolean keepGoing = true;
        int timesSentData = 0;

        while(keepGoing) {

            ClientServer.sendToDatabase(bf);
            timesSentData++;
            if (timesSentData ==100){
                keepGoing=false;
            }
        }
        con.close();
        System.out.println("Connection closed.");
    }

    /**
     * Sends information to the connected database.
     *
     * @param bf buffer reader from the client
     * @throws IOException Throws exception in case of buffered reader not able to read line
     */
    private static void sendToDatabase(BufferedReader bf) throws IOException {
        String sqlQuery = "INSERT INTO " + tableName + "(" + tableAttributes +
            ") VALUES(" + bf.readLine() + ",'" + bf.readLine() + "','" + bf.readLine() + "','" +
            bf.readLine()+"');";

        System.out.println(sqlQuery);
        try{
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlQuery);
            rs.next();
            st.close();
            System.out.println("Data sent to dbms");
        }catch (Exception e){
            System.out.println("Something went wrong: "+ e.getMessage());
        }

    }

    /**
     * Connect to the database with url, username and password
     */
    private static void connectToDatabase(){
        try {
            con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            System.out.println("Connection Established successfully");
        }catch (Exception e){
            System.out.println("Something went wrong: " + e.getMessage());
        }

    }
}