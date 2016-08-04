package pointer_to_offer;

/**
 * 面试题15：链表中倒数第K个结点
 * 1.考虑特殊输入，比如 int参数为0，或者大于链表长度
 */
public class FindKthToTail {
    private static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    static ListNode find(ListNode head, int k) {
        if (head == null || k == 0) return null;

        ListNode aheadNode = head;
        ListNode behindNode = head;

        for (int i = 0; i < k - 1; i++) {
            if (aheadNode.next != null) {
                aheadNode = aheadNode.next;
            } else {
                return null;//k比链表长度还大
            }
        }

        while (aheadNode.next != null) {
            aheadNode = aheadNode.next;
            behindNode = behindNode.next;
        }

        return behindNode;
    }

    public static void main(String[] args) {
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

        ListNode findResult1 = find(node, 1);
        print(findResult1);

        ListNode findResult2 = find(node, 3);
        print(findResult2);

        ListNode findResult3 = find(node, 9);
        print(findResult3);
    }

    private static void print(ListNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
        }
        System.out.println("\nFinish printing\n");
    }

}
