package johnny.datastructure.segmenttree;

import johnny.datastructure.common.SegmentTreeNode;

public class SegmentTreeMin {
    /**
     * @param arr, 
     * @return
     */
    public SegmentTreeNode buildMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        return buildMinHelpler(arr, 0, arr.length - 1);
    }

    private SegmentTreeNode buildMinHelpler(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end) {
            root.min = arr[start];
            return root;
        }

        int mid = start + (end - start) / 2;
        root.left = buildMinHelpler(arr, start, mid);
        root.right = buildMinHelpler(arr, mid + 1, end);
        root.min = Math.min(root.left.min, root.right.min);
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
}
