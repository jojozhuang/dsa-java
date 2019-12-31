package johnny.dsa.ds;

public class PrefixSumNaive {
    private int[] nums;

    public PrefixSumNaive(int[] nums) {
        this.nums = nums;
    }

    // update value for the specified index
    public void update(int index, int v) {
        nums[index] = v;
    }

    // calculate the sum of all nums[i] such that 0 <= i < k
    public int prefixSum(int k) {
        int sum = 0;
        for (int i = 0; i <= k; i++) {
            sum += nums[i];
        }
        return sum;
    }

    // calculate the sum of all nums[i] such that start <= i <= end
    public int rangeSum(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
