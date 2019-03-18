package johnny.dsa.unionfind;

public class DSURank { // Disjoint Set Union with Rank
    public int[] parents;
    public int[] rank;
    
    public DSURank(int size) {
        parents = new int[size];
        for (int i = 0; i < parents.length; i++) {
            // Initially, all elements are in their own set.
            parents[i] = i;
        }
        rank = new int[size];
    }

    // Path Compression
    public int find(int i) {
        /*if (parents[i] != i) {
            parents[i] = find(parents[i]);
        }
        return parents[i];
        */

        // without recursion
        while (parents[i] != i) {
            parents[i] = parents[parents[i]];
            i = parents[i];
        }
        return parents[i];
    }

    // Union by rank
    public void union(int i, int j) {
        int p1 = find(i);
        int p2 = find(j);
        if (p1 == p2) {
            return;
        }
        
        // If root1’s rank is less than root2’s rank
        if (rank[p1] < rank[p2]) {
            // Then move root1 under root2
            parents[p1] = p2;
        // If root1’s rank is larger than root2’s rank
        } else if (rank[p1] > rank[p2]) {
            // Then move root2 under root1
            parents[p2] = p1;
        // if ranks are the same 
        } else { 
            // Then move root1 under root2 (doesn't matter which one goes where) 
            parents[p1] = p2;
            rank[p2]++;
        }
    }
}
