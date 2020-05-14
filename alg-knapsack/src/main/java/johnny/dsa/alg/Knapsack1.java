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
public class Knapsack1 {
    // space: O(n*m)
    public int knapsack11(int[] A, int m) {
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
    public int knapsack12(int[] A, int m) {
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
            for (int j = 0; j <= m; j++) {
                dp2[j] = dp[j];
            }
        }

        //System.out.println(Arrays.toString(dp));

        for (int i = m; i >= 0; i--) {
            if (dp[i]) {
                return i;
            }
        }

        return 0;
    }
    public int knapsack13(int[] A, int m) {
        // maximum size can be filled for the every capacity
        int[][] dp = new int[A.length + 1][m + 1];

        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - A[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - A[i - 1]] + A[i - 1]);
                }
            }
            //System.out.println(Arrays.toString(dp[i]));
        }

        return dp[A.length][m];
    }

    // incorrect
    public int knapsack14(int[] A, int m) {
        // maximum size can be filled for the every capacity
        int[] dp = new int[m + 1];

        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                if (j - A[i - 1] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - A[i - 1]] + A[i - 1]);
                }
            }
            //System.out.println(Arrays.toString(dp));
        }

        //System.out.println(Arrays.toString(dp));
        return dp[m];
    }

    public int knapsack15(int[] A, int m) {
        // maximum size can be filled for the every capacity
        int[] dp = new int[m + 1];

        for (int i = 1; i <= A.length; i++) {
            for (int j = m; j >= 0; j--) {
                if (j - A[i - 1] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - A[i - 1]] + A[i - 1]);
                }
            }
            //System.out.println(Arrays.toString(dp));
        }

        //System.out.println(Arrays.toString(dp));
        return dp[m];
    }

    // set i = 0 instead of 1
    // move check "j - A[i - 1] >= 0" to for loop
    public int knapsack16(int[] A, int m) {
        // maximum size can be filled for the every capacity
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
