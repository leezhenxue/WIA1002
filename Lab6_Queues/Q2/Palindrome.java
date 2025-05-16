import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word = input.next();
        Queue queue = new Queue<String>(word);
        Queue queue2 = new Queue<String>(new StringBuilder(word).reverse().toString());
        String first = null, second = null;
        boolean palindrome = true;
        for (int i = 0; i < queue.getSize(); i++) {
            if (!queue.dequeue().equals(queue2.dequeue())) {
                System.out.println("The word " + word + " is not palindrome.");
                palindrome = false;
                break;
            }
        }

        if (palindrome) {
            System.out.println("The word " + word + " is palindrome.");
        }
    }
}
