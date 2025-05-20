
public class Q2 {

    public static void main(String[] args) {
        System.out.println(permuteString("ABC"));
    }

    public static String[] permuteString(String s) {
        if (s.length() == 1) {
            
        }
    }

    public static String[] insert(String word, String insertChar) {
        String[] wordArr = null;
        for (int i = 0; i < word.length() - 1; i++) {
            String newWord = "";
            newWord = word.substring(0, i) + insertChar + word.substring(i, word.length() - 1);
            
        }
    }
}
