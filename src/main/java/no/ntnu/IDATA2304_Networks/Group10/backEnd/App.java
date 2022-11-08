package no.ntnu.IDATA2304_Networks.Group10.backEnd;

public class App {
    private static final long SLEEP_DURATION_MS = 4000;

    public void run() throws InterruptedException{

        while(true) {
            receiveDataFromSensor();
            sendDataForward();
            sensorPauseBetweenReading();
        }
    }

    private void receiveDataFromSensor() {
        System.out.println("Recieving data from sensor....");
    }

    private void sendDataForward(){
        System.out.println("Forwarding the packets...");
    }

    private void sensorPauseBetweenReading() throws InterruptedException {
        System.out.println("Waiting for pause to end!");
        Thread.sleep(SLEEP_DURATION_MS);
    }
}
