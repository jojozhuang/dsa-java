package johnny.datastructure.common;

public class Node {
    public int value;
    public int count;
    public Node prev;
    public Node next;

    public Node(int value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }
    
    public Node(int value, int count) {
        this.value = value;
        this.count = count;
        this.prev = null;
        this.next = null;
    }
}