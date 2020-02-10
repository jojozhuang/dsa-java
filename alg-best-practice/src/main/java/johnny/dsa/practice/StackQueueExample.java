package johnny.dsa.practice;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueExample {
    public static void main(String[] args) {
        // create stack
        Stack<Integer> stack = new Stack<>();
        // create queue
        Queue<Integer> queue = new LinkedList<>();
        // create Deque
        Deque<Integer> deque = new LinkedList<>();

        // Loop elements in queue
        Queue<Integer> queue2 = new LinkedList<>();
        int sum = 0;
        for (int i: queue2) {
            sum = sum + i;
        }
    }
}
