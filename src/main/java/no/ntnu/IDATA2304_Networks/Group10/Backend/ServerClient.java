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
public class ServerClient {

    //The url for the database
    private static final String DATABASE_URL = "jdbc:mariadb://mysql690.loopia.se/haslerud_tech";
    //Username used to connect to the database
    private static final String USERNAME = "group10@h328964";
    //Password used to connect to the database
    private static final String PASSWORD = "evensivert123";

    private static Statement st;

    //Name of the table that the data will go into
    private static final String TABLE_NAME_1 = "UserData";
    private static final String TABLE_NAME_2 = "SpotPrice";

    private static Connection con;

    //The name of the attributes in the table
    private static final String TABLE_ATTRIBUTES_1 = "kWh,Time,Price";
    private static  final String TABLE_ATTRIBUTE_2 = "kWh,Time";
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
        Boolean keepGoing = true;
        int timesSentData = 0;

        while(keepGoing) {

            ServerClient.sendToDatabase(bf);
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
        String sqlQuery1 = "INSERT INTO " + TABLE_NAME_1 + "(" + TABLE_ATTRIBUTES_1 +
            ") VALUES(" + bf.readLine() + ",'" + bf.readLine() + "'," + bf.readLine() + ");";

        String sqlQuery2 = "INSERT INTO " + TABLE_NAME_2 + "(" + TABLE_ATTRIBUTE_2 + ") VALUES(" + bf.readLine() +
                ",'" + bf.readLine() + "');";
        System.out.println(sqlQuery1);
        System.out.println(sqlQuery2);
        ServerClient.connectToDatabase();
        try{
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlQuery1);
            rs.next();
            rs = st.executeQuery(sqlQuery2);
            rs.next();
            st.close();
            System.out.println("Data sent to dbms");
            ServerClient.terminateConnectionToDB();
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
            System.out.println("Connection to database established successfully");
        }catch (Exception e){
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    private static void terminateConnectionToDB(){
        try {
            con.close();
            System.out.println("Connection to the database closed....");
        } catch(SQLException sqlE){
            System.out.println("Could not terminate the connection: " + sqlE.getMessage());
        }
    }
}