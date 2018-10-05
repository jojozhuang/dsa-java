package johnny.dsa.fenwicktree;

/**
 * Binary Indexed Tree or Fenwick tree.
 * @author Johnny
 */
//http://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
public class FenwickTree {
    int[] BITree;
    int n = 0;

    public FenwickTree(int arr[])
    {
        if (arr != null) {
            n = arr.length;
        }
        
        BITree = new int[n + 1];
        // Create and initialize BITree[] as 0
        for (int i = 1; i <= n; i++) {
            BITree[i] = 0;
        }

        // Store the actual values in BITree[] using update()
        for (int i = 0; i < n; i++) {
            updateBIT(i, arr[i]);
        }
    }

    // Returns sum of arr[0..index]. This function assumes
    // that the array is preprocessed and partial sums of
    // array elements are stored in BITree[].
    public int getSum(int index)
    {
        int sum = 0; // Iniialize result

        // index in BITree[] is 1 more than the index in arr[]
        index = index + 1;

        // Traverse ancestors of BITree[index]
        while (index>0)
        {
            // Add current element of BITree to sum
            sum += BITree[index];

            // Move index to parent node in getSum View
            index -= index & (-index);
        }
        return sum;
    }
    
    public int getSum(int from, int to)
    {
        if (from >= 0 && to >= 0 && to >= from) {
            return getSum(to) - getSum(from - 1);
        } else {
            return -1;
        }
    }

    // Updates a node in Binary Index Tree (BITree) at given index
    // in BITree.  The given value 'val' is added to BITree[i] and 
    // all of its ancestors in tree.
    public void updateBIT(int index, int val)
    {
        // index in BITree[] is 1 more than the index in arr[]
        index = index + 1;

        // Traverse all ancestors and add 'val'
        while (index <= n)
        {
           // Add 'val' to current node of BI Tree
           BITree[index] += val;

           // Update index to that of parent in update View
           index += index & (-index);
        }
    }
}

