package johnny.dsa.alg;

import java.util.Arrays;

/**
 * Longest Increasing Subsequence
 * Given a sequence of integers, find the longest increasing subsequence (LIS).
 * You code should return the length of the LIS.
 *
 * Example 1:
 *  Input:  [5,4,1,2,3]
 *  Output:  3
 *  Explanation:
 *    LIS is [1,2,3]
 *
 * Example 2:
 *  Input: [4,2,4,5,3,7]
 *  Output:  4
 *
 *  Explanation:
 *    LIS is [2,4,5,7]
 *
 */
public class LongestIncreasingSubsequence {
    // O(n^2)
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // dp[i], the longest length of LIS which ends at index i.
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) { // check 0~i
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            //System.out.println(Arrays.toString(dp));
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    // O(n^2)
    public int longestIncreasingSubsequence2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // dp[i], the longest length of LIS which ends at index i.
        int[] dp = new int[nums.length];
        int max = 0;
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Math.max(1, dp[i]);
            for (int j = i + 1; j < nums.length; j++) { // check i ~ end
                if (nums[j] > nums[i]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            //System.out.println(Arrays.toString(dp));
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    // O(nlog(n))
    // https://www.youtube.com/watch?v=5rfZ4WnNKBk
    public int longestIncreasingSubsequence3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] arr = new int[nums.length]; // increasing array
        // 10,9,2,5,3,7,101,18 -> 2,3,7,18
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = Arrays.binarySearch(arr, 0, len, nums[i]);
            if (index < 0) {
                index = -(index + 1);
            }

            arr[index] = nums[i];
            if (index == len) {
                len++;
            }
            System.out.println(Arrays.toString(arr));
        }

        return len;
    }


}
