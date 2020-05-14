package johnny.dsa.alg;

import java.util.Arrays;

/**
 * Backpack III
 *
 * Given n kinds of items, and each kind of item has an infinite number available. The i-th item has size A[i] and
 * value V[i]. Also given a backpack with size m. What is the maximum value you can put into the backpack?
 *
 * You cannot divide item into small pieces.
 * Total size of items you put into backpack can not exceed m.
 *
 * Example
 * Example 1:
 * Input: A = [2, 3, 5, 7], V = [1, 5, 2, 4], m = 10
 * Output: 15
 * Explanation: Put three item 1 (A[1] = 3, V[1] = 5) into backpack.
 *
 * Example 2:
 * Input: A = [1, 2, 3], V = [1, 2, 3], m = 5
 * Output: 5
 * Explanation: Strategy is not unique. For example, put five item 0 (A[0] = 1, V[0] = 1) into backpack.
 *
 * https://www.lintcode.com/problem/backpack-iii/
 */
public class Knapsack3 {
    public int knapsack31(int[] A, int[] V, int m) {
        // maximum value can be filled for the every capacity
        int[][] dp = new int[A.length + 1][m + 1];

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - A[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - A[i - 1]] + V[i - 1]);
                }
            }
            //System.out.println(Arrays.toString(dp[i]));
        }

        return dp[A.length][m];
    }

    public int knapsack32(int[] A, int[] V, int m) {
        // maximum value can be filled for the every capacity
        int[] dp = new int[m + 1];

        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                if (j - A[i - 1] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - A[i - 1]] + V[i - 1]);
                }
            }
        }

        return dp[m];
    }

    public int knapsack33(int[] A, int[] V, int m) {
        // maximum value can be filled for the every capacity
        int[] dp = new int[m + 1];

        for (int i = 0; i < A.length; i++) {
            for (int j = A[i]; j <= m; j++) {
                dp[j] = Math.max(dp[j], dp[j - A[i]] + V[i]);
            }
        }

        return dp[m];
    }
}
