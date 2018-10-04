package johnny.dsa.stack;

import java.util.Stack;

public class StackMergeSort {
    // Merge Sort
    public Stack<Integer> sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        // initialize stack1
        Stack<int[]> stack = new Stack<int[]>();
        for (int i = 0; i < nums.length; i++) {
            // convert number to number array
            stack.push(new int[]{nums[i]});
        }
        // stack2 contains the sorted sub arrays
        Stack<int[]> stack2 = new Stack<int[]>();

        while (stack.size() > 1) {
            while (stack.size() > 1) {
                int[] r = stack.pop();
                int[] l = stack.pop();
                int[] merged = merge(l, r);
                stack2.push(merged);
            }
            while (stack2.size() > 1) {
                int[] r = stack2.pop();
                int[] l = stack2.pop();
                int[] merged = merge(l, r);
                stack.push(merged);
            }
        }
        
        // odd case
        if (!stack.isEmpty() && !stack2.isEmpty()) {
            int[] r = stack.pop();
            int[] l = stack2.pop();
            int[] merged = merge(l, r);
            stack.push(merged);
        }
        
        int[] sorted = stack.isEmpty() ? stack2.pop() : stack.pop();
        
        Stack<Integer> finalStack = new Stack<>();
        for (int i : sorted) {
            finalStack.push(i);
        }
        
        return finalStack;
    }
    
    private int[] merge(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return nums2;
        }
        if (nums2 == null || nums2.length == 0) {
            return nums1;
        }
        
        int[] nums = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        for (int k = 0; k < nums.length; k++) {
            if (i >= nums1.length) {
                nums[k] = nums2[j];
                j++;
            } else if (j >= nums2.length) {
                nums[k] = nums1[i];
                i++;
            } else if (nums1[i] <= nums2[j]) {
                nums[k] = nums1[i];
                i++;
            } else {
                nums[k] = nums2[j];
                j++;
            }
        }
        
        return nums;
    }
}
