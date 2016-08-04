package pointer_to_offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题7 延展
 * 1.队列和栈的使用
 */
public class TwoQueueStack {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    void push(int value) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.offer(value);
        } else if (queue1.isEmpty()) {
            queue2.offer(value);
        } else if (queue2.isEmpty()) {
            queue1.offer(value);
        } else {
            throw new RuntimeException("Two queue should not have elements at the same time");
        }
    }

    int pop() {
        if (queue1.isEmpty()) {
            while (queue2.size() != 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        } else if (queue2.isEmpty()) {
            while (queue1.size() != 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        } else {
            throw new RuntimeException("Call pop in a empty stack");
        }
    }

    public static void main(String[] args){
        TwoQueueStack stack = new TwoQueueStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        stack.push(6);
        System.out.println(stack.pop());
    }
}
