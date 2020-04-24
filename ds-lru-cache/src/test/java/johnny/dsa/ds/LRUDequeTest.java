package johnny.dsa.ds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LRUDequeTest {

    @Test
    public void testLRUCacheDeque() {
        System.out.println("testLRUCacheDeque");
        LRUDeque lru = new LRUDeque(5); //capacity = 5
        lru.put(1,1);
        assertArrayEquals(new int[]{1}, lru.getAll());
        lru.put(2,2);
        assertArrayEquals(new int[]{2,1}, lru.getAll());
        lru.put(3,3);
        assertArrayEquals(new int[]{3,2,1}, lru.getAll());
        assertEquals(1, lru.get(1));
        assertArrayEquals(new int[]{1,3,2}, lru.getAll());
        assertEquals(3, lru.get(3));
        assertArrayEquals(new int[]{3,1,2}, lru.getAll());
        assertEquals(3, lru.get(3));
        assertArrayEquals(new int[]{3,1,2}, lru.getAll());
        lru.put(4,4);
        assertArrayEquals(new int[]{4,3,1,2}, lru.getAll());
        lru.put(5,5);
        assertArrayEquals(new int[]{5,4,3,1,2}, lru.getAll());
        lru.put(6,6);
        assertArrayEquals(new int[]{6,5,4,3,1}, lru.getAll());
        assertEquals(4, lru.get(4));
        assertArrayEquals(new int[]{4,6,5,3,1}, lru.getAll());
        lru.put(7,7);
        assertArrayEquals(new int[]{7,4,6,5,3}, lru.getAll());
        lru.put(8,8);
        assertArrayEquals(new int[]{8,7,4,6,5}, lru.getAll());
    }

    @Test
    public void testLRUCache2() {
        System.out.println("testLRUCache2");
        LRUDeque lru = new LRUDeque(2);
        lru.put(2,1);
        lru.put(1,1);
        lru.put(2,3);
        lru.put(4,1);
        assertEquals(-1, lru.get(1));
        assertEquals(3, lru.get(2));
    }
}
