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
    
    public void add(int value) {
        bst.insert(0, value);
    }
    
    public int get(int value) {
        return bst.get(value);
    }
    
    // methods for testing
    public int[][] getAll() {
        return bst.getAll();
    }
}
