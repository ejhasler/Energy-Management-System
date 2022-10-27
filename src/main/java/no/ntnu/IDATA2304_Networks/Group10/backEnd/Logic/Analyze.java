package no.ntnu.IDATA2304_Networks.Group10.backEnd.Logic;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import no.ntnu.IDATA2304_Networks.Group10.backEnd.Server.ReceiverRasp;

/**
 * Representing a class that analyzes the data sent/handled by the Raspberry PI, and
 * then sorting the incoming data.
 *
 * @author Group 10
 * @version 10/20/2022
 */
public class Analyze {

    private int highValue;      // Represent high value in energy usage
    private int mediumValue;    // Represent medium value in energy usage
    private int smallValue;     // Represent small value in energy usage
    private int usage;          // Represent the usage of the energy meter specific for that room
    private int totalUsage;     // Represent the total usage of a day/week/month/year
    private LocalDate date;     // Represent the date of when the energy usage took place
    private LocalTime time;     // Represent the time of day when the energy usage took place


    private List<ReceiverRasp> dataList;

    public Analyze(){
        dataList = new ArrayList<>();
    }

    public Iterator<ReceiverRasp> getIterator(){
        return dataList.iterator();
    }

}
