package Activities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Activity14 {
    public static void main (String[] args){
        try {
            File file = new File("C:\\Users\\04009D744\\Desktop\\test.txt");
            boolean filecreate = file.createNewFile();
            if(filecreate)
                System.out.println("New file created : " + file.getName());
            else
                System.out.println("File already exists");

            //Writing text to file
            FileWriter myWriter = new FileWriter("C:\\Users\\04009D744\\Desktop\\test.txt");
            myWriter.write("Sample text added to file!");
            myWriter.close();

            //get the file Object and read data
            File fileobj = FileUtils.getFile("C:\\Users\\04009D744\\Desktop\\test.txt");
            System.out.println("Data in file: " + FileUtils.readFileToString(fileobj, "UTF8"));

            //Create directory
            File directory   = new File("C:\\Users\\04009D744\\Desktop\\resources");
            //Copy file to directory
            FileUtils.copyFileToDirectory(file, directory);

            File fileobj2 = FileUtils.getFile(directory,"test.txt");
            System.out.println("Data in file in directory: " + FileUtils.readFileToString(fileobj2, "UTF8"));
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
