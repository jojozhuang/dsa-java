package johnny.dsa.sqrtdecomposition.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import johnny.dsa.sqrtdecomposition.SegmentTreeSum;;

public class SegmentTreeSumTest {

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
    public void testQuerySum() {
        System.out.println("querySum");
        SegmentTreeSum st = new SegmentTreeSum(new int[]{3,5,1,5,6,10,4,2,8});
        assertEquals(8, st.querySum(0, 1));
        assertEquals(9, st.querySum(0, 2));
        assertEquals(21, st.querySum(3, 5));
        assertEquals(14, st.querySum(6, 8));
        assertEquals(27, st.querySum(3, 7));
        assertEquals(28, st.querySum(2, 7));
        assertEquals(44, st.querySum(0, 8));
        st.modify(2, 7); // {3,5,7,5,6,10,4,2,8}
        assertEquals(15, st.querySum(0, 2));
        assertEquals(34, st.querySum(2, 7));
        assertEquals(6, st.querySum(6, 7));
        assertEquals(10, st.querySum(7, 8));
        st.modify(7, 12); // {3,5,7,5,6,10,4,12,8}
        assertEquals(16, st.querySum(6, 7));
        assertEquals(20, st.querySum(7, 8));
        assertEquals(60, st.querySum(0, 8));
    }
}
