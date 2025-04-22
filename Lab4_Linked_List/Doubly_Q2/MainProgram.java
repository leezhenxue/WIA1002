package Doubly_Q2;

import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<String> students = new LinkedList<>();
        System.out.println("Enter your student name list. Enter 'n' to end......");
        String name = input.nextLine();
        while (!name.equals("n")) {
            students.add(name);
            name = input.nextLine();
        }
        System.out.println("\nYou have entered the following students' name : ");
        students.printList();

        System.out.println("\nThe number of students entered is : " + students.getSize());

        char replaceInput;
        do {
            System.out.println("\nAll the names entered are correct? Enter 'r' to rename the student name, 'n' to procees.");
            replaceInput = input.next().charAt(0);
        } while (replaceInput != 'r' && replaceInput != 'n');

        if (replaceInput == 'r') {
            System.out.println("\nEnter the existing student name that u want to rename : ");
            String replaceName = input.next();
            System.out.println("\nEnter the new name : ");
            String newName = input.next();
            students.replace(replaceName, newName);
        }

        System.out.println("\nThe new student list is : ");
        students.printList();

        char removeInput;
        do {
            System.out.println("\nDo you want to remove any of your student name? Enter 'y' for yes, 'n' to procees.");
            removeInput = input.next().charAt(0);
        } while (removeInput != 'y' && removeInput != 'n');

        if (removeInput == 'y') {
            System.out.println("\nEnter a student name to remove : ");
            students.removeElement(input.next());
        }

        System.out.println("\nThe number of updated student is :" + students.getSize());
        System.out.println("The updated students list is : ");
        students.printList();
        System.out.println("\nAll student data captured complete. Thank you!");
    }
}
