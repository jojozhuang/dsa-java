package johnny.dsa.ds;

public class PriorityQueueMin {
    private MinHeap heap;
    
    public PriorityQueueMin() {
        heap = new MinHeap();
    }
    
    public PriorityQueueMin(int capacity) {
        heap = new MinHeap(capacity);
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
