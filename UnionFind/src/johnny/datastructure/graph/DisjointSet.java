package johnny.datastructure.graph;

public class DisjointSet {
    private int[] parents;
    
    public DisjointSet(int size)
    {
        parents = new int[size];
        for (int i = 0; i < parents.length; i++) {
            // Initially, all elements are in their own set.
            parents[i] = i;
        }
    }
 
    // find
    public int find(int i) {
        if (parents[i] == i) {
            // i is the representative of this set
            return i;
        } else {
            // If i is not the parent of itself, then i is not the representative of this set. So we 
            // recursively call find() on its parent
            return find(parents[i]);
        }
    }
    
    public int find2(int i) {
        while (parents[i] != i) {
            parents[i] = parents[parents[i]];
            i = parents[i];
        }
        return parents[i];
    }

    // union
    public void union(int i, int j) {
        int root1 = find(i);
        int root2 = find(j);
        parents[root1] = root2;
    }
}
