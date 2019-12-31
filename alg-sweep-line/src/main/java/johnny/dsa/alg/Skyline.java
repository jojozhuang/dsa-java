package johnny.dsa.alg;

import java.util.*;

public class Skyline {
    // height map
    // time: O(n*r), n is the number of buildings, r is the width of building.
    // space: O(w), w is buildings' maximum width
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return res;
        }
        
        // find maximum position
        int max = Integer.MIN_VALUE;
        for (int[] building : buildings) {
            max = Math.max(max, building[1]);
        }
        
        // create height map
        int[] heights = new int[max + 1]; // the last point has zero height 
        
        // update height map with the maximum height
        for (int[] building : buildings) {
            for (int i = building[0]; i < building[1]; i++) {
                heights[i] = Math.max(heights[i], building[2]);
            }
        }
        
        // build result with inflexion
        for (int i = 0; i < heights.length; i++) {
            if ((i == 0 && heights[i] != 0) || (i > 0 && heights[i] != heights[i - 1])) {
                res.add(new int[] {i, heights[i]});
            }
        }
        
        return res;
    }

    //  time line
    public List<int[]> getSkyline2(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return res;
        }
        List<int[]> height = new ArrayList<>();
        for(int[] b:buildings) {
            // start point has negative height value
            height.add(new int[]{b[0], -b[2]});
            // end point has normal height value
            height.add(new int[]{b[1], b[2]}); 
        }

        // sort $height, based on the first value, if necessary, use the second to
        // break ties
        Collections.sort(height, (a, b) -> {
                if(a[0] != b[0]) 
                    return a[0] - b[0];
                return a[1] - b[1];
        });

        // Use a maxHeap to store possible heights
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        // Provide a initial value to make it more consistent
        pq.offer(0);

        // Before starting, the previous max height is 0;
        int prev = 0;

        // visit all points in order
        for (int[] h:height) {
            if(h[1] < 0) { // a start point, add height
                pq.offer(-h[1]);
            } else {  // a end point, remove height
                pq.remove(h[1]);
            }
            int cur = pq.peek(); // current max height;
      
            // compare current max height with previous max height, update result and 
            // previous max height if necessary
            if(prev != cur) {
                res.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return res;
    }
}
