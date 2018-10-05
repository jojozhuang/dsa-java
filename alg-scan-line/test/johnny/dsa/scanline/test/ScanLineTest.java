package johnny.dsa.scanline.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.dsa.scanline.ScanLine;;

public class ScanLineTest {

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
    public void testMostPopulationYear() {
        System.out.println("getMostPopulationYear");
        ScanLine instance = new ScanLine();

        int[][] people1 = new int[][] {{1970, 2001}};
        assertEquals(1, instance.getMostPopulationYear(people1));
        
        int[][] people2 = new int[][] {{1970, 2001},{1980, 1998}, {2000, 2018},{1956, 2017}};
        assertEquals(3, instance.getMostPopulationYear(people2));
        
        int[][] people3 = new int[][] {{1970, 2001},{1980, 2002}, {2000, 2018},{1956, 2017}};
        assertEquals(4, instance.getMostPopulationYear(people3));
    }
}
