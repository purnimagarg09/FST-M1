package activities;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Activity13a {
    public static void main(String[] args) throws FileNotFoundException, IOException, CsvException {
        //Load CSV file
        CSVReader reader = new CSVReader(new FileReader("src/test/resources/Activity13a.csv"));
        //Load content into list
        List<String[]> list = reader.readAll();
        System.out.println("Total rows in file : "+list.size());

        //Create Iterator reference
        Iterator<String[]> itr = list.iterator();

        //Iterate all values
        while(itr.hasNext()) {
            String[] str = itr.next();

            System.out.print("Values are: ");
            for(int i=0;i<str.length;i++) {
                System.out.print(" " + str[i]);
            }
            System.out.println(" ");
        }

        reader.close();
    }
}
