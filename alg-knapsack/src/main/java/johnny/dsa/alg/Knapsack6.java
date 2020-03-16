package johnny.dsa.alg;

/**
 * Backpack VI
 *
 * Given an integer array nums with all positive numbers and no duplicates, find the number of possible combinations
 * that add up to a positive integer target.
 *
 * A number in the array can be used multiple times in the combination.
 * Different orders are counted as different combinations.
 *
 * Example:
 * Example1:
 * Input: nums = [1, 2, 4], and target = 4
 * Output: 6
 * Explanation:
 * The possible combination ways are:
 * [1, 1, 1, 1]
 * [1, 1, 2]
 * [1, 2, 1]
 * [2, 1, 1]
 * [2, 2]
 * [4]
 *
 * Example2:
 * Input: nums = [1, 2], and target = 4
 * Output: 5
 * Explanation:
 * The possible combination ways are:
 * [1, 1, 1, 1]
 * [1, 1, 2]
 * [1, 2, 1]
 * [2, 1, 1]
 * [2, 2]
 *
 * https://www.lintcode.com/problem/combination-sum-iv/
 */
public class Knapsack6 {
    public int knapsack(int[] nums, int target) {
        int n = nums.length;
        int[] f = new int[target + 1];

        f[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < n; j++) {
                if (i - nums[j] >= 0) {
                    f[i] += f[i - nums[j]];
                }
            }
        }
        return f[target];
    }
}
