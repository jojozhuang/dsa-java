package johnny.datastructure.segmenttree.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.datastructure.common.SegmentTreeNode;
import johnny.datastructure.segmenttree.SegmentTree;

public class SegmentTreeTest {

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
    public void testBuild() {
        System.out.println("testBuild");
        SegmentTree instance = new SegmentTree(new int[]{4,-1,3,0,2});
        SegmentTreeNode result = instance.getRoot();
        assertEquals(0, result.start);
        assertEquals(4, result.end);
        assertEquals(-1, result.min);
        assertEquals(4, result.max);
        assertEquals(8, result.sum);
    }

    @Test
    public void testQueryMin() {
        System.out.println("queryMin");
        SegmentTree instance = new SegmentTree(new int[]{4,-1,3,0,2});
        assertEquals(-1, instance.queryMin(0, 4));
        assertEquals(0, instance.queryMin(2, 3));
        assertEquals(-1, instance.queryMin(0, 1));
        assertEquals(-1, instance.queryMin(1, 4));
    }

    @Test
    public void testQueryMax() {
        System.out.println("queryMax");
        SegmentTree instance = new SegmentTree(new int[]{4,-1,3,0,2});
        assertEquals(4, instance.queryMax(0, 4));
        assertEquals(3, instance.queryMax(2, 3));
        assertEquals(4, instance.queryMax(0, 1));
        assertEquals(3, instance.queryMax(1, 4));
    }

    @Test
    public void testQuerySum() {
        System.out.println("querySum");
        SegmentTree instance = new SegmentTree(new int[]{4,-1,3,0,2});
        assertEquals(8, instance.querySum(0, 4));
        assertEquals(3, instance.querySum(2, 3));
        assertEquals(3, instance.querySum(0, 1));
        assertEquals(4, instance.querySum(1, 4));
    }

}
