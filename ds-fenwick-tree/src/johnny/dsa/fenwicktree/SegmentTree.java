package johnny.dsa.fenwicktree;

public class SegmentTree {
    private SegmentTreeNode root;
    
    public SegmentTree(int[] arr) {
        this.root = build(arr, 0, arr.length - 1);
    }

    private SegmentTreeNode build(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end) {
            root.sum = arr[start];
            return root;
        }

        int mid = start + (end - start) / 2;
        root.left = build(arr, start, mid);
        root.right = build(arr, mid + 1, end);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }

    public int prefixSum(int index) {
        return querySum(this.root, 0, index);
    }

    public int rangeSum(int start, int end) {
        return querySum(this.root, start, end);
    }

    public int querySum(SegmentTreeNode root, int start, int end) {
        if (root == null) {
            return 0;
        }

        // case 1: search range is same with the range of root node
        if (root.start == start && root.end == end) {
            return root.sum;
        }

        int mid = root.start + (root.end - root.start) / 2;
        if (end <= mid) {
            // case 2: search range is in the range of left child node
            return querySum(root.left, start, end);
        } else if (start > mid) {
            // case 3: search range is in the range of right child node
            return querySum(root.right, start, end);
        } else {
            //case 4: search range crosses both left and right children
            int leftsum = querySum(root.left, start, mid);
            int rightsum = querySum(root.right, mid + 1, end);
            return leftsum + rightsum;
        }
    }
    
    public void update(int index, int value) {
        update(this.root, index, value);
    }
    
    private void update(SegmentTreeNode root, int index, int value) {
        if (root == null) {
            return;
        }

        if (root.start == root.end && root.start == index) {
            root.sum = value;
            return;
        }

        int mid = root.start + (root.end - root.start) / 2;
        if (index <= mid) {
            update(root.left, index, value);
        } else {
            update(root.right, index, value);
        }

        root.sum = root.left.sum + root.right.sum;
    }

    class SegmentTreeNode {
        public int start, end;
        public int sum;
        public SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
        }
    }
}
