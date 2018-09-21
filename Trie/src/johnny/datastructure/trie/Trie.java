package johnny.datastructure.trie;

import johnny.datastructure.common.TrieNode;

public class Trie {
    private TrieNode root;
    
    public Trie() {
        this.root = new TrieNode();
    }
    
    public TrieNode getRoot() {
        return this.root;
    }
    
    // Return true if the word is in trie
    public boolean search(String word) {
        TrieNode tn = searchNode(word);
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

    private TrieNode searchNode(String str){
        TrieNode current = root;

        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if (current.children.containsKey(ch)){
                current = current.children.get(ch);
            } else {
                return null;
            }
        }

        return current;
    }
    
    // Insert a word into trie
    public void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if (!current.children.containsKey(ch)){
                current.children.put(ch, new TrieNode());
            }
            current = current.children.get(ch);
        }

        current.leaf = true;
    }
    
    public boolean delete(String word) {
        TrieNode current = root;
        TrieNode lastBranchNode = null;
        Character lastBrachChar = null;

        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if (current.children.containsKey(ch)){
                if (current.children.size() > 1) {
                    lastBranchNode = current;
                    lastBrachChar = ch;
                }
                current = current.children.get(ch);
            } else {
                // word not found
                return false;
            }
        }
        
        if (current.children.size() > 0) {
            // case 1: The to-be deleted word is prefix of another long word in trie.
            current.leaf = false;
            return true;
        }
        
        if (lastBranchNode != null) {
            // case 2: The to-be deleted word has other words as prefix
            lastBranchNode.children.remove(lastBrachChar);
            return true;
        } else {
            // case 3: The to-be deleted word present as unique word
            root.children.remove(word.charAt(0));
            return true;
        }
    }
}
