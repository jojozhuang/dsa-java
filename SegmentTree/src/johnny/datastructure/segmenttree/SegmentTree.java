package johnny.datastructure.segmenttree;

import johnny.datastructure.common.SegmentTreeNode;

public class SegmentTree {
    private SegmentTreeNode root;
    
    public SegmentTree(int[] arr) {
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
            root.min = arr[start];
            root.max = arr[start];
            root.sum = arr[start];
            return root;
        }

        int mid = start + (end - start) / 2;
        root.left = buildHelpler(arr, start, mid);
        root.right = buildHelpler(arr, mid + 1, end);
        root.min = Math.min(root.left.min, root.right.min);
        root.max = Math.max(root.left.max, root.right.max);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }

    public int queryMin(int start, int end) {
        return queryMin(this.root, start, end);
    }
    
    private int queryMin(SegmentTreeNode root, int start, int end) {
        if (root == null) {
            return 0;
        }

        // case 1: search range is same with the range of root node
        if (root.start == start && root.end == end) {
            return root.min;
        }

        int mid = root.start + (root.end - root.start) / 2;
        if (end <= mid) {
            // case 2: search range is in the range of left child node
            return queryMin(root.left, start, end);
        } else if (start > mid) {
            // case 3: search range is in the range of right child node
            return queryMin(root.right, start, end);
        } else {
            //case 4: search range crosses both left and right children
            int leftmin = queryMin(root.left, start, mid);
            int rightmin = queryMin(root.right, mid + 1, end);
            return Math.min(leftmin, rightmin);
        }
    }

    public int queryMax(int start, int end) {
        return queryMax(this.root, start, end);
    }
    
    public int queryMax(SegmentTreeNode root, int start, int end) {
        if (root == null) {
            return 0;
        }

        // case 1: search range is same with the range of root node
        if (root.start == start && root.end == end) {
            return root.max;
        }

        int mid = root.start + (root.end - root.start) / 2;
        if (end <= mid) {
            // case 2: search range is in the range of left child node
            return queryMax(root.left, start, end);
        } else if (start > mid) {
            // case 3: search range is in the range of right child node
            return queryMax(root.right, start, end);
        } else {
            //case 4: search range crosses both left and right children
            int leftmax = queryMax(root.left, start, mid);
            int rightmax = queryMax(root.right, mid + 1, end);
            return Math.max(leftmax, rightmax);
        }
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
            root.min = value;
            root.max = value;
            root.sum = value;
            return;
        }

        int mid = root.start + (root.end - root.start) / 2;
        if (index <= mid) {
            modify(root.left, index, value);
        } else {
            modify(root.right, index, value);
        }

        root.min = Math.min(root.left.min, root.right.min);
        root.max = Math.max(root.left.max, root.right.max);
        root.sum = root.left.sum + root.right.sum;
    }
}
