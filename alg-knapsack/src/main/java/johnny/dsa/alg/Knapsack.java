package johnny.dsa.alg;

/**
 * Backpack
 *
 * Given n items with size A[i], an integer m denotes the size of a backpack. How full you can fill this backpack?
 *
 * You can not divide any item into small pieces.
 *
 * Example
 * Example 1:
 * Input: [3,4,8,5], backpack size=10
 * Output:  9
 *
 * Example 2:
 * Input:  [2,3,5,7], backpack size=12
 * Output:  12
 *
 * https://www.lintcode.com/problem/backpack/
 * https://www.lintcode.com/problem/?tag=backpack
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
