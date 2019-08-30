package johnny.dsa.monotonicqueue.test;

import johnny.dsa.monotonicqueue.FirstSmallerMonotonicQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FirstSmallerMonotonicQueueTest {

    @Test
    public void testFirstSmallerLeft() {
        FirstSmallerMonotonicQueue instance = new FirstSmallerMonotonicQueue();
        int[][] result1 = instance.firstSmaller(new int[] {5,3,1,2,4});
        assertArrayEquals(new int[]{-1,-1,-1,1,2}, result1[0]);
        assertArrayEquals(new int[]{3,1,-1,-1,-1}, result1[1]);

        int[][] result2 = instance.firstSmaller(new int[] {5,3,1,2,4,8,0,7,1,3});
        assertArrayEquals(new int[]{-1,-1,-1,1,2,4,-1,0,0,1}, result2[0]);
        assertArrayEquals(new int[]{3,1,0,0,0,0,-1,1,-1,-1}, result2[1]);
    }

    @Test
    public void testFirstSmallerRight() {
        FirstSmallerMonotonicQueue instance = new FirstSmallerMonotonicQueue();
        int[][] result1 = instance.firstLarger(new int[] {5,3,1,2,4});
        assertArrayEquals(new int[]{-1,5,3,3,5}, result1[0]);
        assertArrayEquals(new int[]{-1,4,2,4,-1}, result1[1]);

        int[][] result2 = instance.firstLarger(new int[] {5,3,1,2,4,8,0,7,1,3});
        assertArrayEquals(new int[]{-1,5,3,3,5,-1,8,8,7,7}, result2[0]);
        assertArrayEquals(new int[]{8,4,2,4,8,-1,7,-1,3,-1}, result2[1]);
    }

}