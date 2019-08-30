package johnny.dsa.monotonicqueue.test;

import johnny.dsa.monotonicqueue.FirstSmallerMonotonicQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FirstSmallerMonotonicQueueTest {

    @Test
    public void testFirstSmallerLeft() {
        FirstSmallerMonotonicQueue instance = new FirstSmallerMonotonicQueue();
        assertArrayEquals(new int[]{-1,-1,-1,1,2}, instance.firstSmallerLeft(new int[] {5,3,1,2,4}));
        assertArrayEquals(new int[]{-1,-1,-1,1,2,4,-1,0,0,1}, instance.firstSmallerLeft(new int[] {5,3,1,2,4,8,0,7,1,3}));
    }

    @Test
    public void testFirstSmallerRight() {
        FirstSmallerMonotonicQueue instance = new FirstSmallerMonotonicQueue();
        assertArrayEquals(new int[]{3,1,-1,-1,-1}, instance.firstSmallerRight(new int[] {5,3,1,2,4}));
        assertArrayEquals(new int[]{3,1,0,0,0,0,-1,1,-1,-1}, instance.firstSmallerRight(new int[] {5,3,1,2,4,8,0,7,1,3}));
    }

}