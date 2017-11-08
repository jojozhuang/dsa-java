package johnny.datastructure.common;

public class BSTNode {
    public int val;
    public BSTNode left, right;
    private int size = 0;

    public BSTNode(int value) {
        this.val = value;
        this.size = 1;
    }

    public void insert(int value) {

    }

    public BSTNode find(int value) {
        return null;
    }

    public int size() {
        return this.size;
    }
}
