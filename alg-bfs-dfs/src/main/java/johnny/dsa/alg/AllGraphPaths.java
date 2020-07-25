package johnny.dsa.alg;

/*
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.
 *
 * The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.
 *
 * Example:
 *
 * Input: [[1,2], [3], [3], []]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: The graph looks like this:
 * 0--->1
 * |    |
 * v    v
 * 2--->3
 *
 * There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllGraphPaths {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(graph, 0, list, ans);

        return ans;
    }

    private void dfs(int[][] graph, int node, List<Integer> list, List<List<Integer>> ans) {
        if (node == graph.length - 1) {
            ans.add(new ArrayList<>(list));
        }

        for (int nei : graph[node]) {
            list.add(nei);
            dfs(graph, nei, list, ans);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        if (graph == null || graph.length == 0 || graph[0].length == 0) {
            return ans;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            map.put(i, new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++) {
                map.get(i).add(graph[i][j]);
            }
        }

        List<Integer> list = new ArrayList();
        list.add(0);
        dfs(map, 0, graph.length, list, ans);

        return ans;
    }

    private void dfs(Map<Integer, List<Integer>> map, int start, int n, List<Integer> list, List<List<Integer>> ans) {
        if (start == n - 1) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int next : map.get(start)) {
            list.add(next);
            dfs(map, next, n, list, ans);
            list.remove(list.size() - 1);
        }
    }
}
