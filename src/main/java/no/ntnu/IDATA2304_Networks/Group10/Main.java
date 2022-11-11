package no.ntnu.IDATA2304_Networks.Group10;

import no.ntnu.IDATA2304_Networks.Group10.backEnd.App;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        App app = new App();
        try {
            app.run();
        }catch (Exception e){

        }
    }
}