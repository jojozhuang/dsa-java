package johnny.dsa.ds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LRUDequeTest {

    @Test
    public void testLRUCacheDeque() {
        System.out.println("testLRUCacheDeque");
        LRUDeque lru = new LRUDeque(5); //capacity = 5
        lru.add(1,1);
        assertArrayEquals(new int[]{1}, lru.getAll());
        lru.add(2,2);
        assertArrayEquals(new int[]{2,1}, lru.getAll());
        lru.add(3,3);
        assertArrayEquals(new int[]{3,2,1}, lru.getAll());
        assertEquals(1, lru.get(1));
        assertArrayEquals(new int[]{1,3,2}, lru.getAll());
        assertEquals(3, lru.get(3));
        assertArrayEquals(new int[]{3,1,2}, lru.getAll());
        assertEquals(3, lru.get(3));
        assertArrayEquals(new int[]{3,1,2}, lru.getAll());
        lru.add(4,4);
        assertArrayEquals(new int[]{4,3,1,2}, lru.getAll());
        lru.add(5,5);
        assertArrayEquals(new int[]{5,4,3,1,2}, lru.getAll());
        lru.add(6,6);
        assertArrayEquals(new int[]{6,5,4,3,1}, lru.getAll());
        assertEquals(4, lru.get(4));
        assertArrayEquals(new int[]{4,6,5,3,1}, lru.getAll());
        lru.add(7,7);
        assertArrayEquals(new int[]{7,4,6,5,3}, lru.getAll());
        lru.add(8,8);
        assertArrayEquals(new int[]{8,7,4,6,5}, lru.getAll());
    }
}
