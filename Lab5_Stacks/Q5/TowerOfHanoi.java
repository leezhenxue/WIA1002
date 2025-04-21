package Q5;

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
    public static void moveDisks(int n, Stack<Integer> fromRod, Stack<Integer> toRod, Stack<Integer> auxRod) {
        if (n == 1) {
            // Move a single disk from 'fromRod' to 'toRod'
            int disk = fromRod.pop();
            toRod.push(disk);
            System.out.println("Move disk " + disk + " from " + rodName(fromRod) + " to " + rodName(toRod));
            return;
        }

        // Move n-1 disks from 'fromRod' to 'auxRod' using 'toRod' as auxiliary
        moveDisks(n - 1, fromRod, auxRod, toRod);

        // Move the nth disk from 'fromRod' to 'toRod'
        int disk = fromRod.pop();
        toRod.push(disk);
        System.out.println("Move disk " + disk + " from " + rodName(fromRod) + " to " + rodName(toRod));

        // Move n-1 disks from 'auxRod' to 'toRod' using 'fromRod' as auxiliary
        moveDisks(n - 1, auxRod, toRod, fromRod);
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
