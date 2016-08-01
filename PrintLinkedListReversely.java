package pointer_to_offer;

import java.util.LinkedList;

/**
 * Created by Administrator on 2016/8/1.
 */
public class PrintLinkedListReversely {
    private static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public void printReversely(ListNode head) {
        if (head.next != null) {
            printReversely(head.next);
        }
        System.out.print(head.value + " ");
    }

    public void printReversely2(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.value);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        ListNode list = createList();
        new PrintLinkedListReversely().printReversely(list);
        System.out.println("\n  ------------------------------");
        new PrintLinkedListReversely().printReversely2(list);
    }

    private static ListNode createList() {
        ListNode node = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
        return node;
    }
}
