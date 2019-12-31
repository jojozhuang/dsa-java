package johnny.dsa.ds;

import java.util.ArrayList;

/*
 * Implementing HashMap with Separate Chaining.
 * Generic Version.
 */
public class HashMap<K, V> {
    // bucketArray is used to store array of chains
    private ArrayList<HashNode<K, V>> bucketList;
    // Current capacity of array list
    private int numBuckets;
    // Current size of array list
    private int size;
    
    // Constructor (Initializes capacity, size and empty chains.
    public HashMap() {
        bucketList = new ArrayList<>();
        numBuckets = 10;
        size = 0;
 
        // Create empty chains
        for (int i = 0; i < numBuckets; i++) {
            bucketList.add(null);
        }
    }
    
    public int size() { 
        return size; 
    }

    public boolean isEmpty() { 
        return size() == 0; 
    }
    
    // Returns value for a key
    public V get(K key) {
        // Find head of chain for given key
        int bucketIndex = hashFunc(key);
        HashNode<K, V> head = bucketList.get(bucketIndex);
 
        // Search key in chain
        while (head != null) {
            if (head.key.equals(key)) {
                return head.val;
            }
            head = head.next;
        }
 
        // If key not found
        return null;
    }
    
    // Adds a key value pair to hash
    public void add(K key, V value) {
        // Find head of chain for given key
        int bucketIndex = hashFunc(key);
        HashNode<K, V> head = bucketList.get(bucketIndex);
 
        // Check if key is already present
        while (head != null) {
            if (head.key.equals(key)) {
                head.val = value;
                return;
            }
            head = head.next;
        }
 
        // Insert key in chain
        size++;
        head = bucketList.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<K, V>(key, value);
        newNode.next = head; // add to header
        bucketList.set(bucketIndex, newNode);
        
        // If load factor goes beyond threshold, then double hash table size
        if ((1.0*size)/numBuckets >= 0.7) {
            ArrayList<HashNode<K, V>> tempList = bucketList;
            bucketList = new ArrayList<>();
            numBuckets = 2 * numBuckets; // double the capacity
            size = 0;
            for (int i = 0; i < numBuckets; i++) {
                bucketList.add(null);
            }
 
            for (HashNode<K, V> headNode : tempList) { // traverse array
                while (headNode != null) { // traverse each linked list
                    add(headNode.key, headNode.val);
                    headNode = headNode.next;
                }
            }
        }
    }
    
    // Method to remove a given key
    public V remove(K key) {
        // Apply hash function to find index for given key
        int bucketIndex = hashFunc(key);
 
        // Get head of chain
        HashNode<K, V> head = bucketList.get(bucketIndex);
 
        // Search for key in its chain
        HashNode<K, V> prev = null;
        while (head != null) {
            // If Key found
            if (head.key.equals(key)) {
                break;
            }
 
            // Else keep moving in chain
            prev = head;
            head = head.next;
        }
 
        // If key was not there
        if (head == null) {
            return null;
        }
 
        // Reduce size
        size--;
 
        // Remove key
        if (prev != null) {
            prev.next = head.next;
        } else {
            bucketList.set(bucketIndex, head.next);
        }
 
        return head.val;
    }

    // hash function 
    private int hashFunc(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % numBuckets;
        return index;
    }
}
//https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/