package Q2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q2_text4 {
    public static void main(String[] args) {
        int num = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Lab1/Q2/text4.txt"));
            String line;
            while ((line = reader.readLine()) != null){
                String[] array = line.split("[0-9]+");
                for (String element : array){
                    System.out.print(element + " ");
                }
                System.out.println();
                num += array.length;
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
