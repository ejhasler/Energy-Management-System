package no.ntnu.IDATA2304_Networks.Group10.Backend;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * Returns current date, current time and  current electricity price.
 * Used to generate data which can be used to send to the client.
 *
 * @author Group10
 * @version 02.12.2022
 */
public class Generator {
    private double usage;
    private DecimalFormat decimalFormat = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US));
    public Generator() {
        //Left empty on purpose
    }

    /**
     * Returns the current day, month and year.
     * @return current day, month and year
     */
    public String getDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return sdf.format(date);
    }

    /**
     * Returns the current year
     * @return the current year
     */
    public String getYear(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(date);
    }

    /**
     * Returns correct format for current time.
     * @return correct format for current time
     */
    public String getCurrentHour() {
        Date currentHour = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        return sdf.format(currentHour);
    }

    /**
     * Returns current time.
     * Used in getPrice to get the best price for the time.
     * @return Current time
     */
    public int getCurrentTime() {
        Date currentDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss");

        return Integer.parseInt(simpleDateFormat.format(currentDate));
    }

    /**
     * Returns the current price of electricity.
     * To try and make the generated data as real as possible,
     * it checks the current time and returns the price
     * based on real data.
     *
     * @return The current price of electricity
     */
    public String getUsage() {
        Generator electricityPrice = new Generator();
        Random random = new Random();
        if ((electricityPrice.getCurrentTime() >= 100000) & (electricityPrice.getCurrentTime() <= 140000)) {
            this.usage = 0.78 + random.nextDouble(0.24);
        }
        else if ((electricityPrice.getCurrentTime() >= 140001) & (electricityPrice.getCurrentTime() <= 180000))  {
            this.usage = 1.56 + random.nextDouble(0.6);
        }
        else if ((electricityPrice.getCurrentTime() >= 180001) & (electricityPrice.getCurrentTime() <= 235959)) {
            this.usage = 2.04 + random.nextDouble(0.54);
        }
        else {
            this.usage = 0.78 + random.nextDouble(0.48);
        }
        return decimalFormat.format(this.usage);
    }
}