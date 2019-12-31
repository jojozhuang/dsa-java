package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BubbleSortTest {

    @Test
    public void testBubbleSort() {
        System.out.println("testBubbleSort");
        BubbleSort instance = new BubbleSort();
        
        int[] nums = null;
        instance.bubbleSort(nums);
        assertArrayEquals(null, nums);
        
        int[] nums2 = new int[]{2,4,5,7,1,2,3,6};
        instance.bubbleSort(nums2);
        assertArrayEquals(new int[]{1,2,2,3,4,5,6,7}, nums2);
        
        int[] nums3 = new int[]{9,7,6,15,16,5,10,11};
        instance.bubbleSort(nums3);
        assertArrayEquals(new int[]{5,6,7,9,10,11,15,16}, nums3);
    }
}
