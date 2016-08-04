package pointer_to_offer;

/**
 * 面试题16：反转链表
 *
 */
public class ReverseLinkedList {
    private static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    static ListNode reverseRecursively(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode reverseNode = reverse(head, head.next);
        head.next = null;
        return reverseNode;
    }

    private static ListNode reverse(ListNode node, ListNode nextNode) {
        if (nextNode == null) {
            return node;
        } else {
            ListNode newHeadNode = reverse(nextNode, nextNode.next);
            nextNode.next = node;
            return newHeadNode;
        }
    }

    static ListNode reverseLooply(ListNode head) {

        ListNode reverseNode = null;
        ListNode node = head;
        ListNode preNode = null;
        while (node != null) {
            ListNode nextNode = node.next;
            if (nextNode == null) {
                reverseNode = node;
            }
            node.next = preNode;
            preNode = node;
            node = nextNode;
        }

        return reverseNode;
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

        print(node);
        ListNode reverseNode = reverseRecursively(node);
        print(reverseNode);

        print(reverseLooply(reverseNode));
    }

    private static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println("\nFinish printing\n");
    }

}
