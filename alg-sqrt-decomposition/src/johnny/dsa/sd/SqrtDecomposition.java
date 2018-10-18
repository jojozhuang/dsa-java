package johnny.dsa.sd;

/*
 * Square root decomposition allows us to answer queries in sqrt(N) time. As the implementation of these structures
 * is usually simpler than a segment tree.
 */
//https://github.com/gkcs/Competitive-Programming/blob/master/src/main/java/main/java/videos/SqrtDecomposition.java
public class SqrtDecomposition {
    private int[] nums;
    private long[] sumBlocks;
    private int sqrt;
    public SqrtDecomposition(int[] inputs) {
        if (inputs != null && inputs.length > 0) {
            build(inputs);
        }
    }
    
    private void build(int[] inputs) {
        this.sqrt = (int) Math.ceil(Math.sqrt(inputs.length));
        this.nums = new int[sqrt * sqrt];
        System.arraycopy(inputs, 0, nums, 0, inputs.length); // the tail items may be zero.
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
        int endIBlockIndex = right / sqrt;
        long sum = 0;
        // overlap
        for (int i = startBlockIndex + 1; i < endIBlockIndex; i++) {
            sum += sumBlocks[i];
        }
        // left non-overlap
        if (startBlockIndex == endIBlockIndex) {
            int startIndex = left % sqrt;
            int endIndex = right % sqrt;
            for (int i = startIndex; i <= endIndex; i++) {
                sum += nums[startBlockIndex * sqrt + i];
            }
        } else {
            int startIndex = left % sqrt;
            for (int i = startIndex; i < sqrt; i++) {
                sum += nums[startBlockIndex * sqrt + i];
            }
        }
        // right non-overlap
        if (startBlockIndex != endIBlockIndex) {
            int endIndex = right % sqrt;
            for (int i = 0; i <= endIndex; i++) {
                sum += nums[endIBlockIndex * sqrt + i];
            }
        }
        return sum;
    }

}
