package johnny.dsa.ds;

/*
  Use MOD to get the new position.
 */
public class CircularArrayDeque {
    private int head; // the first node in deque, not the first item in array
    private int tail; // the last node in deque, not the first item in array
    private int[] arr;
    private int size;

    public CircularArrayDeque(int capacity) {
        arr = new int[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    // Add item to the head of the deque
    public void addFirst(int value) {
        // check if deque is full
        if (isFull()) {
            return;
        }

        head = head - 1;
        if (head < 0) {
            head = arr.length - 1;
        }
        arr[head] = value;
        size += 1;
    }

    // Remove the first item from the deque and return its value
    public int removeFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Circular Array Deque is empty when dequeue!");
        }
        int value = arr[head];
        head = (head + 1) % arr.length;
        size -= 1;
        return value;
    }

    // Get the first item
    public int peekFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Circular Array Deque is empty when peek!");
        }
        return arr[head];
    }
    
    // Add item to the end of the deque
    public void addLast(int value) {
        // check if deque is full
        if (isFull()) {
            return;
        }
        tail = (head + size) % arr.length;
        arr[tail] = value;
        size += 1;
    }

    // Remove the last item from the deque and return its value
    public int removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Circular Array Deque is empty when dequeue!");
        }

        int value = arr[tail];
        tail = tail - 1;
        if (tail < 0) {
            tail = arr.length - 1;
        }
        size -= 1;
        return value;
    }

    // Get the last item
    public int peekLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Circular Array Deque is empty when peek!");
        }
        return arr[tail];
    }

    // Return whether the queue is full
    public boolean isFull() {
        return size == arr.length;
    }
    
    // Return whether the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }
}
