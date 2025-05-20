package Q1;

public class Q1 {
    public static void main(String[] args) {
        System.out.println(substituteAI("falbbergasted"));
        System.out.println(substituteAI("Astrounat"));
    }

    public static String substituteAI(String word) {
        if (word.length() == 1) {
            if (word.equals("a")) {
                return "i";
            }
            return word;
        }
        if (word.charAt(0) == 'a') {
            return "i" + substituteAI(word.substring(1));
        }
        return String.valueOf(word.charAt(0)) + substituteAI(word.substring(1));
    }
}
