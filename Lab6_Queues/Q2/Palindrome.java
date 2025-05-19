
import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word = input.next().toLowerCase();
        Queue<Character> queue = new Queue<>();
        for (int i = word.length() - 1; i >= 0; i--) {
            queue.enqueue(word.toCharArray()[i]);
        }

        String reversed = "";
        while (!queue.isEmpty()) {
            reversed += queue.dequeue();
        }

        if (word.equals(reversed)) {
            System.out.println("The word " + word + " is palindrome.");
        } else {
            System.out.println("The word " + word + " is not palindrome.");

        }

    }
}
