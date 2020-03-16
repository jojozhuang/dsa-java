package johnny.dsa.alg;

/**
 * Backpack VII
 *
 * Assume that you have n yuan. There are many kinds of rice in the supermarket. Each kind of rice is bagged and
 * must be purchased in the whole bag. Given the weight, price and quantity of each type of rice, find the maximum
 * weight of rice that you can purchase.
 *
 * Example:
 * Example 1:
 * Input:  n = 8, prices = [3,2], weights = [300,160], amounts = [1,6]
 * Output:  640
 * Explanation:  Buy the second rice(price = 2) use all 8 money.
 *
 * Example 2:
 * Input:  n = 8, prices  = [2,4], weight = [100,100], amounts = [4,2 ]
 * Output:  400
 * Explanation:  Buy the first rice(price = 2) use all 8 money.
 *
 * https://www.lintcode.com/problem/backpack-vii/
 */
public class Knapsack7 {
    public int knapsack(int n, int[] prices, int[] weight, int[] amounts) {
        // 把物品的不同数量的打包看作是不同的物品。然后使用0-1背包方法处理。
        int m = prices.length;
        int[] f = new int[n + 1];
        for(int i = 0;i < m;i++){
            for(int j = 1;j <= amounts[i];j++){
                for(int k = n;k >= prices[i];k--){
                    f[k] = Math.max(f[k], f[k - prices[i]] + weight[i]);
                }
            }
        }
        return f[n];
    }
}
