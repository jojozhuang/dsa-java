package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AllGraphPathsTest {

    @Test
    public void testAllPathsSourceTarget() {
        System.out.println("testAllPathsSourceTarget");
        AllGraphPaths instance = new AllGraphPaths();

        int[][] graph1 = new int[][]{{1,2}, {3}, {3}, {}};
        Integer[][] arr1 = new Integer[][]{{0,1,3},{0,2,3}};
        List<List<Integer>> expect1 = ListUtil.buildList2(arr1);
        assertEquals(expect1, instance.allPathsSourceTarget(graph1));
    }

}