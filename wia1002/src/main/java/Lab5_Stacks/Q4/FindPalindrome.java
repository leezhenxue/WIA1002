package Lab5_Stacks.Q4;

import java.util.Scanner;

public class FindPalindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Word: ");
        String word = input.next();
        System.out.println(palindrome(word));

    }

    public static boolean palindrome(String word) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}
