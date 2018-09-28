package johnny.datastructure.graph;

public class DisjointSetOptimized {
    public int[] parents;
    public int[] rank;
    
    public DisjointSetOptimized(int size)
    {
        parents = new int[size];
        rank = new int[size];
        for (int i = 0; i < parents.length; i++) {
            // Initially, all elements are in their own set.
            parents[i] = i;
        }
    }

    // Path Compression
    public int find(int i) {
        if (parents[i] == i) {
            // Then i is the representative of this set
            return i;
        } else {
            // Recursively find the representative.
            int result = find(parents[i]);

            // Change the parent during traversal
            parents[i] = result;

            // Return the result
            return result;
        }
    }

    // Union by rank
    public void union(int i, int j) {
        int root1 = find(i);
        int root2 = find(j);
        if (root1 == root2) {
            return;
        }
        
        // If root1’s rank is less than root2’s rank
        if (rank[root1] < rank[root2]) {
            // Then move root1 under root2
            parents[root1] = root2;
        // If root1’s rank is larger than root2’s rank
        } else if (rank[root1] > rank[root2]) {
            // Then move root2 under root1
            parents[root2] = root1;
        // if ranks are the same 
        } else { 
            // Then move root1 under root2 (doesn't matter which one goes where) 
            parents[root1] = root2;
            rank[root2]++;
        }
    }
}
