package no.ntnu.IDATA2304_Networks.Group10.backEnd;

/**
 * Manages a collection of all available sensors
 */
public class SensorProvider {

  private SensorProvider() {

  }

  private static SensorProvider instance = new SensorProvider();

  /**
   * Get a singleton instance of the class
   * @return a singleton instance of the class
   */
  public static SensorProvider getInstance() {
    return instance;
  }

  /**
   * Get access to the Kw sensor
   * @access to the Kw sensor
   */
  public Object getKwSensor() {
    return null;
  }
}
