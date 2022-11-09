package no.ntnu.IDATA2304_Networks.Group10.backEnd;

public class App {

    private static final long SLEEP_DURATION_MS = 4000;
    double lastKwReading;

    /**
     * Run the application
     * @throws InterruptedException
     */
    public void run() throws InterruptedException{
        initializeSensors();
        while(true) {
            receiveDataFromSensor();
            sendDataToServer();
            sensorPauseBetweenReading();
        }
    }

    /**
     * Initializes all the sensors
     *
     * @throws IllegalStateException if some sensors are not found
     */
    private void initializeSensors() {
        SensorProvider sensorProvider = SensorProvider.getInstance();
//        Sensor kwSensor = sensorProvider.getKwSensor();
//        if (kwSensor == null) {
//            throw new IllegalStateException("Temperature sensor not found");
//        }
    }

    private void receiveDataFromSensor() {
        System.out.println("Recieving data from sensor....");
        lastKwReading = readKwSensor();
    }

    private double readKwSensor() {
//        return lastKwReading.readValue();
        return 20;
    }


    private void sendDataToServer(){
        System.out.println("Sending data to server:");
        System.out.println("    kw: " + lastKwReading + "Kw");
        System.out.println("");
    }

    private void sensorPauseBetweenReading() {
        try {
            Thread.sleep(SLEEP_DURATION_MS);
        } catch (InterruptedException e) {
            System.out.println("ERROR: Pause was interrupted");
        }
    }
}
