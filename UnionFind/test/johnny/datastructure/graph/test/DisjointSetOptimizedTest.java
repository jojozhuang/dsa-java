package johnny.datastructure.graph.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.datastructure.graph.DisjointSet;
import johnny.datastructure.graph.DisjointSetOptimized;;

public class DisjointSetOptimizedTest {

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
    public void testUnionFind() {
        System.out.println("testUnionFind");
        DisjointSetOptimized djs = new DisjointSetOptimized(5); // parents = [0,1,2,3,4]
        // 0 is a friend of 2
        djs.union(0, 2); // parents = [2,1,2,3,4]
        // 4 is a friend of 2
        djs.union(4, 2); // parents = [2,1,2,3,2]
        // 3 is a friend of 1
        djs.union(3, 1); // parents = [2,1,2,1,2]
 
        // G1 = {0,2,4}
        // G2 = {1,3}
        // Check if 4 is a friend of 0
        assertEquals(djs.find(4), djs.find(0));
        // Check if 1 is a friend of 0
        assertNotEquals(djs.find(1), djs.find(0));
    }
    
    @Test
    public void testUnionByRank() {
        System.out.println("testUnionByRank");
        DisjointSet djs = new DisjointSet(5); // parents = [0,1,2,3,4]
        djs.union(0, 1); // parents = [1,1,2,3,4]
        djs.union(1, 2); // parents = [1,2,2,3,4]
        djs.union(2, 3); // parents = [1,2,3,3,4]
        
        // G1 = {0,1,2,3}
        // G2 = {4}
        // Check if 0 is a friend of 1
        assertEquals(djs.find(0), djs.find(1));
        // Check if 0 is a friend of 4
        assertNotEquals(djs.find(0), djs.find(4));

        DisjointSetOptimized djso = new DisjointSetOptimized(5); // parents = [0,1,2,3,4]
        djso.union(0, 1); // parents = [1,1,2,3,4]
        djso.union(1, 2); // parents = [1,1,1,3,4]
        djso.union(2, 3); // parents = [1,1,1,1,4]
 
        // G1 = {0,1,2,3}
        // G2 = {4}
        // Check if 0 is a friend of 1
        assertEquals(djso.find(0), djso.find(1));
        // Check if 0 is a friend of 4
        assertNotEquals(djso.find(0), djso.find(4));
    }
    
    @Test
    public void testPathCompression() {
        System.out.println("testPathCompression");

        DisjointSetOptimized djso = new DisjointSetOptimized(6); // parents = [0,1,2,3,4,5]
        djso.union(0, 5); // parents = [5,1,2,3,4,5]
        djso.union(4, 5); // parents = [5,1,2,3,5,5]
        djso.union(1, 3); // parents = [5,3,2,3,5,5]
        djso.union(2, 3); // parents = [5,3,3,3,5,5]
        djso.union(3, 4); // parents = [5,3,3,4,5,5]
        djso.find(3);     // parents = [5,3,3,5,5,5]
        // G1 = {0,1,2,3,4,5}
        System.out.println(Arrays.toString(djso.getParents()));
        assertArrayEquals(new int[] {5,3,3,5,5,5}, djso.getParents());
    }
}
