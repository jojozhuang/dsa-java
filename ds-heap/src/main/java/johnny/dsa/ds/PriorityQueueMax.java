package johnny.dsa.ds;

public class PriorityQueueMax {
    private MaxHeap heap;
    
    public PriorityQueueMax() {
        heap = new MaxHeap();
    }
    
    public PriorityQueueMax(int capacity) {
        heap = new MaxHeap(capacity);
    }
    
    public void add(int val) {
        heap.add(val);
    }
    
    public int poll() {
        return heap.remove();
    }
    
    public int peek() {
        return heap.peek();
    }
    
    public boolean isEmpty() {
        return heap.size == 0;
    }

    public int size() {
        return heap.size;
    }
}
