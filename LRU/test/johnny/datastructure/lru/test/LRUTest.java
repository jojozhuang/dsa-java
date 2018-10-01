package johnny.datastructure.lru.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.datastructure.lru.LRU;

public class LRUTest {

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
        LRU lru = new LRU(5); //capacity = 5
        lru.add(1);
        assertArrayEquals(new int[]{1}, lru.getAll());
        lru.add(2);
        assertArrayEquals(new int[]{2,1}, lru.getAll());
        lru.add(3);
        assertArrayEquals(new int[]{3,2,1}, lru.getAll());
        assertEquals(1, lru.get(1));
        assertArrayEquals(new int[]{1,3,2}, lru.getAll());
        assertEquals(3, lru.get(3));
        assertArrayEquals(new int[]{3,1,2}, lru.getAll());
        assertEquals(3, lru.get(3));
        assertArrayEquals(new int[]{3,1,2}, lru.getAll());
        lru.add(4);
        assertArrayEquals(new int[]{4,3,1,2}, lru.getAll());
        lru.add(5);
        assertArrayEquals(new int[]{5,4,3,1,2}, lru.getAll());
        lru.add(6);
        assertArrayEquals(new int[]{6,5,4,3,1}, lru.getAll());
        assertEquals(4, lru.get(4));
        assertArrayEquals(new int[]{4,6,5,3,1}, lru.getAll());
        lru.add(7);
        assertArrayEquals(new int[]{7,4,6,5,3}, lru.getAll());
        lru.add(8);
        assertArrayEquals(new int[]{8,7,4,6,5}, lru.getAll());
    }
    
    @Test
    public void testLRUCache_For_Blog() {
        System.out.println("testLRUCache_For_Blog");
        LRU lru = new LRU(5); //capacity = 5
        lru.add(1); // values = [1]
        lru.add(2); // values = [2,1]
        lru.add(3); // values = [3,2,1]
        lru.get(1); // values = [1,3,2], return 1
        lru.get(3); // values = [3,1,2], return 3
        lru.get(3); // values = [3,1,2], return 3
        lru.add(4); // values = [4,3,1,2]
        lru.add(5); // values = [5,4,3,1,2], cache is full
        lru.add(6); // values = [6,5,4,3,1]
        lru.get(4); // values = [4,6,5,3,1], return 4
        lru.add(7); // values = [7,4,6,5,3]
        lru.add(8); // values = [8,7,4,6,5]
    }
}
