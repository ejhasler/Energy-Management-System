package no.ntnu.IDATA2304_Networks.Group10.backEnd;

import no.ntnu.IDATA2304_Networks.Group10.backEnd.GeneratingData.ElectricityPrice;

public class ElectricityPriceRunner {
    public static void main(String[] args) {
        ElectricityPrice electricityPrice = new ElectricityPrice();
        try {
            electricityPrice.run();
        } catch (Exception e) {

        }
    }
}

