package johnny.dsa.common;

public class SegmentTreeNode {
    public int start, end;
    public int max, min, sum; // You can add additional attributes
    public SegmentTreeNode left, right;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = null;
        this.right = null;
    }
}
