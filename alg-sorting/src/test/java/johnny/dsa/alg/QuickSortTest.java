package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {

    @Test
    public void testQuickSort() {
        System.out.println("testQuickSort");
        QuickSort instance = new QuickSort();
        
        int[] nums = null;
        instance.quickSort(nums);
        assertArrayEquals(null, nums);
        
        int[] nums2 = new int[]{2,4,5,7,1,2,3,6};
        instance.quickSort(nums2);
        assertArrayEquals(new int[]{1,2,2,3,4,5,6,7}, nums2);
        
        int[] nums3 = new int[]{9,7,6,15,16,5,10,11};
        instance.quickSort(nums3);
        assertArrayEquals(new int[]{5,6,7,9,10,11,15,16}, nums3);
    }
}
