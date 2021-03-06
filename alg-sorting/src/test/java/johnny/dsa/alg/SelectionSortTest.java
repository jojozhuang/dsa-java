package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SelectionSortTest {

    @Test
    public void testSelectionSort() {
        System.out.println("testSelectionSort");
        SelectionSort instance = new SelectionSort();
        
        int[] nums = null;
        instance.selectionSort(nums);
        assertArrayEquals(null, nums);
        
        int[] nums2 = new int[]{2,4,5,7,1,2,3,6};
        instance.selectionSort(nums2);
        assertArrayEquals(new int[]{1,2,2,3,4,5,6,7}, nums2);
        
        int[] nums3 = new int[]{9,7,6,15,16,5,10,11};
        instance.selectionSort(nums3);
        assertArrayEquals(new int[]{5,6,7,9,10,11,15,16}, nums3);
    }
}
