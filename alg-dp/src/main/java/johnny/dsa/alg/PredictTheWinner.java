package johnny.dsa.alg;

/**
 * Predict the Winner
 * Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.
 *
 * Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the
 * array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not
 * be available for the next player. This continues until all the scores have been chosen. The player with
 * the maximum score wins.
 *
 * Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.
 *
 * Example 1:
 * Input: [1, 5, 2]
 * Output: False
 * Explanation: Initially, player 1 can choose between 1 and 2.
 * If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will
 * be left with 1 (or 2). So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
 * Hence, player 1 will never be the winner and you need to return False.
 *
 * Example 2:
 * Input: [1, 5, 233, 7]
 * Output: True
 * Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2
 * choose, player 1 can choose 233.
 * Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
 *
 */
public class PredictTheWinner {
    // dp
    public boolean PredictTheWinner5(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        int n = nums.length;
        int[][] dp = new int[n + 1][n]; //dp[i][j], the maximum score possible for the nums[i,j]
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                int left = nums[i] - dp[i + 1][j];
                int right = nums[j] - dp[i][j - 1];
                dp[i][j] = Math.max(left, right);
            }
        }

        return dp[0][n - 1] >= 0;
    }

    public boolean PredictTheWinner3(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }

    // recursion, memorization, O(n^2)
    public boolean PredictTheWinner2(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        int n = nums.length;
        int[][] memo = new int[n][n];
        return helper(nums, 0, n - 1, memo) >= 0;
    }

    // maximum diff score(my_score - op_score) can be obtained
    private int helper(int[] nums, int l, int r, int[][] memo) {
        if (l == r) {
            return nums[l];
        }

        if (memo[l][r] > 0) {
            return memo[l][r];
        }

        memo[l][r] = Math.max(nums[l] - helper(nums, l + 1, r, memo),
                nums[r] - helper(nums, l, r - 1, memo));
        return memo[l][r];
    }

    // recursion, O(2^n)
    public boolean PredictTheWinner(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        return helper4(nums, 0, nums.length - 1) >= 0;
    }

    // maximum diff score(my_score - op_score) can be obtained
    private int helper4(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        return Math.max(nums[left] - helper4(nums, left + 1, right),
                nums[right] - helper4(nums, left, right - 1));
    }
}
