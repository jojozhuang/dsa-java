package johnny.dsa.alg;

/**
 * Distinct Subsequences
 * Given two strings S and T. Count the number of distinct subsequences of S which equals T.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some
 * (can be none) of the characters without disturbing the relative positions of the remaining characters.
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not)
 *
 * Example 1:
 * Input: S = "rabbbit", T = "rabbit"
 * Output: 3
 * Explanation: You could remove any 'b' in S, so there are 3 ways to get T.
 *
 * Example 2:
 * Input: S = "abcd", T = ""
 * Output: 1
 * Explanation: There is only 1 way to get T - remove all chars in S.
 *
 * Challenge
 * Do it in O(n^2) time and O(n) memory.
 *
 */
public class DistinctSubsequences {
    // O(n^2)
    public int numDistinct(String S, String T) {
        int m = S.length();
        int n = T.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // case 1: last character in T is same with that in S
                }
                dp[i][j] += dp[i-1][j]; // case 2: last character in T is not same with that in S
            }
        }

        return dp[m][n];
    }
}
