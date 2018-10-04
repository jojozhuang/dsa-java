package johnny.dsa.common;

/*
 * Another implementation of trie node. Use array instead of map in case all the characters 
 * are lower case letters.
 */
public class TrieArrayNode {
    public TrieArrayNode[] children;
    public boolean leaf; // isWord, isLeaf, isComplete, endOfWord

    public TrieArrayNode() {
        children = new TrieArrayNode[26];
        leaf = false;
    }
}
