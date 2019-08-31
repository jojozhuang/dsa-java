package johnny.dsa.fenwicktree;

public class PrefixSumImproved {
    private int[] nums;
    private int[] sum;

    public PrefixSumImproved(int[] nums) {
        this.nums = nums;
        this.sum = new int[nums.length];
        this.sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            this.sum[i] = this.sum[i - 1] + nums[i];
        }
    }

    // update value for the specified index
    public void update(int index, int v) {
        for (int i = index; i < sum.length; i++) {
            sum[i] += v - nums[index];
        }
    }

    // calculate the sum of all nums[i] such that 0 <= i < k
    public int prefixSum(int k) {
        return sum[k];
    }

    // calculate the sum of all nums[i] such that start <= i <= end
    public int rangeSum(int start, int end) {
        if (start == 0) {
            return sum[end];
        }
        return sum[end] - sum[start - 1];
    }
}
