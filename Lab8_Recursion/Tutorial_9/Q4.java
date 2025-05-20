package Tutorial_9;

public class Q4 {

    public static void main(String[] args) {
        System.out.println(sum(5));
    }

    public static int sum(int n) {
        int total = 0;
        if (n == 1) {
            return 1;
        }
        return n += sum(n - 1);
    }
}
