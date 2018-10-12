package johnny.dsa.scanline.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.dsa.common.ListUtil;
import johnny.dsa.scanline.Skyline;;

public class SkylineTest {

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
    public void testGetSkyline() {
    	System.out.println("getSkyline");
    	Skyline instance = new Skyline();

        List<int[]> expResult = new ArrayList<int[]>();
        List<int[]> result = instance.getSkyline(null);
        assertEquals(expResult, result);

        int[][] buildings2 = new int[][] {
            {2, 9, 10},
            {3, 7, 15},
            {5, 12, 12},
            {15, 20, 10},
            {19, 24, 8}
        };

        List<int[]> expect2 = ListUtil.buildList2(new int[][] {
            {2, 10},{3, 15},{7, 12},{12, 0},{15, 10},{20, 8},{24, 0}
        });
        List<int[]> result2 = instance.getSkyline(buildings2);
        assertArrayEquals(expect2.toArray(), result2.toArray());

        int[][] buildings3 = new int[][] {
            {0, 2, 3},
            {2, 5, 3}
        };
        List<int[]> expect3 = ListUtil.buildList2(new int[][] {{0,3},{5,0}});
        List<int[]> result3 = instance.getSkyline(buildings3);
        assertArrayEquals(expect3.toArray(), result3.toArray());

        int[][] buildings4 = new int[][] {
            {1, 2, 1},
            {1, 2, 2},
            {1, 2, 3}
        };
        List<int[]> expect4 = ListUtil.buildList2(new int[][] {{1,3},{2,0}});
        List<int[]> result4 = instance.getSkyline(buildings4);
        assertArrayEquals(expect4.toArray(), result4.toArray());
        
        int[][] buildings5 = new int[][] {
            {1, 5, 10},
            {6, 20, 6},
            {8, 12, 8},
            {10, 16, 14},
            {18, 26, 7}
        };

        List<int[]> expect5 = ListUtil.buildList2(new int[][] {
            {1, 10},{5, 0},{6, 6},{8, 8},{10, 14},{16, 6},{18, 7},{26, 0}
        });
        List<int[]> result5 = instance.getSkyline(buildings5);
        assertArrayEquals(expect5.toArray(), result5.toArray());
    }
    
}
