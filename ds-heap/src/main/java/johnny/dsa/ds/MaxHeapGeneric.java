package johnny.dsa.ds;

import java.util.Arrays;

// Reference: https://courses.cs.washington.edu/courses/cse373/11wi/homework/5/BinaryHeap.java
// Implement generic MaxHeap with array. 
public class MaxHeapGeneric<T extends Comparable<T>> {
    private static final int DEFAULT_CAPACITY = 10;
    protected T[] array;
    protected int size;

    /**
     * Constructs a new MaxHeap.
     */
    @SuppressWarnings("unchecked")
    public MaxHeapGeneric() {
        // Java doesn't allow construction of arrays of placeholder data types 
        array = (T[])new Comparable[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Adds a value to the max-heap.
     */
    public void add(T value) {
        // grow array if needed
        if (size >= array.length - 1) {
            array = this.resize();
        }

        // place element into heap at bottom
        int index = size;
        array[index] = value;
        size++;
        
        bubbleUp();
    }

    /**
     * Returns true if the heap has no elements; false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns heap size.
     */
    public int size() {
        return size;
    }

    /**
     * Returns (but does not remove) the maximum element in the heap.
     */
    public T peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }

        return array[0]; // root
    }

    /**
     * Removes and returns the maximum element in the heap.
     */
    public T remove() {
            // get the root, which is the maximum value
            T result = peek();

            // get rid of the last leaf/decrement
            array[0] = array[size - 1];
            array[size - 1] = null;
            size--;

            bubbleDown();

            return result;
    }

    /**
     * Performs the "bubble down" operation to place the element that is at the 
     * root of the heap in its correct place so that the heap maintains the 
     * max-heap order property.
     */
    protected void bubbleDown() {
        int index = 0; // root

        // bubble down
        while (hasLeftChild(index)) {
            // which child is bigger?
            int biggerChild = leftIndex(index);

            // bubble with the smaller child, if it exists
            if (hasRightChild(index)
                && array[leftIndex(index)].compareTo(array[rightIndex(index)]) < 0) {
                biggerChild = rightIndex(index);
            } 

            if (array[index].compareTo(array[biggerChild]) > 0) {
                break;
            } else {
                swap(index, biggerChild);
                // make sure to update loop counter/index of where last el is put
                index = biggerChild;
            }
        }
    }

    /**
     * Performs the "bubble up" operation to place a newly inserted element 
     * (i.e. the element that is at the size index) in its correct place so 
     * that the heap maintains the max-heap order property.
     */
    protected void bubbleUp() {
        int index = this.size - 1;  // last/right most

        while (hasParent(index)
                && (parent(index).compareTo(array[index]) < 0)) {
            // parent/child are out of order; swap them
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    protected boolean hasParent(int i) {
        return i > 0;
    }

    protected int leftIndex(int i) {
        return i * 2 + 1;
    }

    protected int rightIndex(int i) {
        return i * 2 + 2;
    }

    protected boolean hasLeftChild(int i) {
        return leftIndex(i) <= size - 1;
    }

    protected boolean hasRightChild(int i) {
        return rightIndex(i) <= size - 1;
    }

    protected T parent(int i) {
        return array[parentIndex(i)];
    }

    protected int parentIndex(int i) {
        return (i - 1) / 2;
    }

    protected T[] resize() {
        return Arrays.copyOf(array, array.length * 2);
    }

    protected void swap(int index1, int index2) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
