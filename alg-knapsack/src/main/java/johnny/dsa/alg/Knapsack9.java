package johnny.dsa.alg;

/**
 * Backpack IX
 *
 * You have a total of n thousand yuan, hoping to apply for a university abroad. The application is required to
 * pay a certain fee. Give the cost of each university application and the probability of getting the
 * University's offer, and the number of university is m. If the economy allows, you can apply for multiple
 * universities. Find the highest probability of receiving at least one offer.
 *
 * 0<=n<=10000,0<=m<=10000
 *
 * Example
 * Example 1:
 * Input: n = 10, prices = [4,4,5], probability = [0.1,0.2,0.3]
 * Output:  0.440
 * Explanation: select the second and the third school.
 *
 *
 * Example 2:
 * Input: n = 10, prices = [4,5,6], probability = [0.1,0.2,0.3]
 * Output:  0.370
 * Explanation: select the first and the third school.
 *
 * https://www.lintcode.com/problem/backpack-ix/
 */
public class Knapsack9 {
    public double knapsack(int n, int[] prices, double[] probability) {
        // 正难则反。
        // 计算一个offer都收不到的概率，然后减掉。
        double dp[] = new double[10010];
        for (int i = 0; i <= n; i ++) {
            dp[i] = 1.0;
        }
        for (int i = 0; i < probability.length; i++) {
            probability[i] = 1 - probability[i];
        }
        dp[0] = 1.0;
        for(int i = 0; i < probability.length; i ++) {
            for(int j = n; j >= prices[i]; j --) {
                dp[j] = Math.min(dp[j], dp[j-prices[i]] * probability[i]);
            }
        }
        return 1 - dp[n];
    }
}
