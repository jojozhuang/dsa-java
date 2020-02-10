package johnny.dsa.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapExample {
    public static void main(String[] args) {
        // create min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(1);
        minHeap.offer(2);
        minHeap.offer(3);
        while(!minHeap.isEmpty()) {
            System.out.println(minHeap.poll()); // print [1,2,3]
        }

        // create max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)->b-a);
        minHeap.offer(1);
        minHeap.offer(2);
        minHeap.offer(3);
        while(!minHeap.isEmpty()) {
            System.out.println(minHeap.poll()); // print [3,2,1]
        }

        // create max heap with comparator
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.offer(1);
        pq.offer(2);
        pq.offer(3);
        while(!pq.isEmpty()) {
            System.out.println(pq.poll()); // print [3,2,1]
        }

        // custom comparator
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq2.offer(new int[]{2, 15});
        pq2.offer(new int[]{2, 20});
        pq2.offer(new int[]{3, 30});
        pq2.offer(new int[]{1, 10});
        while(!pq2.isEmpty()) {
            System.out.println(pq2.poll()[1]); // print [10, 20, 15, 30]
        }

        // custom comparator
        PriorityQueue<int[]> pq3 = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        pq3.offer(new int[]{2, 15});
        pq3.offer(new int[]{2, 20});
        pq3.offer(new int[]{3, 30});
        pq3.offer(new int[]{1, 10});
        while(!pq3.isEmpty()) {
            System.out.println(pq3.poll()[1]); // print [10, 15, 20, 30]
        }
    }
}
