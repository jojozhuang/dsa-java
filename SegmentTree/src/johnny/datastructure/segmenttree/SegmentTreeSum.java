package johnny.datastructure.segmenttree;

import johnny.datastructure.common.SegmentTreeNode;

public class SegmentTreeSum {
    /**
     * @param arr, array of integer
     * @return root node of the sum segment tree
     */
    public SegmentTreeNode buildSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        return buildSumHelpler(arr, 0, arr.length - 1);
    }

    /**
     * @param arr, array of integer
     * @param start, first index of the array
     * @param end, last index of the array
     * @return root node of the sum segment tree
     */
    private SegmentTreeNode buildSumHelpler(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end) {
            root.sum = arr[start];
            return root;
        }

        int mid = start + (end - start) / 2;
        root.left = buildSumHelpler(arr, start, mid);
        root.right = buildSumHelpler(arr, mid + 1, end);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }

    /**
     * @param root, root node of the segment tree
     * @param start, start of the search range
     * @param end, end of the search range
     * @return the sum of the given range
     */
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
