package johnny.datastructure.lfu.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.datastructure.lfu.LFU;

public class LFUTest {

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
    public void testLFUCache() {
        System.out.println("testLFUCache");
        LFU lfu = new LFU(5); //capacity = 5
        lfu.add(1);
        assertArrayEquals(new int[][]{{1},{0}}, lfu.getAll());
        lfu.add(2);
        assertArrayEquals(new int[][]{{2,1},{0,0}}, lfu.getAll());
        lfu.add(3);
        assertArrayEquals(new int[][]{{3,2,1},{0,0,0}}, lfu.getAll());
        assertEquals(1, lfu.get(1));
        assertArrayEquals(new int[][]{{1,3,2},{1,0,0}}, lfu.getAll());
        assertEquals(3, lfu.get(3));
        assertArrayEquals(new int[][]{{3,1,2},{1,1,0}}, lfu.getAll());
        assertEquals(3, lfu.get(3));
        assertArrayEquals(new int[][]{{3,1,2},{2,1,0}}, lfu.getAll());
        lfu.add(4);
        assertArrayEquals(new int[][]{{3,1,4,2},{2,1,0,0}}, lfu.getAll());
        lfu.add(5);
        assertArrayEquals(new int[][]{{3,1,5,4,2},{2,1,0,0,0}}, lfu.getAll());
        lfu.add(6);
        assertArrayEquals(new int[][]{{3,1,6,5,4},{2,1,0,0,0}}, lfu.getAll());
        assertEquals(4, lfu.get(4));
        assertArrayEquals(new int[][]{{3,4,1,6,5},{2,1,1,0,0}}, lfu.getAll());
        lfu.add(7);
        assertArrayEquals(new int[][]{{3,4,1,7,6},{2,1,1,0,0}}, lfu.getAll());
        assertEquals(7, lfu.get(7));
        assertArrayEquals(new int[][]{{3,7,4,1,6},{2,1,1,1,0}}, lfu.getAll());
        assertEquals(6, lfu.get(6));
        assertArrayEquals(new int[][]{{3,6,7,4,1},{2,1,1,1,1}}, lfu.getAll());
        assertEquals(6, lfu.get(6));
        assertArrayEquals(new int[][]{{6,3,7,4,1},{2,2,1,1,1}}, lfu.getAll());
        assertEquals(6, lfu.get(6));
        assertArrayEquals(new int[][]{{6,3,7,4,1},{3,2,1,1,1}}, lfu.getAll());
        lfu.add(8);
        assertArrayEquals(new int[][]{{6,3,7,4,8},{3,2,1,1,0}}, lfu.getAll());
    }
    
    @Test
    public void testLRUCache_For_Blog() {
        System.out.println("testLRUCache_For_Blog");
        LFU lru = new LFU(5); //capacity = 5
        lru.add(1); // list = [1]
        lru.add(2); // list = [2,1]
        lru.add(3); // list = [3,2,1]
        lru.get(1); // list = [1,3,2], return 1
        lru.get(3); // list = [3,1,2], return 3
        lru.get(3); // list = [3,1,2], return 3
        lru.add(4); // list = [4,3,1,2]
        lru.add(5); // list = [5,4,3,1,2], cache is full
        lru.add(6); // list = [6,5,4,3,1]
        lru.get(4); // list = [4,6,5,3,1], return 4
        lru.add(7); // list = [7,4,6,5,3]
        lru.add(8); // list = [8,7,4,6,5]
    }
}
