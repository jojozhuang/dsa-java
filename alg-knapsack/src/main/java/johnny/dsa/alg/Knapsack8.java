package johnny.dsa.alg;

/**
 * Backpack VIII
 *
 * Given coins with different values and quantities, find out how many ways of total values in the range of [1, n]
 * can be formed?
 *
 * Example:

 * Example 1:
 * Input: n = 5, value = [1,4], amount = [2,1]
 * Output:  4
 * Explanation: They can combine 4 numbers which are 1,2,4,5.
 *
 * Example 2:
 * Input: n = 10, value = [1,2,4], amount = [2,1,1]
 * Output:  8
 * Explanation: They can combine 8 numbers which are 1 ~ 8.
 *
 * https://www.lintcode.com/problem/backpack-viii/
 */
public class Knapsack8 {
    public int knapsack(int n, int[] value, int[] amount) {
        // 在背包的过程中，当前考虑第i种面值，要记录组成j的时候使用了几个i，如果用超出数量个就不更新。
        int m = value.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        int res = 0;
        for(int i = 0;i < m;i++){
            int[] cnt = new int[n + 1];
            for(int j = value[i];j <= n;j++){
                if(dp[j - value[i]] && !dp[j] && cnt[j - value[i]] < amount[i]){
                    cnt[j] += cnt[j - value[i]] + 1;
                    res++;
                    dp[j] = true;
                }
            }
        }
        return res;
    }
}
