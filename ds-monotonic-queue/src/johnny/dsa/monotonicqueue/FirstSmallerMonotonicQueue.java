package johnny.dsa.monotonicqueue;

import java.util.Stack;

public class FirstSmallerMonotonicQueue {
    // input:  [ 5, 3,  1, 2, 4]
    // output: [-1,-1, -1, 1, 2]
    // O(n)
    public int[] firstSmallerLeft(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>(); // increasing stack
        for (int i = 0; i < nums.length; i++) { // left to right
            while (!stack.isEmpty()) {
                if (stack.peek() >= nums[i]) {
                    stack.pop();
                } else {
                    break;
                }
            }
            if (stack.isEmpty()) {
                stack.push(nums[i]);
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
                stack.push(nums[i]);
            }
        }

        return ans;
    }

    // input:  [5, 3,  1,  2,  4]
    // output: [3, 1, -1, -1, -1]
    // O(n)
    public int[] firstSmallerRight(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>(); // increasing stack
        for (int i = nums.length - 1; i >= 0; i--) { // right to left
            while (!stack.isEmpty()) {
                if (stack.peek() >= nums[i]) {
                    stack.pop();
                } else {
                    break;
                }
            }
            if (stack.isEmpty()) {
                stack.push(nums[i]);
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
                stack.push(nums[i]);
            }
        }

        return ans;
    }
}
