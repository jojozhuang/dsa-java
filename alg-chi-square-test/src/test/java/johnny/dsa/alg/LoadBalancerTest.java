package johnny.dsa.alg;

import org.junit.jupiter.api.Test;

import org.apache.commons.math3.stat.inference.ChiSquareTest;

import static org.junit.jupiter.api.Assertions.*;

public class LoadBalancerTest {

    @Test
    public void testSearchRecursive() {
        System.out.println("testSearchRecursive");
        LoadBalancer instance = new LoadBalancer();

        instance.add(1);
        instance.add(2);
        instance.add(3);

        double[] expected1 = new double[] {1,2,3,1};
        long[] observed1 = new long[] {instance.pick(), instance.pick(), instance.pick(), instance.pick()};

        test(expected1, observed1);

        instance.remove(1);
        double[] expected2 = new double[] {2,3,2};
        long[] observed2 = new long[] {instance.pick(), instance.pick(), instance.pick()};
        test(expected2, observed2);
    }

    public void test(double[] expected, long[] observed) {
        double alpha = 0.01; // confidence level 99%

        ChiSquareTest t = new ChiSquareTest();

        double pval = t.chiSquareTest(expected, observed);
        System.out.printf("p-value: %.9f\n", pval);

        boolean rejected = t.chiSquareTest(expected, observed, alpha);
        System.out.println("X^2 Test: " + ((!rejected)? ("PASS") : ("FAIL")));
        assertEquals(false, rejected);
    }
}
