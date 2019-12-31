package johnny.dsa.alg;

public class SegmentTreeSum {
    private SegmentTreeNode root;
    
    public SegmentTreeSum(int[] arr) {
        this.root = build(arr);
    }
    
    public SegmentTreeNode getRoot() {
        return this.root;
    }
    
    private SegmentTreeNode build(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        return buildHelpler(arr, 0, arr.length - 1);
    }

    private SegmentTreeNode buildHelpler(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end) {
            root.sum = arr[start];
            return root;
        }

        int mid = start + (end - start) / 2;
        root.left = buildHelpler(arr, start, mid);
        root.right = buildHelpler(arr, mid + 1, end);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }

    public int querySum(int start, int end) {
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
    
    public void modify(int index, int value) {
        modify(this.root, index, value);
    }
    
    private void modify(SegmentTreeNode root, int index, int value) {
        if (root == null) {
            return;
        }

        if (root.start == root.end && root.start == index) {
            root.sum = value;
            return;
        }

        int mid = root.start + (root.end - root.start) / 2;
        if (index <= mid) {
            modify(root.left, index, value);
        } else {
            modify(root.right, index, value);
        }

        root.sum = root.left.sum + root.right.sum;
    }
}
