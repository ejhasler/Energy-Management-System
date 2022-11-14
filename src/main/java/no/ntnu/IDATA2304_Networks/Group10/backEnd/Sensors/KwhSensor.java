package no.ntnu.IDATA2304_Networks.Group10.backEnd.Sensors;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

/**
 * Represents a kwh sensor placed in an electrical outlet
 */
public class KwhSensor {
  private double kwh_Usage;
  private LocalDate date;
  private LocalTime time;
  private String currentValue = ("Kwh usage: " + kwh_Usage + " Date: " + date + " time: " + time);

  private static final Random random = new Random();

  /**
   * Creates an instance of theKwhSensor that imitates a kwhSensor in an electrical outlet
   */
  public KwhSensor() {
    updateValue();
  }

  public String readValue() {
    updateValue();
    return currentValue;
  }

  private void updateValue() {
    this.date = LocalDate.now();
    this.time = LocalTime.now();
    if (time.isBefore(LocalTime.of(10,0))) {
      this.kwh_Usage = random.nextDouble(0, 0.5000);
    } else if (time.isAfter(LocalTime.of(10,0)) && (time.isBefore(LocalTime.of(16,0)))) {
      this.kwh_Usage = random.nextDouble(0,0.1500);
    } else if (time.isAfter(LocalTime.of(16,0))) {
      this.kwh_Usage = random.nextDouble(1.0000,2.0000);
    }
  }
}
