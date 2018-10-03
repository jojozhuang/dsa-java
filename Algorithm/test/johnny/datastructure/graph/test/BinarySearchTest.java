package johnny.datastructure.graph.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.dsa.algorithm.BinarySearch;;

public class BinarySearchTest {

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

    @Test
    public void testSearchRecursive() {
        System.out.println("testSearchRecursive");
        BinarySearch instance = new BinarySearch();

        assertEquals(4, instance.searchRecursive(new int[] {-1,0,3,5,9,12}, 9));
        assertEquals(-1, instance.searchRecursive(new int[] {-1,0,3,5,9,12}, 2));
    }
    
    @Test
    public void testSearchIterative() {
        System.out.println("testSearchIterative");
        BinarySearch instance = new BinarySearch();

        assertEquals(4, instance.searchIterative(new int[] {-1,0,3,5,9,12}, 9));
        assertEquals(-1, instance.searchIterative(new int[] {-1,0,3,5,9,12}, 2));
    }
    
    @Test
    public void testSearchTemplate() {
        System.out.println("testSearchTemplate");
        BinarySearch instance = new BinarySearch();

        assertEquals(4, instance.search(new int[] {-1,0,3,5,9,12}, 9));
        assertEquals(-1, instance.search(new int[] {-1,0,3,5,9,12}, 2));
    }
}
