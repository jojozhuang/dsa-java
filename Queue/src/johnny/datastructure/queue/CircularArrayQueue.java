package johnny.datastructure.queue;

import johnny.datastructure.common.EmptyException;

public class CircularArrayQueue {
    private int head; // the first node in queue, not the first item in array
    private int tail; // the last node in queue, not the first item in array
    private int[] arr;

    public CircularArrayQueue(int capacity) {
        arr = new int[capacity];
        head = -1;
        tail = -1;
    }

    // Add item to the end of the queue
    public void enqueue(int value) {
        // check if queue is full
        if (tail == arr.length - 1 && head == 0 || tail == head - 1) {
            System.out.println("queue is full.");
            return;
        }
        // reset tail if it reaches to the end
        if (tail == arr.length - 1 && head != 0) {
            tail = 0;
            arr[tail] = value;
        } else {
            arr[++tail] = value;
            if (head == -1) {
                head = 0;
            }
        }
    }

    // Remove the first item from the queue and return its value
    public int dequeue() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException("Array Queue is empty when dequeue!");
        }
        
        int value = arr[head];
        if (head == tail) {
            // empty, reset to initial status
            head = -1;
            tail = -1;
        } else if (head == arr.length-1) {
            head = 0;
        } else {
            head++;
        }
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
        return head == -1;
    }
}
