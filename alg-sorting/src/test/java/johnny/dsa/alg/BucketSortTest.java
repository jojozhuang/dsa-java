package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BucketSortTest {

    @Test
    public void testBucketSort() {
        System.out.println("testBucketSort");
        BucketSort instance = new BucketSort();
        
        int[] nums = null;
        instance.bucketSort(nums);
        assertArrayEquals(null, nums);
        
        int[] nums2 = new int[]{2,4,5,7,1,2,3,6};
        instance.bucketSort(nums2);
        assertArrayEquals(new int[]{1,2,2,3,4,5,6,7}, nums2);
        
        int[] nums3 = new int[]{5,3,0,2,4,1,0,5,2,3,1,4};
        instance.bucketSort(nums3);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, nums3);
        
        int[] nums4 = new int[]{9,7,6,15,16,5,10,11};
        instance.bucketSort(nums4);
        assertArrayEquals(new int[]{5,6,7,9,10,11,15,16}, nums4);
    }
}
