package johnny.datastructure.stack;

public class ArrayStack {
    private int top;
    private int[] arr;

    public ArrayStack(int capacity) {
        arr = new int[capacity];
        top = -1;
    }

    // Add new element to the end of the array
    public void push(int value) {
        arr[++top] = value;
    }

    // Remove the last element from the array and return its value
    public int pop() throws Exception {
        if (top < 0) {
            throw new Exception();
        }
        int value = arr[top];
        top--;
        return value;
    }

    // Get the top element
    public int peek() throws Exception {
        if (top < 0) {
            throw new Exception();
        }
        return arr[top];
    }

    // Return whether the stack is empty
    public boolean isEmpty() {
        return top < 0;
    }
}
