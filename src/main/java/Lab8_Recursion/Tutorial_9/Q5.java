package Lab8_Recursion.Tutorial_9;

public class Q5 {
    public static void main(String[] args) {
        System.out.println(printDigit(4567));
    }

    public static String printDigit(int num) {
        String numString = Integer.toString(num);
        if (numString.length() == 1) {
            return numString;
        }
        return numString.charAt(0) + " " + printDigit(Integer.parseInt(numString.substring(1)));
    }
}
