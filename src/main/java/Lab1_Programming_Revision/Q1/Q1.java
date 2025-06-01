package Lab1_Programming_Revision.Q1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String lines;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Lab1/Q1/LeeZhenXue_24004491.txt", true));
            while(true){
                lines = input.nextLine();
                if (lines.isEmpty()){
                    break;
                }
                writer.write(lines);
                writer.newLine();
            }
            writer.newLine();
            writer.close();
        } catch (FileNotFoundException e){
            e.getMessage();
        } catch (IOException e){
            e.getMessage();
        }
        
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
