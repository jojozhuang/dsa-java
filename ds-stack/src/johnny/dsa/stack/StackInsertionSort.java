package johnny.dsa.stack;

import java.util.Stack;

public class StackInsertionSort {
    // Insertion Sort
    public Stack<Integer> sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        // initialize stack1
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < nums.length; i++) {
            stack.push(nums[i]);
        }
        // stack2 contains the sorted items
        Stack<Integer> stack2 = new Stack<Integer>();

        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (stack2.isEmpty()) {
                stack2.push(top);
                continue;
            }
            while (!stack2.isEmpty() && stack2.peek() > top) {
                stack.push(stack2.pop());
            }
            stack2.push(top);
        }

        return stack2;
    }
}
