package johnny.dsa.fenwicktree;

public class FenwickTree {
    int[] BIT;

    public FenwickTree(int arr[]) {
        BIT = new int[arr.length + 1]; // index starts from 1 not 0.

        // store the actual values in BIT[] using update()
        for (int i = 0; i < arr.length; i++) {
            update(i, arr[i]);
        }
    }

    // return sum of arr[0..index].
    public int prefixSum(int index) {
        int sum = 0;

        // index in BIT[] starts from 1
        index = index + 1;

        // traverse ancestors of BIT[index]
        while (index > 0) {
            // add current element of BIT to sum
            sum += BIT[index];

            // move index to parent node in Sum View
            index -= index & (-index);
        }
        return sum;
    }

    // return sum of the given range
    public int rangeSum(int from, int to) {
        if (from >= 0 && to >= 0 && to >= from) {
            return prefixSum(to) - prefixSum(from - 1);
        } else {
            return -1;
        }
    }

    // update a node in Binary Index Tree at given index, the given value is the 'delta' value
    // compared with the original array arr[], not array BIT[]. This delta value is added to BIT[i] and
    // all of its ancestors.
    public void update(int index, int val) {
        // index in BIT[] starts from 1
        index = index + 1;

        // traverse all ancestors and add 'val'
        while (index <= BIT.length) {
           // add 'val' to current node of BI Tree
            BIT[index] += val;

           // update index to that of parent in Update View
           index += index & (-index);
        }
    }
}

