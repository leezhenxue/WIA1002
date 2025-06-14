package Lab1_Programming_Revision.Q2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q2 {
    public static void main(String[] args) {
        String[] filenames = {"Lab1/Q2/text1.txt", "Lab1/Q2/text2.txt", "Lab1/Q2/text3.txt", "Lab1/Q2/text4.txt"};
        for (String filename : filenames){
            read(filename);
        }
    }

    public static void read(String filename){
        int num = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null){
                line = line.replaceAll("[,;]\\s?", ",").replaceAll("(?<=[a-zA-Z])[0-9]+", ",");
                String[] array = line.split(",");
                for (String element : array){
                    System.out.print(element);
                    num += element.length();
                }
                System.out.println();
            }
            System.out.println("Number of characters: " + num);
            System.out.println();
            reader.close();
        } catch (FileNotFoundException e){
            e.getMessage();
        } catch (IOException e){
            e.getMessage();
        }
    }
}
