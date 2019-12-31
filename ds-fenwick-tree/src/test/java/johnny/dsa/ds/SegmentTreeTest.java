package johnny.dsa.ds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SegmentTreeTest {

    @Test
    public void testSegmentTree() {
        System.out.println("testSegmentTree");
        int[] nums = new int[]{2, -1, 6, 1, 5, -3, 4, 1, -2, 7};
        SegmentTree instance = new SegmentTree(nums);
        assertEquals(2, instance.prefixSum(0));
        assertEquals(1, instance.prefixSum(1));
        assertEquals(7, instance.prefixSum(2));
        assertEquals(8, instance.prefixSum(3));
        assertEquals(13, instance.prefixSum(4));
        assertEquals(10, instance.prefixSum(5));
        assertEquals(14, instance.prefixSum(6));
        assertEquals(15, instance.prefixSum(7));
        assertEquals(13, instance.prefixSum(8));
        assertEquals(20, instance.prefixSum(9));
        assertEquals(8, instance.rangeSum(0, 3));
        assertEquals(13, instance.rangeSum(0, 4));
        assertEquals(6, instance.rangeSum(3, 4));
        assertEquals(5, instance.rangeSum(4, 4));
        assertEquals(-1, instance.rangeSum(7, 8));
        assertEquals(20, instance.rangeSum(0, 9));
        instance.update(1, 2);
        assertEquals(2, instance.prefixSum(0));
        assertEquals(4, instance.prefixSum(1));
        assertEquals(10, instance.prefixSum(2));
        assertEquals(11, instance.prefixSum(3));
        assertEquals(16, instance.prefixSum(4));
        assertEquals(18, instance.prefixSum(7));
        assertEquals(11, instance.rangeSum(0, 3));
        assertEquals(16, instance.rangeSum(0, 4));
        assertEquals(6, instance.rangeSum(3, 4));
        assertEquals(5, instance.rangeSum(4, 4));
        assertEquals(-1, instance.rangeSum(7, 8));
        assertEquals(23, instance.rangeSum(0, 9));
    }
}
