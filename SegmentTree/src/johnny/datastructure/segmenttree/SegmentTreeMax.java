package johnny.datastructure.segmenttree;

import johnny.datastructure.common.SegmentTreeNode;

public class SegmentTreeMax {
    /**
     * @param arr, array of integer
     * @return root node of the maximum segment tree
     */
    public SegmentTreeNode buildMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        return buildMaxHelpler(arr, 0, arr.length - 1);
    }

    /**
     * @param arr, array of integer
     * @param start, first index of the array
     * @param end, last index of the array
     * @return root node of the maximum segment tree
     */
    private SegmentTreeNode buildMaxHelpler(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end) {
            root.max = arr[start];
            return root;
        }

        int mid = start + (end - start) / 2;
        root.left = buildMaxHelpler(arr, start, mid);
        root.right = buildMaxHelpler(arr, mid + 1, end);
        root.max = Math.max(root.left.max, root.right.max);
        return root;
    }

    /**
     * @param root, root node of the segment tree
     * @param start, start of the search range
     * @param end, end of the search range
     * @return the maximum value of the given range
     */
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
}
