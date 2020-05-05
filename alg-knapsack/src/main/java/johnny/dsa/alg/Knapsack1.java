package johnny.dsa.alg;

import java.util.Arrays;

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
public class Knapsack1 {
    // space: O(n*m)
    public int knapsack(int[] A, int m) {
        boolean[][] dp = new boolean[A.length + 1][m + 1];
        dp[0][0] = true;

        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                if (j - A[i-1] >= 0 && dp[i-1][j - A[i-1]]) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        //for (int i = 0; i <= A.length; i++) {
        //    System.out.println(Arrays.toString(dp[i]));
        //}

        for (int i = m; i >= 0; i--) {
            if (dp[A.length][i]) {
                return i;
            }
        }

        return 0;
    }

    // space: O(m)
    public int knapsack2(int[] A, int m) {
        boolean[] dp = new boolean[m + 1];
        boolean[] dp2 = new boolean[m + 1];
        dp[0] = true;
        dp2[0] = true;

        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                if (j - A[i-1] >= 0 && dp2[j - A[i-1]]) {
                    dp[j] = true;
                } else {
                    dp[j] = dp2[j];
                }
            }
            dp2 = dp.clone();
        }

        //System.out.println(Arrays.toString(dp));

        for (int i = m; i >= 0; i--) {
            if (dp[i]) {
                return i;
            }
        }

        return 0;
    }
    public int knapsack3(int[] A, int m) {
        // maximum weight can be filled for the every capacity
        int[][] dp = new int[A.length + 1][m + 1];

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - A[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - A[i - 1]] + A[i - 1]);
                }
            }
            System.out.println(Arrays.toString(dp[i]));
        }

        //System.out.println(Arrays.toString(dp));
        return dp[A.length][m];
    }

    public int knapsack4(int[] A, int m) {
        // maximum weight can be filled for the every capacity
        int[] dp = new int[m + 1];

        for (int i = 0; i < A.length; i++) {
            for (int j = m; j >= A[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - A[i]] + A[i]);
            }
            //System.out.println(Arrays.toString(dp));
        }

        //System.out.println(Arrays.toString(dp));
        return dp[m];
    }
}
