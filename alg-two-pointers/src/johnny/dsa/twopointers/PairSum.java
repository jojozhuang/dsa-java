package johnny.dsa.twopointers;

/*
 * Given a sorted (in ascending order) integer array nums of n elements and a target value, 
 * find if there exists any pair of elements (nums[i], nums[j], i!=j) such that their sum is equal to target.
 */

public class PairSum {
    // naive solution, O(n^2)
    public boolean isPairSumNaive(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        for (int i = 0; i < nums.length; i++) { 
            for (int j = i + 1; j <  nums.length; j++) { 
                if (nums[i] + nums[j] == target) {
                    return true; // pair exists 
                }
       
                if (nums[i] + nums[j] > target) 
                    break; // break inner loop as the array is sorted 
            } 
        } 
       
        // not found
        return false; 
    }
    
    // Two pointers, O(n)
    public boolean isPairSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
    
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                return true; // pair exists 
            } else if (sum < target) {
                start++; // move start forward to get larger value
            } else {
                end--; // move end backward to get smaller value
            }
        }
        
        // not found
        return false;
    }
}
