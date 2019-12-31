package johnny.dsa.ds;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public Map<Character, TrieNode> children;
    public boolean leaf; // isWord, isLeaf, isComplete, endOfWord

    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
        leaf = false;
    }
}
