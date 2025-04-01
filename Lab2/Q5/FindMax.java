package Lab2.Q5;

public class FindMax {
    static class Circle implements Comparable<Circle> {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public int compareTo(Circle o) {
            if (this.radius > o.radius){
                return 1;
            }
            else if (this.radius < o.radius) {
                return -1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return Double.toString(this.radius);
        }
    }

    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3};
        String[] strArr = {"red", "green", "blue"};
        Circle[] circles = {new Circle(3), new Circle(2.9), new Circle(5.9)};

        System.out.println(max(intArr));
        System.out.println(max(strArr));
        System.out.println(max(circles));

        
    }
    
    public static <E extends Comparable<E>> E max(E[] list) {
            E maxElem = list[0];
            for (E elem : list) {
                if (elem.compareTo(maxElem) > 0){
                    maxElem = elem;
                }
            }
            return maxElem;
        }
}
