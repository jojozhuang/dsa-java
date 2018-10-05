package johnny.dsa.common;

public class HashNode<K, V> {
    public K key;
    public V val;
    public HashNode<K, V> next;
    public HashNode(K key, V val) {
        this.key = key;
        this.val = val;
        this.next = null;
    }
}
