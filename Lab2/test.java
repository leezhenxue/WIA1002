package Lab2;

class Duo<A, B> {
    private A first;
    private B second;

    public Duo(A first, B second) {
        this.first = first;
        this.second = second;
    }
}

class Q6 {
    public static void main(String[] args) {
        Duo<String, Integer> sideShape = new Duo<>("Hello", 123);
        Duo<Double, Double> points = new Duo<>(1.2, 12.3);
    }
}
