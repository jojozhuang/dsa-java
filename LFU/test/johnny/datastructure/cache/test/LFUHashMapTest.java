package johnny.datastructure.cache.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.datastructure.cache.LFUHashMap;
import johnny.datastructure.cache.LFU;

public class LFUHashMapTest {

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
    public void testLRUCache() {
        System.out.println("testLRUCache");
        LFUHashMap lfu = new LFUHashMap(2);

        lfu.put(1, 1);
        lfu.put(2, 2);
        assertEquals(1, lfu.get(1));       // returns 1
        lfu.put(3, 3);                     // evicts key 2
        assertEquals(-1, lfu.get(2));      // returns -1 (not found)
        assertEquals(3, lfu.get(3));       // returns 3.
        lfu.put(4, 4);                     // evicts key 1.
        assertEquals(-1,lfu.get(1));       // returns -1 (not found)
        assertEquals(3,lfu.get(3));        // returns 3
        assertEquals(4,lfu.get(4));        // returns 4
    }
    
    @Test
    public void testLFUCache() {
        System.out.println("testLFUCache");
        LFUHashMap lfu = new LFUHashMap(5); //capacity = 5
        lfu.put(1,1);
        assertArrayEquals(new int[]{1}, lfu.getAll());
        lfu.put(2,2);
        assertArrayEquals(new int[]{2,1}, lfu.getAll());
        lfu.put(3,3);
        assertArrayEquals(new int[]{3,2,1}, lfu.getAll());
        assertEquals(1, lfu.get(1));
        assertArrayEquals(new int[]{1,3,2}, lfu.getAll());
        assertEquals(3, lfu.get(3));
        assertArrayEquals(new int[]{3,1,2}, lfu.getAll());
        assertEquals(3, lfu.get(3));
        assertArrayEquals(new int[]{3,1,2}, lfu.getAll());
        lfu.put(4,4);
        assertArrayEquals(new int[]{3,1,4,2}, lfu.getAll());
        lfu.put(5,5);
        assertArrayEquals(new int[]{3,1,5,4,2}, lfu.getAll());
        lfu.put(6,6);
        assertArrayEquals(new int[]{3,1,6,5,4}, lfu.getAll());
        assertEquals(4, lfu.get(4));
        assertArrayEquals(new int[]{3,4,1,6,5}, lfu.getAll());
        lfu.put(7,7);
        assertArrayEquals(new int[]{3,4,1,7,6}, lfu.getAll());
        assertEquals(7, lfu.get(7));
        assertArrayEquals(new int[]{3,7,4,1,6}, lfu.getAll());
        assertEquals(6, lfu.get(6));
        assertArrayEquals(new int[]{3,6,7,4,1}, lfu.getAll());
        assertEquals(6, lfu.get(6));
        assertArrayEquals(new int[]{6,3,7,4,1}, lfu.getAll());
        assertEquals(6, lfu.get(6));
        assertArrayEquals(new int[]{6,3,7,4,1}, lfu.getAll());
        lfu.put(8,8);
        assertArrayEquals(new int[]{6,3,7,4,8}, lfu.getAll());
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
