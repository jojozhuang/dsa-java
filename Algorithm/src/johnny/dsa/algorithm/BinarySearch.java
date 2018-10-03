package johnny.dsa.algorithm;

/*
 * Given a sorted (in ascending order) integer array nums of n elements and a target value, 
 * search target in nums. If target exists, then return its index, otherwise return -1.
 */

public class BinarySearch {
    // recursive implementation
    public int searchRecursive(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        return recursiveHelper(nums, 0, nums.length - 1, target);
    }
    
    private int recursiveHelper(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        
        int mid = start + (end - start) / 2; // avoid overflow of (start + end) / 2
        if (nums[mid] == target) {
            // found
            return mid;
        } else if (nums[mid] < target) {
            // search in the right half
            return recursiveHelper(nums, mid + 1, end, target);
        } else {
            // search in the left half
            return recursiveHelper(nums, start, mid - 1, target);
        }
    }
    
    // iterative implementation
    public int searchIterative(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
    
        while (start <= end) {
            int mid = start + (end - start) / 2; // avoid overflow of (start + end) / 2
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return -1;
    }
    
    // binary search template, can be applied to most of the binary search problems
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
    
        while (start + 1 < end) { // avoid infinite loop, need to check nums[start] and nums[end] after the while loop
            int mid = start + (end - start) / 2; // avoid overflow of (start + end) / 2
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid; // no need +1
            } else {
                end = mid;   // no need -1
            }
        }
        
        // need to check the start and end
        if (nums[start] == target) {
            return start;
        }
        
        if (nums[end] == target) {
            return end;
        }
        
        return -1;
    }
}
