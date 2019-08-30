package johnny.dsa.monotonicqueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class FirstSmallerMonotonicQueue {
    // input:  [5, 3, 1, 2, 4]
    // output: [[-1,-1, -1, 1, 2], [3, 1, -1, -1, -1]]
    // O(n)
    public int[][] firstSmaller(int[] nums) {
        int[] leftSmaller = new int[nums.length];
        int[] rightSmaller = new int[nums.length];
        Arrays.fill(leftSmaller, -1);
        Arrays.fill(rightSmaller, -1);
        Deque<Integer> queue = new LinkedList<>(); // increasing queue
        for (int i = 0; i < nums.length; i++) {    // left to right
            while (!queue.isEmpty() && nums[queue.peekLast()] >= nums[i]) {
                rightSmaller[queue.pollLast()] = nums[i];
            }
            if (!queue.isEmpty()) {
                leftSmaller[i] = nums[queue.peekLast()];
            }
            queue.offerLast(i);
        }

        return new int[][]{leftSmaller, rightSmaller};
    }

    // input:  [5, 3, 1, 2, 4]
    // output: [[-1, 5, 3, 3, 5], [-1, 4, 2, 4, -1]]
    // O(n)
    public int[][] firstLarger(int[] nums) {
        int[] leftLarger = new int[nums.length];
        int[] rightLarger = new int[nums.length];
        Arrays.fill(leftLarger, -1);
        Arrays.fill(rightLarger, -1);
        Deque<Integer> queue = new LinkedList<>(); // decreasing queue
        for (int i = 0; i < nums.length; i++) {    // left to right
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                rightLarger[queue.pollLast()] = nums[i];
            }
            if (!queue.isEmpty()) {
                leftLarger[i] = nums[queue.peekLast()];
            }
            queue.offerLast(i);
        }

        return new int[][]{leftLarger, rightLarger};
    }
}
