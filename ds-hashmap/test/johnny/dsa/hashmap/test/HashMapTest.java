package johnny.dsa.hashmap.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.dsa.hashmap.HashMap;

public class HashMapTest {

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
    public void testHashMap() {
        System.out.println("testHashMap");
        final HashMap<Integer, String> map = new HashMap<Integer, String>();
        assertEquals(true, map.isEmpty());
        map.add(0, "inital");
        map.add(1, "A");
        map.add(2, "B");
        map.add(5, "E");
        assertEquals(false, map.isEmpty());
        assertEquals(4, map.size());
        assertEquals("A", map.get(1));
        assertEquals("E", map.get(5));
        assertNull(map.get(9));
        map.remove(2);
        assertNull(map.get(2));
        
        map.add(2, "BB");
        map.add(3, "C");
        map.add(4, "D");
        map.add(6, "F"); // rehashing, 7 out of 10, size doubled
        map.add(7, "G"); 
        map.add(8, "H");
        map.add(9, "I");
        map.add(10, "J");
        map.add(11, "K");
        map.add(110, "J2");
        map.add(111, "K2"); // rehashing, 14 out of 20, size doubled
        assertEquals(14, map.size());
        assertEquals("J", map.get(10));
        assertEquals("K", map.get(11));
        assertEquals("J2", map.get(110));
        assertEquals("K2", map.get(111));
    }
}
