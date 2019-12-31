package johnny.dsa.ds;

// https://github.com/linli2016/BPlusTree
public class BPTree<TKey extends Comparable<TKey>, TValue> {
    private BTreeNode<TKey> root;

    public BPTree() {
        this.root = new BTreeLeafNode<TKey, TValue>();
    }

    /**
     * Insert a new key and its associated value into the B+ tree.
     */
    public void insert(TKey key, TValue value) {
        BTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key);
        leaf.insertKey(key, value);

        if (leaf.isOverflow()) {
            BTreeNode<TKey> n = leaf.dealOverflow();
            if (n != null)
                this.root = n;
        }
    }

    /**
     * Search a key value on the tree and return its associated value.
     */
    public TValue search(TKey key) {
        BTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key);

        int index = leaf.search(key);
        return (index == -1) ? null : leaf.getValue(index);
    }

    /**
     * Delete a key and its associated value from the tree.
     */
    public void delete(TKey key) {
        BTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key);

        if (leaf.delete(key) && leaf.isUnderflow()) {
            BTreeNode<TKey> n = leaf.dealUnderflow();
            if (n != null)
                this.root = n;
        }
    }

    /**
     * Search the leaf node which should contain the specified key
     */
    @SuppressWarnings("unchecked")
    private BTreeLeafNode<TKey, TValue> findLeafNodeShouldContainKey(TKey key) {
        BTreeNode<TKey> node = this.root;
        while (node.getNodeType() == TreeNodeType.InnerNode) {
            node = ((BTreeInnerNode<TKey>)node).getChild( node.search(key) );
        }

        return (BTreeLeafNode<TKey, TValue>)node;
    }

    /**
     * Unit tests the {@code BTree} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        BPTree<String, String> st = new BPTree<String, String>();

        st.insert("www.cs.princeton.edu", "128.112.136.12");
        st.insert("www.cs.princeton.edu", "128.112.136.11");
        st.insert("www.princeton.edu",    "128.112.128.15");
        st.insert("www.yale.edu",         "130.132.143.21");
        st.insert("www.simpsons.com",     "209.052.165.60");
        st.insert("www.apple.com",        "17.112.152.32");
        st.insert("www.amazon.com",       "207.171.182.16");
        st.insert("www.ebay.com",         "66.135.192.87");
        st.insert("www.cnn.com",          "64.236.16.20");
        st.insert("www.google.com",       "216.239.41.99");
        st.insert("www.nytimes.com",      "199.239.136.200");
        st.insert("www.microsoft.com",    "207.126.99.140");
        st.insert("www.dell.com",         "143.166.224.230");
        st.insert("www.slashdot.org",     "66.35.250.151");
        st.insert("www.espn.com",         "199.181.135.201");
        st.insert("www.weather.com",      "63.111.66.11");
        st.insert("www.yahoo.com",        "216.109.118.65");


        System.out.println("cs.princeton.edu:  " + st.search("www.cs.princeton.edu"));
        System.out.println("hardvardsucks.com: " + st.search("www.harvardsucks.com"));
        System.out.println("simpsons.com:      " + st.search("www.simpsons.com"));
        System.out.println("apple.com:         " + st.search("www.apple.com"));
        System.out.println("ebay.com:          " + st.search("www.ebay.com"));
        System.out.println("dell.com:          " + st.search("www.dell.com"));
        System.out.println();

        //System.out.println("size:    " + st.size());
        //System.out.println("height:  " + st.height());
        System.out.println(st);
        System.out.println();
    }
}
