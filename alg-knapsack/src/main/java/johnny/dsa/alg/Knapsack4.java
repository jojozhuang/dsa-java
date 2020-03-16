package johnny.dsa.alg;

/**
 * Backpack IV
 *
 * Given an integer array nums[] which contains n unique positive numbers, num[i] indicate the size of ith item.
 * An integer target denotes the size of backpack. Find the number of ways to fill the backpack.
 *
 * Each item may be chosen unlimited number of times.
 *
 * Examples:
 *
 * Example1:
 * Input: nums = [2,3,6,7] and target = 7
 * Output: 2
 * Explanation:
 * Solution sets are:
 * [7]
 * [2, 2, 3]
 *
 * Example2:
 * Input: nums = [2,3,4,5] and target = 7
 * Output: 3
 * Explanation:
 * Solution sets are:
 * [2, 5]
 * [3, 4]
 * [2, 2, 3]
 *
 * https://www.lintcode.com/problem/backpack-iv/
 */
public class Knapsack4 {
    public int knapsack(int[] nums, int target) {
        int m = target;
        int []A = nums;
        int f[][] = new int[A.length + 1][m + 1];

        f[0][0] = 1;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                int k = 0;
                while(k * A[i-1] <= j) {
                    f[i][j] += f[i-1][j-A[i-1]*k];
                    k+=1;
                }
            } // for j
        } // for i
        return f[A.length][target];
    }
    public int knapsack2(int[] nums, int target) {
        // Write your code here
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 0; i < nums.length; ++i)
            for (int  j = nums[i]; j <= target; ++j)
                f[j] += f[j - nums[i]];

        return f[target];
    }
}
