package johnny.datastructure.lfu.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.datastructure.lfu.LFUHeap;

public class LFUHeapTest {

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
    public void testLFUCache_Heap() {
        System.out.println("testLFUCache_Heap");
        LFUHeap lfu = new LFUHeap(5); //capacity = 5
        lfu.add(1,1);
        assertArrayEquals(new int[][]{{1},{0}}, lfu.getAll());
        lfu.add(2,2);
        assertArrayEquals(new int[][]{{2,1},{0,0}}, lfu.getAll());
        lfu.add(3,3);
        assertArrayEquals(new int[][]{{3,2,1},{0,0,0}}, lfu.getAll());
        assertEquals(1, lfu.get(1));
        assertArrayEquals(new int[][]{{1,3,2},{1,0,0}}, lfu.getAll());
        assertEquals(3, lfu.get(3));
        assertArrayEquals(new int[][]{{3,1,2},{1,1,0}}, lfu.getAll());
        assertEquals(3, lfu.get(3));
        assertArrayEquals(new int[][]{{3,1,2},{2,1,0}}, lfu.getAll());
        lfu.add(4,4);
        assertArrayEquals(new int[][]{{3,1,4,2},{2,1,0,0}}, lfu.getAll());
        lfu.add(5,5);
        assertArrayEquals(new int[][]{{3,1,5,4,2},{2,1,0,0,0}}, lfu.getAll());
        lfu.add(6,6);
        assertArrayEquals(new int[][]{{3,1,6,5,4},{2,1,0,0,0}}, lfu.getAll());
        assertEquals(4, lfu.get(4));
        assertArrayEquals(new int[][]{{3,4,1,6,5},{2,1,1,0,0}}, lfu.getAll());
        lfu.add(7,7);
        assertArrayEquals(new int[][]{{3,4,1,7,6},{2,1,1,0,0}}, lfu.getAll());
        assertEquals(7, lfu.get(7));
        assertArrayEquals(new int[][]{{3,7,4,1,6},{2,1,1,1,0}}, lfu.getAll());
        assertEquals(6, lfu.get(6));
        assertArrayEquals(new int[][]{{3,6,7,4,1},{2,1,1,1,1}}, lfu.getAll());
        assertEquals(6, lfu.get(6));
        assertArrayEquals(new int[][]{{6,3,7,4,1},{2,2,1,1,1}}, lfu.getAll());
        assertEquals(6, lfu.get(6));
        assertArrayEquals(new int[][]{{6,3,7,4,1},{3,2,1,1,1}}, lfu.getAll());
        lfu.add(8,8);
        assertArrayEquals(new int[][]{{6,3,7,4,8},{3,2,1,1,0}}, lfu.getAll());
    }
}
