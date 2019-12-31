package johnny.dsa.ds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LFUTest {

    @Test
    public void testLFUCache() {
        System.out.println("testLFUCache");
        LFU lfu = new LFU(5); //capacity = 5
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

    @Test
    public void testLFUCache2() {
        System.out.println("testLFUCache2");
        LFU lfu = new LFU(0); //capacity = 0
        lfu.add(0,0);
        assertEquals(Integer.MIN_VALUE, lfu.get(0));
        //assertArrayEquals(new int[][]{{-1},{0}}, lfu.getAll());

        LFU lfu2 = new LFU(2); //capacity = 0
        lfu2.add(3,1);
        lfu2.add(2,1);
        lfu2.add(2,2);
        lfu2.add(4,4);
        assertEquals(2, lfu2.get(2));
        assertArrayEquals(new int[][]{{2,4},{1,0}}, lfu2.getAll());
    }
    
    @Test
    public void testLRUCache_For_Blog() {
        System.out.println("testLRUCache_For_Blog");
        LFU lfu = new LFU(5); //capacity = 5
        lfu.add(1,1); // value = [1],         frequency = [0]
        lfu.add(2,2); // value = [2,1],       frequency = [0,0]
        lfu.add(3,3); // value = [3,2,1],     frequency = [0,0,0]
        lfu.get(1);   // value = [1,3,2],     frequency = [1,0,0], return 1
        lfu.get(3);   // value = [3,1,2],     frequency = [1,1,0], return 3
        lfu.get(3);   // value = [3,1,2],     frequency = [2,1,0], return 3
        lfu.add(4,4); // value = [3,1,4,2],   frequency = [2,1,0,0]
        lfu.add(5,5); // value = [3,1,5,4,2], frequency = [2,1,0,0,0], cache is full
        lfu.add(6,6); // value = [3,1,6,5,4], frequency = [2,1,0,0,0], last element 2 is removed
        lfu.get(4);   // value = [3,4,1,6,5], frequency = [2,1,1,0,0], return 4
        lfu.add(7,7); // value = [3,4,1,7,6], frequency = [2,1,1,0,0], last element 5 is removed
        lfu.get(7);   // value = [3,7,4,1,6], frequency = [2,1,1,1,0], return 7
        lfu.get(6);   // value = [3,6,7,4,1], frequency = [2,1,1,1,1], return 6
        lfu.get(6);   // value = [6,3,7,4,1], frequency = [2,2,1,1,1], return 6
        lfu.get(6);   // value = [6,3,7,4,1], frequency = [3,2,1,1,1], return 6
        lfu.add(8,8); // value = [6,3,7,4,8], frequency = [3,2,1,1,0], last element 1 is removed
    }
}
