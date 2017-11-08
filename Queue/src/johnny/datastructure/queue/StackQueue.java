package johnny.datastructure.queue;

import java.util.Stack;

public class StackQueue {
    private Stack<Integer> stack1; // s1 stores new items
    private Stack<Integer> stack2; // s2 stores old items

    public StackQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    // Add new item onto queue
    public void enqueue(int value) {
        stack1.push(value);
    }

    // Remove the first item from the queue and return its value
    public int dequeue() throws Exception {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        if (stack2.isEmpty()) {
            throw new Exception();
        }
        return stack2.pop();
    }

    // Get the first element
    public int peek() throws Exception {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        if (stack2.isEmpty()) {
            throw new Exception();
        }
        return stack2.peek();
    }

    // Return whether the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.empty();
    }
}
