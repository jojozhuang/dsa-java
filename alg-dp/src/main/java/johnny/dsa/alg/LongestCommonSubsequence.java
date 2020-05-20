package johnny.dsa.alg;

import java.util.Arrays;

/**
 * Longest Common Subsequence
 * Given two strings, find the longest common subsequence (LCS).
 *
 * Your code should return the length of LCS.
 *
 * Example 1:
 *  Input:  "ABCD" and "EDCA"
 *  Output:  1
 *  Explanation: LCS is 'A' or  'D' or 'C'
 *
 * Example 2:
 *  Input: "ABCD" and "EACB"
 *  Output:  2
 *  Explanation: LCS is "AC"
 *
 */
public class LongestCommonSubsequence {
    // O(n^2)
    public int longestCommonSubsequence(String A, String B) {
        if (A == null || A.length() == 0 || B == null || B.length() == 0) {
            return 0;
        }

        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        /*
        for (int i = 0; i < dp.length; i++) {
           System.out.println(Arrays.toString(dp[i]));
        }*/

        return dp[m][n];
    }
}
