package johnny.dsa.ds;

public class Node {
    public int key;
    public int value;
    public int count;
    public Node prev;
    public Node next;

    public Node(int key, int value, int count) {
        this.key = key;
        this.value = value;
        this.count = count;
        this.prev = null;
        this.next = null;
    }
}