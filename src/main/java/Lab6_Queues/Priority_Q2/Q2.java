package Lab6_Queues.Priority_Q2;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Q2 {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("George", "Jim", "John", "Blake", "Kevin", "Michael");
        List<String> list2 = Arrays.asList("George", "Katie", "Kevin", "Michelle", "Ryan");
        PriorityQueue<String> queue1 = new PriorityQueue<>(list1);
        PriorityQueue<String> queue2 = new PriorityQueue<>(list2);

        PriorityQueue<String> union = new PriorityQueue<>();
        PriorityQueue<String> difference = new PriorityQueue<>();
        PriorityQueue<String> intersection = new PriorityQueue<>();


        for (Object elem : list1) {
            
            if (list2.contains(elem)) {
                intersection.add((String)elem);
            }
            else {
                difference.add((String)elem);
            }
        }
        for (Object elem : list2) {
            if (!list1.contains(elem)) {
                difference.add((String)elem);
                
            }
        }
        union.addAll(intersection);
        union.addAll(difference);

        System.out.println("union: " + union.toString());
        System.out.println("difference: " + difference.toString());
        System.out.println("intersection: " + intersection.toString());





    }
}
