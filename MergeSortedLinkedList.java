package pointer_to_offer;

/**
 * 面试题17：合并两个有序链表
 * 1.递归算法
 * 2.特殊输入——空链表
 */
public class MergeSortedLinkedList {
    private static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    static ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        ListNode mergedHead = null;
        if (head1.value < head2.value) {
            mergedHead = head1;
            mergedHead.next = merge(head1.next, head2);
        } else {
            mergedHead = head2;
            mergedHead.next = merge(head1, head2.next);
        }
        return mergedHead;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        node.next = node2;
        node2.next = node4;
        node4.next = node6;
        node6.next = null;

        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        node1.next = node3;
        node3.next = node5;
        node5.next = null;

        print(node);
        print(node1);

        print(merge(node, node1));

    }

    private static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println("\nFinish printing\n");
    }
}
