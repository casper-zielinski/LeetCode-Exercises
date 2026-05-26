import java.util.*;

public class MinStack {
    private List<Integer> stack;
    private PriorityQueue<Integer> heap;

    public MinStack() {
        stack = new ArrayList<>();
        heap = new PriorityQueue<>();
    }

    public void push(int val) {
        stack.add(val);
        heap.add(val);
    }

    public void pop() {
        int removed = stack.removeLast();
        heap.remove(removed);
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return heap.peek();
    }
}
