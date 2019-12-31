package johnny.dsa.ds;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int lastnum = 0;

    public QueueStack() {
        queue1 = new LinkedList<Integer>(); // queue1 always has all of the elements
        queue2 = new LinkedList<Integer>(); // queue2 always be empty after pop or top
    }

    // Push new item onto stack
    public void push(int value) {
        queue1.offer(value);
    }

    // Remove the top item of the stack and return its value
    public int pop() throws Exception {
        if (queue1.isEmpty()) {
            throw new Exception();
        }
        while (!queue1.isEmpty()) {
            lastnum = queue1.poll();
            if (!queue1.isEmpty()) {
                queue2.offer(lastnum);
            }
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return lastnum;
    }

    // Get the top item
    public int peek() throws Exception {
        if (queue1.isEmpty()) {
            throw new Exception();
        }
        while (!queue1.isEmpty()) {
            lastnum = queue1.poll();
            queue2.offer(lastnum);
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return lastnum;
    }

    // Return whether the stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}
