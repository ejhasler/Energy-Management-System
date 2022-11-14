package no.ntnu.IDATA2304_Networks.Group10.backEnd;

import no.ntnu.IDATA2304_Networks.Group10.backEnd.Sensors.KwhSensor;

/**
 * Manages a collection of all available sensors
 */
public class SensorProvider {
  private final KwhSensor kwhSensor = new KwhSensor();

  private SensorProvider() {
  }

  private static final SensorProvider instance = new SensorProvider();

  /**
   * Get a singleton instance of the class
   * @return a singleton instance of the class
   */
  public static SensorProvider getInstance() {
    return instance;
  }

  /**
   * Get access to the Kwh sensor
   * @access to the Kwh sensor
   */
  public KwhSensor getKwhSensor() {
    return kwhSensor;
  }
}
