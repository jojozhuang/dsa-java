package johnny.datastructure.segmenttree;

import johnny.datastructure.common.SegmentTreeNode;

public class SegmentTreeMax {
    public SegmentTreeNode buildMax(int[] arr) {
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
            root.max = arr[start];
            return root;
        }

        int mid = start + (end - start) / 2;
        root.left = buildHelpler(arr, start, mid);
        root.right = buildHelpler(arr, mid + 1, end);
        root.max = Math.max(root.left.max, root.right.max);
        return root;
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
}
