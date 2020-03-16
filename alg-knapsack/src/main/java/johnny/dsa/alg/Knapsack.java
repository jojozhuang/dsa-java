package johnny.dsa.alg;

/*
 * Given N items, A[i] is the weight of the i-th item. And given a backpack with capacity W, maximize the total weight
 * that the backpack can be filled. Each item can be use 0 or 1 time.
 */
public class Knapsack {
    public int knapsack(int[] A, int w) {
        // write your code here
        boolean f[][] = new boolean[A.length + 1][w + 1];
        f[0][0] = true;

        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= w; j++) {
                if (j >= A[i-1] && f[i-1][j - A[i-1]]) {
                    f[i][j] = true;
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }
        }

        for (int i = w; i >= 0; i--) {
            if (f[A.length][i]) {
                return i;
            }
        }

        return 0;

    }

    public int knapsack2(int[] A, int w) {
        // maximum weight can be filled for the every capacity
        int[] dp = new int[w + 1];

        for (int i = 0; i < A.length; i++) {
            for (int j = w; j >= A[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - A[i]] + A[i]);
            }
        }
        return dp[w];
    }
}
