package johnny.dsa.ds;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class QueueMergeSortTest {

    @Test
    public void testQueueMergeSort() {
        System.out.println("testQueueMergeSort");

        QueueMergeSort instance = new QueueMergeSort();
        Queue<Integer> result1 = instance.sort(null);
        Queue<Integer> expect1 = null;
        assertEquals(expect1, result1);

        Queue<Integer> result2 = instance.sort(new int[] {7,2});
        Queue<Integer> expect2 = new LinkedList<Integer>();
        int[] nums2 = new int[] {2,7};
        for (int i : nums2) {
            expect2.offer(i);
        }
        assertEquals(expect2, result2);

        Queue<Integer> result3 = instance.sort(new int[] {5,1,4});
        Queue<Integer> expect3 = new LinkedList<Integer>();
        int[] nums3 = new int[] {1,4,5};
        for (int i : nums3) {
            expect3.offer(i);
        }
        assertEquals(expect3, result3);
        
        Queue<Integer> result4 = instance.sort(new int[] {2,4,5,7,1,2,3,6});
        Queue<Integer> expect4 = new LinkedList<Integer>();
        int[] nums4 = new int[] {1,2,2,3,4,5,6,7};
        for (int i : nums4) {
            expect4.offer(i);
        }
        assertEquals(expect4, result4);
        
        Queue<Integer> result5 = instance.sort(new int[] {2,4,5,7,1,2,3,6,9});
        Queue<Integer> expect5 = new LinkedList<Integer>();
        int[] nums5 = new int[] {1,2,2,3,4,5,6,7,9};
        for (int i : nums5) {
            expect5.offer(i);
        }
        assertEquals(expect5, result5);
    }
}
