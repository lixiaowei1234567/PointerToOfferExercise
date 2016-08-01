package pointer_to_offer;

import java.util.LinkedList;

/**
 * Created by Administrator on 2016/8/1.
 */
public class TwoStackQueue {
    private static class Stack extends LinkedList<Integer> {
    }

    Stack stackForInput = new Stack();
    Stack stackForOutput = new Stack();

    void appendTail(int value) {
        stackForInput.push(value);
    }

    int deleteHead() {
        if (stackForOutput.isEmpty()) {
            while (!stackForInput.isEmpty()) {
                stackForOutput.push(stackForInput.pop());
            }
        }
        return stackForOutput.pop();
    }

    public static void main(String[] args){
        TwoStackQueue queue = new TwoStackQueue();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());

        queue.appendTail(4);
        queue.appendTail(5);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}
