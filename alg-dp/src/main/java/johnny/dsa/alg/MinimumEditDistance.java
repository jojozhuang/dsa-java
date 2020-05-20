package johnny.dsa.alg;

/**
 * Minimum Edit Distance
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 *
 * You have the following 3 operations permitted on a word:
 * 1) Insert a character
 * 2) Delete a character
 * 3) Replace a character
 *
 * Example 1:
 *  Input: A="horse", B="ros"
 *  Output: 3
 *  Explanation:
 *    horse -> rorse (replace 'h' with 'r')
 *    rorse -> rose (remove 'r')
 *    rose -> ros (remove 'e')
 *
 * Example 2:
 *  Input: A="intention", B="execution"
 *  Output:  5
 *  Explanation:
 *    intention -> inention (remove 't')
 *    inention -> enention (replace 'i' with 'e')
 *    enention -> exention (replace 'n' with 'x')
 *    exention -> exection (replace 'n' with 'c')
 *    exection -> execution (insert 'u')
 *
 */
public class MinimumEditDistance {
    // O(n^2)
    public int minDistance(String A, String B) {
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 1) dp[i][j - 1], insert character at end of A
                    // 2) dp[i - 1][j], delete A's last character
                    // 3) dp[i - 1][j - 1], replace A's last character
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[m][n];
    }
}
