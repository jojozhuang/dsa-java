package johnny.datastructure.segmenttree;

import johnny.datastructure.common.SegmentTreeNode;

public class SegmentTreeAll {
    public SegmentTreeNode build(int[] arr) {
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

    /**
     * @param root
     * @param start
     * @param end
     * @return
     */
    public int queryMin(SegmentTreeNode root, int start, int end) {
        if (root == null) {
            return 0;
        }

        if (root.start == start && root.end == end) {
            return root.min;
        }

        int mid = root.start + (root.end - root.start) / 2;
        int leftmin = Integer.MAX_VALUE;
        int rightmin = Integer.MAX_VALUE;
        if (start <= mid) {
            if (mid < end) {
                leftmin = queryMin(root.left, start, mid);
            } else {
                leftmin = queryMin(root.left, start, end);
            }
        }
        if (mid < end) {
            if (start <= mid) {
                rightmin = queryMin(root.right, mid + 1, end);
            } else {
                rightmin = queryMin(root.right, start, end);
            }
        }

        return Math.min(leftmin, rightmin);
    }

    public int queryMax(SegmentTreeNode root, int start, int end) {
        if (root == null) {
            return 0;
        }

        if (root.start == start && root.end == end) {
            return root.max;
        }

        int mid = root.start + (root.end - root.start) / 2;
        int leftmax = Integer.MIN_VALUE;
        int rightmax = Integer.MIN_VALUE;
        if (start <= mid) {
            if (mid < end) {
                leftmax = queryMax(root.left, start, mid);
            } else {
                leftmax = queryMax(root.left, start, end);
            }
        }
        if (mid < end) {
            if (start <= mid) {
                rightmax = queryMax(root.right, mid + 1, end);
            } else {
                rightmax = queryMax(root.right, start, end);
            }
        }

        return Math.max(leftmax, rightmax);
    }
    
    public int querySum(SegmentTreeNode root, int start, int end) {
        if (root == null) {
            return 0;
        }

        if (root.start == start && root.end == end) {
            return root.sum;
        }

        int mid = root.start + (root.end - root.start) / 2;
        int leftsum = 0;
        int rightsum = 0;
        if (start <= mid) {
            if (mid < end) {
                leftsum = querySum(root.left, start, mid);
            } else {
                leftsum = querySum(root.left, start, end);
            }
        }
        if (mid < end) {
            if (start <= mid) {
                rightsum = querySum(root.right, mid + 1, end);
            } else {
                rightsum = querySum(root.right, start, end);
            }
        }

        return leftsum + rightsum;
    }
}
