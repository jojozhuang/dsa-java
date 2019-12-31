package johnny.dsa.ds;

public class CircularArrayQueue {
    private int head; // the first node in queue, not the first item in array
    private int tail; // the last node in queue, not the first item in array
    private int[] arr;
    private int size;

    public CircularArrayQueue(int capacity) {
        arr = new int[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    // Add item to the end of the queue
    public void enqueue(int value) {
        // check if deque is full
        if (isFull()) {
            System.out.println("queue is full.");
            return;
        }
        tail = (head + size) % arr.length;
        arr[tail] = value;
        size += 1;
    }

    // Remove the first item from the queue and return its value
    public int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Array Queue is empty when dequeue!");
        }

        int value = arr[head];
        head = (head + 1) % arr.length;
        size -= 1;
        return value;
    }

    // Get the first item
    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Array Queue is empty when peek!");
        }
        return arr[head];
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
