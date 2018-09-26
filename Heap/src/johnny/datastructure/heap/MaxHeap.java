package johnny.datastructure.heap;

import java.util.Arrays;

public class MaxHeap {
    private int capacity = 10;
    protected Integer[] array;
    protected int size;

    public MaxHeap () {
        array = new Integer[capacity];
        size = 0;
    }
    
    public MaxHeap (int capacity) {
        this.capacity = capacity;
        array = new Integer[capacity];
        size = 0;
    }

    // add new element into heap
    public void add(int value) {
        if (size >= array.length - 1) {
            array = this.resize();
        }

        // place element into heap at bottom (right most)
        array[size] = value;
        size++;
        
        bubbleUp();
    }

    // bubble up the last node with it's parent until they are in the order of max heap
    protected void bubbleUp() {
        int index = this.size - 1;  // last node (right most)

        while (hasParent(index) && parent(index) < array[index]) {
            // parent and child are out of order; swap them
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }


    // remove and return the maximum element in the heap
    public int remove() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        // get the root, which is the maximum value
        int result = peek();

        // move the last leaf to root
        array[0] = array[size - 1];
        array[size - 1] = null;
        size--;

        bubbleDown();

        return result;
    }

    // bubble down the new root to proper position to maintain the order of max heap
    protected void bubbleDown() {
        // root
        int index = 0;

        // heap is complete tree, so it's safe to check left child first
        while (hasLeftChild(index)) { 
            int biggerChild = leftIndex(index);

            // find the smaller child
            if (hasRightChild(index)
                && array[leftIndex(index)] < (array[rightIndex(index)])) {
                biggerChild = rightIndex(index);
            } 

            if (array[index] > array[biggerChild]) {
                break;
            } else {
                // parent and child are out of order; swap them
                swap(index, biggerChild);
                index = biggerChild;
            }
        }
    }

    // get the root without removing it from heap
    public int peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }

        return array[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    protected boolean hasParent(int i) {
        return i > 0;
    }

    protected int leftIndex(int i) {
        return 2 * i + 1;
    }

    protected int rightIndex(int i) {
        return 2 * i + 2;
    }

    protected boolean hasLeftChild(int i) {
        return leftIndex(i) <= size - 1;
    }

    protected boolean hasRightChild(int i) {
        return rightIndex(i) <= size - 1;
    }

    protected int parent(int i) {
        return array[parentIndex(i)];
    }

    protected int parentIndex(int i) {
        return (i - 1) / 2;
    }

    protected Integer[] resize() {
        return Arrays.copyOf(array, array.length * 2);
    }

    protected void swap(int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
