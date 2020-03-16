package johnny.dsa.alg;

/**
 * Backpack V
 *
 * Given n items with size nums[i] which an integer array and all positive numbers. An integer target denotes the
 * size of a backpack. Find the number of possible fill the backpack.
 *
 * Each item may only be used once.
 *
 * Example:
 * Input: nums = [1,2,3,3,7] and target 7.
 * Output: 2
 * Explanation:
 * A solution set is:
 * [7]
 * [1, 3, 3]
 *
 * https://www.lintcode.com/problem/backpack-v/
 */
public class Knapsack5 {
    public int knapsack(int[] nums, int target) {
        // dp[i]表示当前和为i的解法个数，然后迭代更新即可
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = target; j >= nums[i]; --j) {
                f[j] += f[j - nums[i]];
            }
        }

        return f[target];
    }
}
