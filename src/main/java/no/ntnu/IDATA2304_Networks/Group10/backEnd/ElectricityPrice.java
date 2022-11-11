package no.ntnu.IDATA2304_Networks.Group10.backEnd;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ElectricityPrice {
    private double price;

    public ElectricityPrice() {
    }

    public int getDate() {
        Date currentDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss");

        System.out.println(Integer.parseInt(simpleDateFormat.format(currentDate)));
        return Integer.parseInt(simpleDateFormat.format(currentDate));
    }

    public double getPrice() {
        ElectricityPrice electricityPrice = new ElectricityPrice();
        Random random = new Random();
        if ((electricityPrice.getDate() <= 060000) || (electricityPrice.getDate() >= 000000)) {
            price = 20.33 + random.nextDouble(15);
        }
        else if ((electricityPrice.getDate() <= 120000) || (electricityPrice.getDate() >= 060000))  {
            price = 30.15 + random.nextInt(25);
        }
        else if ((electricityPrice.getDate() <= 180000) || (electricityPrice.getDate() >= 120000)) {
            price = 25.79 + random.nextInt(15);
        }
        else if ((electricityPrice.getDate() <= 235959) || (electricityPrice.getDate() >= 180000)) {
             price = 8.88 + random.nextInt(13);
        }
        System.out.println(price);
        return price;
    }

    public static void main(String[] args) {
        ElectricityPrice electricityPrice = new ElectricityPrice();
        electricityPrice.getDate();
        electricityPrice.getPrice();
    }
}