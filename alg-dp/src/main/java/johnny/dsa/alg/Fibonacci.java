package johnny.dsa.alg;

/*
 * Return the Nth Fibonacci number, n >= 0.
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, ...
 */
public class Fibonacci {
    // recursive implementation
    public int fibonacciRecursive(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    
    // DP
    public int fibonacciDP(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++)  {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // constant space
    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int first = 0;
        int second = 1;
        int third = 0;

        for (int i = 2; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }

        return third;
    }
}
