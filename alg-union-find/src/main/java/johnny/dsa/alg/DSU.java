package johnny.dsa.alg;

public class DSU { // Disjoint Set Union
    public int[] parents;
    
    public DSU(int size) {
        parents = new int[size];
        for (int i = 0; i < parents.length; i++) {
            // Initially, all elements are in their own set.
            parents[i] = i;
        }
    }
 
    // find
    public int find(int i) {
        if (parents[i] != i) {
            return find(parents[i]);
        }
        return parents[i];
    }

    // union
    public void union(int i, int j) {
        int p1 = find(i);
        int p2 = find(j);
        parents[p1] = p2;
    }
}
