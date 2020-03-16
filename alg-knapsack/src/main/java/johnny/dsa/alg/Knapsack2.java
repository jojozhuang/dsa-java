package johnny.dsa.alg;

/**
 * Backpack II
 *
 * There are n items and a backpack with size m. Given array A representing the size of each item and array V
 * representing the value of each item. What's the maximum value can you put into the backpack?
 *
 * A[i], V[i], n, m are all integers.
 * You can not split an item.
 * The sum size of the items you want to put into backpack can not exceed m.
 * Each item can only be picked up once
 *
 * Example
 * Example 1:
 * Input: m = 10, A = [2, 3, 5, 7], V = [1, 5, 2, 4]
 * Output: 9
 * Explanation: Put A[1] and A[3] into backpack, getting the maximum value V[1] + V[3] = 9
 *
 * Example 2:
 * Input: m = 10, A = [2, 3, 8], V = [2, 5, 8]
 * Output: 10
 * Explanation: Put A[0] and A[2] into backpack, getting the maximum value V[0] + V[2] = 10
 *
 * https://www.lintcode.com/problem/backpack-ii/
 */
public class Knapsack2 {
    public int knapsack(int[] A, int[] V, int w) {
        // Max value achieved by using the first i items and total weight is exact j.
        int[][] dp = new int[A.length + 1][w + 1];

        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (A[i - 1] <= j)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i - 1]] + V[i - 1]);
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[A.length][w];
    }
}
