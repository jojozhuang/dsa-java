package johnny.dsa.sorting.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.dsa.sorting.InsertionSort;

public class InsertionSortTest {

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
    public void testInsertionSort() {
        System.out.println("testInsertionSort");
        InsertionSort instance = new InsertionSort();
        
        int[] nums = null;
        instance.insertionSort(nums);
        assertArrayEquals(null, nums);
        
        int[] nums2 = new int[]{2,4,5,7,1,2,3,6};
        instance.insertionSort(nums2);
        assertArrayEquals(new int[]{1,2,2,3,4,5,6,7}, nums2);
        
        int[] nums3 = new int[]{9,7,6,15,16,5,10,11};
        instance.insertionSort(nums3);
        assertArrayEquals(new int[]{5,6,7,9,10,11,15,16}, nums3);
    }
}
