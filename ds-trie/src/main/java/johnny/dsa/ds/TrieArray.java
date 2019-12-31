package johnny.dsa.ds;

/*
 * Another implementation of trie, constructed with array node.
 */
public class TrieArray {
    private TrieArrayNode root;
    
    public TrieArray() {
        this.root = new TrieArrayNode();
    }
    
    public TrieArrayNode getRoot() {
        return this.root;
    }
    
    // Return true if the word is in trie
    public boolean search(String word) {
        TrieArrayNode tn = searchNode(word);
        if (tn != null && tn.leaf) {
            return true;
        } else {
            return false;
        }
    }
    
    // Return true if there is any word in trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        if (searchNode(prefix) == null) {
            return false;
        } else {
            return true;
        }
    }

    private TrieArrayNode searchNode(String str) {
        TrieArrayNode current = root;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (current.children[ch-'a'] != null) {
                current = current.children[ch-'a'];
            } else {
                return null;
            }
        }

        return current;
    }
    
    // Insert a word into trie
    public void insert(String word) {
        TrieArrayNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (current.children[ch-'a'] == null) {
                current.children[ch-'a'] = new TrieArrayNode();
            }
            current = current.children[ch-'a'];
        }

        current.leaf = true;
    }
    
    public boolean delete(String word) {
        TrieArrayNode current = root;
        TrieArrayNode lastBranchNode = null;
        Character lastBrachChar = null;

        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if (current.children[ch-'a'] != null) {
                if (current.children.length > 1) {
                    lastBranchNode = current;
                    lastBrachChar = ch;
                }
                current = current.children[ch-'a'];
            } else {
                // word not found
                return false;
            }
        }
        
        if (current.children.length > 0) {
            // case 1: The to-be deleted word is prefix of another long word in trie.
            current.leaf = false;
            return true;
        }
        
        if (lastBranchNode != null) {
            // case 2: The to-be deleted word has other words as prefix
            lastBranchNode.children[lastBrachChar - 'a'] = null;
            return true;
        } else {
            // case 3: The to-be deleted word present as unique word
            root.children[word.charAt(0) - 'a'] = null;
            return true;
        }
    }
}
