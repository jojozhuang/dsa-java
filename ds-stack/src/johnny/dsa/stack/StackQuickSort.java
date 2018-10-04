package johnny.dsa.stack;

import java.util.Stack;

public class StackQuickSort {
    public Stack<Integer> sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        quickHelper(nums, 0, nums.length - 1);
        
        Stack<Integer> finalStack = new Stack<>();
        for (int i : nums) {
            finalStack.push(i);
        }
        
        return finalStack;
    }
    
    private void quickHelper(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        
        /*int pivot = partition(nums, start, end);
        quickHelper(nums, start, pivot - 1);
        quickHelper(nums, pivot + 1, end);*/
        
        // use stack to implement the recursion(implicit stack).
        Stack<int[]> stack = new Stack<int[]>();
        stack.push(new int[] {0, end});
        while (!stack.isEmpty()) {
            while (start <= end) {
                int pivot = partition(nums, start, end);
                stack.push(new int[] {pivot + 1, end}); // execute second recursive call
                end = pivot - 1;  // execute first recursive call
            }
            int[] next = stack.pop();  // fetch next recursive call to execute
            start = next[0];
            end = next[1];
        }
    }   
    
    // one way
    private int partition(int[] nums, int start, int end) {
        int pivot = start; // select the first as the pivot
        
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < nums[start]) {
                pivot++;
                int temp = nums[pivot];
                nums[pivot] = nums[i];
                nums[i] = temp;
            }
        }
        
        int temp = nums[pivot];
        nums[pivot] = nums[start];
        nums[start] = temp;
        return pivot;
    }
}
