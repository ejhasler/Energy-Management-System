package no.ntnu.IDATA2304_Networks.Group10.backEnd;

import java.io.*;

public class FileManagement {

    public FileManagement() {
    }

    public static void importFromCSV() {
        String path = "Add path here";
        String line = "";

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                System.out.println("Time: " + values[0] + " , Price: " + values[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
