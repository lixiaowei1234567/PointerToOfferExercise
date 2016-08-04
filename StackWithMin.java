package pointer_to_offer;

import java.util.LinkedList;

/**
 * 面试题21：包含min函数的栈
 * 1. 对栈的理解
 * 2.
 */
public class StackWithMin {
    private LinkedList<Integer> dataStack = new LinkedList<>();
    private LinkedList<Integer> minStack = new LinkedList<>();

    public StackWithMin() {
    }

    public void push(int value) {
        dataStack.push(value);
        if (minStack.isEmpty()) {
            minStack.push(value);
        } else {
            Integer currentMin = minStack.peek();
            if (value < currentMin) {
                minStack.push(value);//更新最小值
            } else {
                minStack.push(currentMin);//重复压入上一个最小值
            }
        }
    }

    public int pop() {
        if (dataStack.isEmpty()){
            throw new RuntimeException("Call pop on empty stack");
        }
        minStack.pop();
        return dataStack.pop();
    }

    public int min() {
        if (dataStack.isEmpty()){
            throw new RuntimeException("Call pop on empty stack");
        }
        return minStack.peek();
    }

    public static void main(String[] args){
        StackWithMin minStack = new StackWithMin();
        minStack.push(2);
        System.out.println(minStack.min());
        minStack.push(4);
        System.out.println(minStack.min());
        minStack.push(2);
        System.out.println(minStack.min());
        minStack.push(1);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.push(0);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }
}
