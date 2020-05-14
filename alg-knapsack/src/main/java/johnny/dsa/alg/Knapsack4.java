package johnny.dsa.alg;

import java.util.Arrays;

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
    public int knapsack41(int[] A, int m) {
        // number of ways to full fill every capacity
        int[][] dp = new int[A.length + 1][m + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                int k = 0;
                while (j - A[i-1]*k >= 0) {
                    dp[i][j] += dp[i-1][j - A[i-1]*k];
                    k+=1;
                }
            }
        }
        return dp[A.length][m];
    }

    public int knapsack42(int[] A, int m) {
        // number of ways to full fill every capacity
        int[] dp = new int[m + 1];

        dp[0] = 1;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                if (j - A[i - 1] >= 0) {
                    dp[j] += dp[j - A[i - 1]];
                }
            }
            //System.out.println(Arrays.toString(dp));
        }

        return dp[m];
    }

    public int knapsack43(int[] A, int m) {
        // number of ways to full fill every capacity
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int i = 0; i < A.length; i++) {
            for (int j = A[i]; j <= m; j++) {
                dp[j] += dp[j - A[i]];
            }
        }

        return dp[m];
    }
}
