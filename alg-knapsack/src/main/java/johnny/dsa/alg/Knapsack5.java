package johnny.dsa.alg;

import java.util.Arrays;

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
    public int knapsack51(int[] A, int m) {
        // number of ways to full fill every capacity
        int[][] dp = new int[A.length + 1][m + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - A[i - 1] >= 0) {
                    dp[i][j] += dp[i - 1][j - A[i - 1]];
                }
            }
            //System.out.println(Arrays.toString(dp[i]));
        }
        return dp[A.length][m];
    }

    public int knapsack52(int[] A, int m) {
        // number of ways to full fill every capacity
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int i = 1; i <= A.length; i++) {
            for (int j = m; j >= 0; j--) {
                if (j - A[i - 1] >= 0) {
                    dp[j] += dp[j - A[i - 1]];
                }
            }
            //System.out.println(Arrays.toString(dp));
        }

        return dp[m];
    }

    public int knapsack53(int[] A, int m) {
        // number of ways to full fill every capacity
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int i = 0; i < A.length; i++) {
            for (int j = m; j >= A[i]; j--) {
                dp[j] += dp[j - A[i]];
            }
            //System.out.println(Arrays.toString(dp));
        }

        return dp[m];
    }
}
