package Tutorial_9;

public class Q3 {

    public static void main(String[] args) {
        System.out.println(reverse("String"));
    }

    public static String reverse(String word) {
        String reversedWord = "";
        if (word.length() == 1) {
            return word;
        }
        return reversedWord = reverse(word.substring(1)) + word.charAt(0);
    }
}
