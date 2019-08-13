package johnny.dsa.skiplist;

public class SkipNode {
    public int val;

    public SkipNode left;
    public SkipNode right;
    public SkipNode up;
    public SkipNode down;

    public SkipNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.up = null;
        this.down = null;
    }

    public SkipNode(SkipNode lowerLevelNode) {
        this.val = lowerLevelNode.val;
        this.left = null;
        this.right = null;
        this.up = null;
        this.down = lowerLevelNode;
    }
}
