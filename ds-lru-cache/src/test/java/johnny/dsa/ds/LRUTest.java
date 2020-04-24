package johnny.dsa.ds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LRUTest {

    @Test
    public void testLRUCache() {
        System.out.println("testLRUCache");
        LRU lru = new LRU(5); //capacity = 5
        lru.put(1,10);
        assertArrayEquals(new int[]{10}, lru.getAll());
        lru.put(2,20);
        assertArrayEquals(new int[]{20,10}, lru.getAll());
        lru.put(3,30);
        assertArrayEquals(new int[]{30,20,10}, lru.getAll());
        assertEquals(10, lru.get(1));
        assertArrayEquals(new int[]{10,30,20}, lru.getAll());
        assertEquals(30, lru.get(3));
        assertArrayEquals(new int[]{30,10,20}, lru.getAll());
        assertEquals(30, lru.get(3));
        assertArrayEquals(new int[]{30,10,20}, lru.getAll());
        lru.put(4,40);
        assertArrayEquals(new int[]{40,30,10,20}, lru.getAll());
        lru.put(5,50);
        assertArrayEquals(new int[]{50,40,30,10,20}, lru.getAll());
        lru.put(6,60);
        assertArrayEquals(new int[]{60,50,40,30,10}, lru.getAll());
        assertEquals(40, lru.get(4));
        assertArrayEquals(new int[]{40,60,50,30,10}, lru.getAll());
        lru.put(7,70);
        assertArrayEquals(new int[]{70,40,60,50,30}, lru.getAll());
        lru.put(8,80);
        assertArrayEquals(new int[]{80,70,40,60,50}, lru.getAll());
    }

    @Test
    public void testLRUCache2() {
        System.out.println("testLRUCache2");
        LRU lru = new LRU(2);
        lru.put(2,1);
        lru.put(1,1);
        lru.put(2,3);
        lru.put(4,1);
        assertEquals(-1, lru.get(1));
        assertEquals(3, lru.get(2));
    }
    
    @Test
    public void testLRUCache_For_Blog() {
        System.out.println("testLRUCache_For_Blog");
        LRU lru = new LRU(5); //capacity = 5
        lru.put(1,1); // values = [1]
        lru.put(2,2); // values = [2,1]
        lru.put(3,3); // values = [3,2,1]
        lru.get(1);   // values = [1,3,2], return 1
        lru.get(3);   // values = [3,1,2], return 3
        lru.get(3);   // values = [3,1,2], return 3
        lru.put(4,4); // values = [4,3,1,2]
        lru.put(5,5); // values = [5,4,3,1,2], cache is full
        lru.put(6,6); // values = [6,5,4,3,1], remove least recently visited element, 2
        lru.get(4);   // values = [4,6,5,3,1], return 4
        lru.put(7,7); // values = [7,4,6,5,3], remove 1
        lru.put(7,2); // values = [2,4,6,5,3], element with key=7 is updated
        lru.get(7);   // keys = [7,4,6,5,3], values = [2,4,6,5,3], return 2
        lru.put(3,9);   // keys = [3,7,4,6,5], values = [9,2,4,6,5], move key=3 to head
        lru.get(3);   // keys = [3,7,4,6,5], values = [9,2,4,6,5], return 9
    }
}
