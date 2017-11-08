package johnny.datastructure.segmenttree;

import johnny.datastructure.common.SegmentTreeNode;

public class SegmentTreeSum {
    public SegmentTreeNode buildSum(int[] arr) {
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
