package johnny.dsa.alg;

/**
 * Backpack X
 *
 * You have a total of n yuan. Merchant has three merchandises and their prices are 150 yuan, 250 yuan and 350 yuan.
 * And the number of these merchandises can be considered as infinite. After the purchase of goods need to be the
 * remaining money to the businessman as a tip, finding the minimum tip for the merchant.
 *
 * Example:
 *
 * Example 1:
 * Input:  n = 900
 * Output:  0
 *
 * Example 2:
 * Input:  n = 800
 * Output:  0
 *
 * https://www.lintcode.com/problem/backpack-x/
 */
public class Knapsack10 {
    public double knapsack(int n) {
        // 完全背包，每个物品可以取无限多。
        // 只要将O(n)空间优化的 0-1背包的内层循环倒过来循环就可以了。
        int[]prices = {150,250,350};
        int[] dp = new int[n + 1];
        for(int i = 0;i < 3;i++){
            for(int j = prices[i];j <= n;j++){
                dp[j] = Math.max(dp[j], dp[j - prices[i]] + prices[i]);
            }
        }
        int res = n - dp[n];
        return res;
    }
}
