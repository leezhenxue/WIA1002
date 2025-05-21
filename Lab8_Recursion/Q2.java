
public class Q2 {

    public static void main(String[] args) {
        permuteString("ABC");
    }

    public static void permuteString(String s) {
        permuteString(s, "");
    }

    public static void permuteString(String startString, String resultString) {

        if (startString.length() == 0) {
            System.out.println(resultString);
            return;
        }

        for (int i = 0; i <= resultString.length(); i++) {
            permuteString(startString.substring(1), resultString.substring(0, i) + startString.charAt(0) + resultString.substring(i, resultString.length()));
        }
    }
}
