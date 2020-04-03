package johnny.dsa.alg;

import org.apache.commons.math3.stat.inference.ChiSquareTest;

public class ChiSquareTestExample {
    public static void main(String[] args) {
        double[] expected = new double[] {1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000};

        // Example 1: Reject null hypothesis, observed doesnt fit
        long[] observed1 = new long[] {771,  795,  927,  942,  1008, 1242, 1146, 1169};

        test(expected, observed1);

        // Example 2: Accept
        long[] observed2 = new long[] {990, 1021, 1018, 1003, 1005, 992, 1005, 1010};

        test(expected, observed2);

        // Example 3: Accept (perfect fit)
        long[] observed3 = new long[] {1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000};

        test(expected, observed3);
    }

    public static void test(double[] expected, long[] observed) {
        double alpha = 0.01; // confidence level 99%

        System.out.println();

        System.out.printf("%15.15s: ", "Observed");
        for (int i = 0; i < observed.length; i++) {
            System.out.printf("%-6d ", observed[i]);
        }

        System.out.println();

        System.out.printf("%15.15s: ", "Expected");
        for (int i = 0; i < expected.length; i++) {
            System.out.printf("%-5.1f ", expected[i]);
        }

        System.out.println();
        System.out.println();

        ChiSquareTest t = new ChiSquareTest();

        double pval = t.chiSquareTest(expected, observed);
        System.out.printf("p-value: %.9f\n", pval);

        boolean rejected = t.chiSquareTest(expected, observed, alpha);
        System.out.println("X^2 Test: " + ((!rejected)? ("PASS") : ("FAIL")));
    }

}
