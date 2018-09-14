package johnny.datastructure.queue;

import johnny.datastructure.common.EmptyException;

public class ArrayQueue {
    private int head; // the first node
    private int tail; // the last node
    private int[] arr;

    public ArrayQueue(int capacity) {
        arr = new int[capacity];
        head = -1;
        tail = -1;
    }

    // Add item to the end of the array
    public void enqueue(int value) {
        if (tail >= arr.length - 1) {
            return;
        }
        arr[++tail] = value;
        if (head == -1) {
            head = 0;
        }
    }

    // Remove the first item from the array and return its value
    public int dequeue() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException("Array Queue is empty when dequeue!");
        }
        int value = arr[head];
        head++;
        return value;
    }

    // Get the first item
    public int peek() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException("Array Queue is empty when peek!");
        }
        return arr[head];
    }

    // Return whether the queue is empty
    public boolean isEmpty() {
        return (head == -1) || (head == tail);
    }
}
