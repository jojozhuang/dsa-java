package johnny.dsa.alg;

/*
 * Given N items, A[i] is the weight of the i-th item and V[i] is the value of the i-th item. Given a backpack with
 * capacity w, maximize the total value. Each item can be use 0 or 1 time.
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
