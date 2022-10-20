package no.ntnu.IDATA2304_Networks.Group10.Backend;

import no.ntnu.IDATA2304_Networks.Group10.Backend.DataPlaceHolder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A class for holding the data.
 * @author Group 10
 * @version 10/20/2022
 */
public class DataCollector {

    private List<DataPlaceHolder> dataList;

    public DataCollector(){
        dataList = new ArrayList<>();
    }

    public Iterator<DataPlaceHolder> getIterator(){
        return dataList.iterator();
    }
}
