package johnny.dsa.bloomfilter;

public class BloomFilter {
    private int capacity;
    private int[] array;
    public BloomFilter(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
    }

    public void add(String key) {
        int first = hash_function1(key);
        int second = hash_function2(key);
        int third = hash_function3(key);
        array[first%capacity] = 1;
        array[second%capacity] = 1;
        array[third%capacity] = 1;
    }

    public boolean contains(String key) {
        int first = hash_function1(key);
        int second = hash_function2(key);
        int third = hash_function3(key);

        int firstIndex = array[first % capacity];
        if (firstIndex == 0) {
            return false;
        }

        int secondIndex = array[second % capacity];
        if (secondIndex == 0) {
            return false;
        }

        int thirdIndex = array[third % capacity];
        if (thirdIndex == 0) {
            return false;
        }

        return true;
    }

    private int hash_function1(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); ++i) {
            hash = 33 * hash + key.charAt(i);
        }

        return Math.abs(hash);
    }

    private int hash_function2(String key) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < key.length(); ++i) {
            hash = (hash ^ key.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return Math.abs(hash);
    }

    private int hash_function3(String key) {
        int hash, i;
        for (hash = 0, i = 0; i < key.length(); ++i) {
            hash += key.charAt(i);
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        hash += hash << 13;
        hash ^= hash >> 11;
        hash += hash << 15;
        return Math.abs(hash);
    }
}