package johnny.datastructure.lfu;

import johnny.datastructure.common.BST;

/*
 * not possible to use max heap, as you can't get the minimum value within O(log(n))
 */
public class LFUBST {
    private BST bst;
    
    public LFUBST(int capacity) {
        this.bst = new BST(capacity);
    }
    
    public void add(int key, int value) {
        bst.add(0, key, value);
    }
    
    public int get(int key) {
        return bst.get(key);
    }
    
    // methods for testing
    public int[][] getAll() {
        return bst.getAll();
    }
}
