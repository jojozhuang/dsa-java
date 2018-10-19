package johnny.dsa.sqrtdecomposition;

/*
 * Square root decomposition allows us to answer queries in sqrt(N) time. 
 */
//https://github.com/gkcs/Competitive-Programming/blob/master/src/main/java/main/java/videos/SqrtDecomposition.java
public class RangeSearchSum {
    private int[] nums;
    private long[] sumBlocks;
    private int sqrt;
    
    public RangeSearchSum(int[] arr) {
        if (arr != null && arr.length > 0) {
            build(arr);
        }
    }
    
    private void build(int[] arr) {
        this.sqrt = (int) Math.ceil(Math.sqrt(arr.length));
        this.nums = new int[sqrt * sqrt];
        System.arraycopy(arr, 0, nums, 0, arr.length); // the tail items in nums may be zero
        this.sumBlocks = new long[sqrt];
        for (int i = 0; i < sumBlocks.length; i++) {
            int startIndex = i * sqrt;
            for (int j = 0; j < sqrt; j++) {
                sumBlocks[i] += nums[startIndex + j];
            }
        }
    }
    
    // update value by index
    public void update(int index, int value) {
        int blockIndex = index / sqrt;
        sumBlocks[blockIndex] = sumBlocks[blockIndex] - nums[index] + value;
        nums[index] = value;
    }
    
    // query with left and right indexes
    public long query(int left, int right) {
        int startBlockIndex = left / sqrt;
        int endBlockIndex = right / sqrt;
        long sum = 0;
        
        if (startBlockIndex == endBlockIndex) { // in the same block
            for (int i = left; i <= right; i++) {
                sum += nums[i];
            }
        } else { // in the different blocks
            // overlap
            for (int i = startBlockIndex + 1; i < endBlockIndex; i++) {
                sum += sumBlocks[i];
            }
            // left non-overlap
            int startIndex = left % sqrt;
            for (int i = startIndex; i < sqrt; i++) {
                sum += nums[startBlockIndex * sqrt + i];
            }
            // right non-overlap
            int endIndex = right % sqrt;
            for (int i = 0; i <= endIndex; i++) {
                sum += nums[endBlockIndex * sqrt + i];
            }
        }
        
        return sum;
    }

}
