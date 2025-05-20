public class Q3 {
public static void main(String[] args) {
    System.out.println(exponent(10, 3));
    System.out.println(exponent(5, 3));
}

public static long exponent(int x, int m) {
    if (m == 1) {
        return x;
    }
    return x * exponent(x, m-1);
}
}
