package Lab5_Stacks.Q5;

import java.util.Scanner;
import java.util.Stack;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask for the number of disks
        System.out.print("Enter number of disks: ");
        int n = input.nextInt();

        // Create three stacks for the rods
        Stack<Integer> rodA = new Stack<>();
        Stack<Integer> rodB = new Stack<>();
        Stack<Integer> rodC = new Stack<>();

        // Initially, push all disks onto rod A (starting rod)
        for (int i = n; i > 0; i--) {
            rodA.push(i);  // Push disk onto rod A
        }

        System.out.println("Initial state of the rods:");
        printRods(rodA, rodB, rodC);

        // Solve the Tower of Hanoi using stacks
        moveDisks(n, rodA, rodC, rodB);

        System.out.println("Final state of the rods:");
        printRods(rodA, rodB, rodC);
    }

    // Recursive function to move disks
    public static void moveDisks(int n, Stack<Integer> rod1, Stack<Integer> rod3, Stack<Integer> rod2) {
        if (n == 1) {
            // Move a single disk from 'rod1' to 'rod3'
            int disk = rod1.pop();
            rod3.push(disk);
            System.out.println("Move disk " + disk + " from " + rodName(rod1) + " to " + rodName(rod3));
            return;
        }

        // Move n-1 disks from 'rod1' to 'rod2' using 'rod3' as auxiliary
        moveDisks(n - 1, rod1, rod2, rod3);

        // Move the nth disk from 'rod1' to 'rod3'
        int disk = rod1.pop();
        rod3.push(disk);
        System.out.println("Move disk " + disk + " from " + rodName(rod1) + " to " + rodName(rod3));

        // Move n-1 disks from 'rod2' to 'rod3' using 'rod1' as auxiliary
        moveDisks(n - 1, rod2, rod3, rod1);
    }

    // Helper method to print the current state of the rods
    public static void printRods(Stack<Integer> rodA, Stack<Integer> rodB, Stack<Integer> rodC) {
        System.out.println("Rod A: " + rodA);
        System.out.println("Rod B: " + rodB);
        System.out.println("Rod C: " + rodC);
    }

    // Helper method to get the name of the rod
    public static String rodName(Stack<Integer> rod) {
        // Return the name of the rod based on the reference to the stack object
        if (rod == null) return "Unknown";
        if (rod.isEmpty()) return "Empty";

        if (rod.toString().equals("[" + rod.peek() + "]")) {
            return "Rod A";
        }
        if (rod.toString().equals("[" + rod.peek() + "]")) {
            return "Rod B";
        }
        if (rod.toString().equals("[" + rod.peek() + "]")) {
            return "Rod C";
        }

        return "Unknown"; 
    }
}
