package johnny.dsa.fenwicktree;

public class FenwickTreeSimplified {
    int[] BIT;

    public FenwickTreeSimplified(int arr[]) {
        BIT = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            update(i, arr[i]);
        }
    }

    public int prefixSum(int index) {
        int sum = 0;
        index++;
        for(; index > 0; index -= index&-index)
            sum += BIT[index];
        return sum;
    }

    public int rangeSum(int from, int to) {
        if (from >= 0 && to >= 0 && to >= from) {
            return prefixSum(to) - prefixSum(from - 1);
        } else {
            return -1;
        }
    }

    public void update(int index, int val) {
        index++;
        for(; index <= BIT.length; index += index&-index)
            BIT[index] += val;
    }
}

