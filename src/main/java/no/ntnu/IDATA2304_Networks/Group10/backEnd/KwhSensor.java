package no.ntnu.IDATA2304_Networks.Group10.backEnd;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

/**
 * Represents a kwh sensor placed in an electrical outlet
 */
public class KwhSensor {
  private final double kwh_Usage;
  private final LocalDate date;
  private final LocalTime time;

  private static final Random random = new Random();

  /**
   * Creates an instance of theKwhSensor that imitates a kwhSensor in an electrical outlet
   */
  public KwhSensor() {
    this.kwh_Usage = random.nextDouble(0,10);
    this.date = LocalDate.now();
    this.time = LocalTime.now();
  }

  public double readValue() {
    return kwh_Usage;
  }
}
