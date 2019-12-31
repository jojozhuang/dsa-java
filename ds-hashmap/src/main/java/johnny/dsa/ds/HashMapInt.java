package johnny.dsa.ds;

import java.util.ArrayList;

/*
 * Implementing HashMap with Separate Chaining.
 * Integer Version
 */
public class HashMapInt {
    // bucketArray is used to store array of chains
    private ArrayList<HashNodeInt> bucketList;
    // Current capacity of array list
    private int numBuckets;
    // Current size of array list
    private int size;
    
    // Constructor (Initializes capacity, size and empty chains.
    public HashMapInt() {
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
    public int get(int key) {
        // Find head of chain for given key
        int bucketIndex = hashFunc(key);
        HashNodeInt head = bucketList.get(bucketIndex);
 
        // Search key in chain
        while (head != null) {
            if (head.key == key) {
                return head.val;
            }
            head = head.next;
        }
 
        // If key not found
        return Integer.MIN_VALUE;
    }
    
    // Adds a key value pair to hash
    public void add(int key, int value) {
        // Find head of chain for given key
        int bucketIndex = hashFunc(key);
        HashNodeInt head = bucketList.get(bucketIndex);
 
        // Check if key is already present
        while (head != null) {
            if (head.key == key) {
                head.val = value;
                return;
            }
            head = head.next;
        }
 
        // Insert key in chain
        size++;
        head = bucketList.get(bucketIndex);
        HashNodeInt newNode = new HashNodeInt(key, value);
        newNode.next = head; // add to header
        bucketList.set(bucketIndex, newNode);
        
        // If load factor goes beyond threshold, then double hash table size
        if ((1.0*size)/numBuckets >= 0.7) {
            ArrayList<HashNodeInt> tempList = bucketList;
            bucketList = new ArrayList<>();
            numBuckets = 2 * numBuckets; // double the capacity
            size = 0;
            for (int i = 0; i < numBuckets; i++) {
                bucketList.add(null);
            }
 
            for (HashNodeInt headNode : tempList) { // traverse array
                while (headNode != null) { // traverse each linked list
                    add(headNode.key, headNode.val);
                    headNode = headNode.next;
                }
            }
        }
    }
    
    // Method to remove a given key
    public int remove(int key) {
        // Apply hash function to find index for given key
        int bucketIndex = hashFunc(key);
 
        // Get head of chain
        HashNodeInt head = bucketList.get(bucketIndex);
 
        // Search for key in its chain
        HashNodeInt prev = null;
        while (head != null) {
            // If Key found
            if (head.key == key) {
                break;
            }
 
            // Else keep moving in chain
            prev = head;
            head = head.next;
        }
 
        // If key was not there
        if (head == null) {
            return Integer.MIN_VALUE;
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
    private int hashFunc(int key) {
        int index = key % numBuckets;
        return index;
    }
}
//https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/