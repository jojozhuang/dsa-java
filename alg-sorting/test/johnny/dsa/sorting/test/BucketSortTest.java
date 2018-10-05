package johnny.dsa.sorting.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.dsa.sorting.BucketSort;

public class BucketSortTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of BubbleSort method, of class AllSorting.
     */
    @Test
    public void testBucketSort() {
        System.out.println("testBucketSort");
        BucketSort instance = new BucketSort();
        
        int[] nums = null;
        instance.bucketSort(nums, 0);
        assertArrayEquals(null, nums);
        
        int[] nums2 = new int[]{2,4,5,7,1,2,3,6};
        instance.bucketSort(nums2, 7);
        assertArrayEquals(new int[]{1,2,2,3,4,5,6,7}, nums2);
        
        int[] nums3 = new int[]{5,3,0,2,4,1,0,5,2,3,1,4};
        instance.bucketSort(nums3, 5);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, nums3);
    }
}
