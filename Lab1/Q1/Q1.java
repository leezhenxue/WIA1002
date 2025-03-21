package Q1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Q1 {
    public static void main(String[] args) {
        try{
            BufferedReader reader = new BufferedReader(new FileReader("Lab1/Q1/LeeZhenXue_24004491.txt"));
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException e){
            e.getMessage();
        } catch (IOException e){
            e.getMessage();
        }
        
    }
}
