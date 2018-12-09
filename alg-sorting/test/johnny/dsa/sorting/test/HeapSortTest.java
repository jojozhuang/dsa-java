package johnny.dsa.sorting.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import johnny.dsa.sorting.HeapSort;

public class HeapSortTest {

    @Test
    public void testHeapSort() {
        System.out.println("testHeapSort");
        HeapSort instance = new HeapSort();
        
        int[] nums = null;
        instance.heapSort(nums);
        assertArrayEquals(null, nums);
        
        int[] nums2 = new int[]{2,4,5,7,1,2,3,6};
        instance.heapSort(nums2);
        assertArrayEquals(new int[]{1,2,2,3,4,5,6,7}, nums2);
        
        int[] nums3 = new int[]{9,7,6,15,16,5,10,11};
        instance.heapSort(nums3);
        assertArrayEquals(new int[]{5,6,7,9,10,11,15,16}, nums3);
    }
}
