package johnny.dsa.alg;

/**
 * Interleaving String
 * Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.
 *
 * Example 1:
 * Input:
 * "aabcc"
 * "dbbca"
 * "aadbbcbcac"
 * Output:
 * true
 *
 * Example 2:
 * Input:
 * ""
 * ""
 * "1"
 * Output:
 * false
 *
 * Example 3:
 * Input:
 * "aabcc"
 * "dbbca"
 * "aadbbbaccc"
 * Output:
 * false
 *
 */
public class InterleavingString {
    // O(n^2)
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();

        if (m + n != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            if (s1.charAt(i-1) == s3.charAt(i-1)) {
                dp[i][0] = true;
            } else {
                break;
            }
        }
        for (int j = 1; j <= n; j++) {
            if (s2.charAt(j-1) == s3.charAt(j-1)) {
                dp[0][j] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s3.charAt(i+j-1)) {
                    dp[i][j] = dp[i][j] || dp[i-1][j];
                }
                if (s2.charAt(j - 1) == s3.charAt(i+j-1)) {
                    dp[i][j] = dp[i][j] || dp[i][j-1];
                }
            }
        }

        return dp[m][n];
    }
}
