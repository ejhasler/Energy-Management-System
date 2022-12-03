package no.ntnu.IDATA2304_Networks.Group10.Database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;


public class kwhReading implements Serializable {

  public String ID;
  public int kWh;
  public LocalDate date;
  public LocalTime time;

  private static final String DATABASE_URL = "";
  private static final String USERNAME = "";
  private static final String PASSWORD = "";

  private static String query = "SELECT * FROM Database";

  public static void main(String[] args) throws Exception {

    establishConnection();
  }

  private static void establishConnection() throws SQLException {
    Connection con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
    System.out.println("Connection Established successfully");
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery(query);
    rs.next();
    String name = rs.getString("Name");
    System.out.println(name);
    st.close();
    con.close();
    System.out.println("Connection Closed....");
  }
}
