package johnny.dsa.sweepline.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.dsa.sweepline.Population;;

public class PopulationTest {

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
    public void testMostPopulationBruteForce() {
        System.out.println("testMostPopulationBruteForce");
        Population instance = new Population();

        int[][] persons1 = new int[][] {{1970, 2001}};
        assertEquals(1, instance.getMostPopulationBruteForce(persons1));
        
        int[][] persons2 = new int[][] {{1970, 2001},{1980, 1998}, {2000, 2018},{1956, 2017}};
        assertEquals(3, instance.getMostPopulationBruteForce(persons2));
        
        int[][] persons3 = new int[][] {{1970, 2001},{1980, 2002}, {2000, 2018},{1956, 2017}};
        assertEquals(4, instance.getMostPopulationBruteForce(persons3));
        
        int[][] persons4 = new int[][] {{1938, 1965},{1953, 2008}, {1984, 2016},{1930, 1978},{1945, 2018}};
        assertEquals(4, instance.getMostPopulationBruteForce(persons4));
    }
    
    @Test
    public void testMostPopulationTimeLine() {
        System.out.println("testMostPopulationTimeLine");
        Population instance = new Population();

        int[][] persons1 = new int[][] {{1970, 2001}};
        assertEquals(1, instance.getMostPopulationTimeLine(persons1));
        
        int[][] persons2 = new int[][] {{1970, 2001},{1980, 1998}, {2000, 2018},{1956, 2017}};
        assertEquals(3, instance.getMostPopulationTimeLine(persons2));
        
        int[][] persons3 = new int[][] {{1970, 2001},{1980, 2002}, {2000, 2018},{1956, 2017}};
        assertEquals(4, instance.getMostPopulationTimeLine(persons3));
        
        int[][] persons4 = new int[][] {{1938, 1965},{1953, 2008}, {1984, 2016},{1930, 1978},{1945, 2018}};
        assertEquals(4, instance.getMostPopulationTimeLine(persons4));
    }
}
