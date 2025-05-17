package Priority_Q1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q1 {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(4);
        queue.add(8);
        queue.add(1);
        queue.add(2);
        queue.add(9);
        queue.add(6);
        queue.add(3);
        queue.add(7);

        System.out.println(queue.toString());
        System.out.println(queue.poll());
        queue.add(5);
        System.out.println(Arrays.toString(queue.toArray()));
        System.out.println(queue.peek());
        System.out.println(queue.contains(1));
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        PriorityQueue<Integer> tempQ = new PriorityQueue<>((a,b) -> b - a);
        tempQ.addAll(queue);
        queue = tempQ;
        System.out.println(queue.toString());


    }
}
