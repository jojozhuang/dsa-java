package johnny.datastructure.stack;

import java.util.Stack;

public class StackSorting {
    public static Stack<Integer> sort(Stack<Integer> stack) {
        if (stack == null || stack.isEmpty() || stack.size() == 1) {
            return stack;
        }

        Stack<Integer> res = new Stack<Integer>();

        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (res.isEmpty()) {
                res.push(top);
                continue;
            }
            while (!res.isEmpty() && res.peek() > top) {
                stack.push(res.pop());
            }
            res.push(top);
        }

        return res;
    }
}
