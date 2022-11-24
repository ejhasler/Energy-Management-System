package no.ntnu.IDATA2304_Networks.Group10.Database;

import java.io.Serializable;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.LocalTime;

public class kwhReading implements Serializable {

  public String ID;
  public int kWh;
  public LocalDate date;
  public LocalTime time;


  public static void main(String[] args) throws Exception {

    establishConnection();
  }

  private static void establishConnection() {

  }
}
