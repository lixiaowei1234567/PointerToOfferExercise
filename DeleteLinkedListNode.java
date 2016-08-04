package pointer_to_offer;


/**
 * 面试题13：在O(1)时间删除链表结点
 * 1.用下一个结点覆盖被删除结点的值然后删除下一个结点
 * 2.考虑特殊情况——链表只有一个结点
 * 3.考虑特殊情况——被删除的结点在结尾
 */
public class DeleteLinkedListNode {
    static void delete(LinkedListNode head, LinkedListNode node) {
        if (head == null || node == null) return;

        if (node.next != null) {//非尾节点
            LinkedListNode nextNode = node.next;
            node.value = nextNode.value;
            node.next = nextNode.next;
            nextNode.next = null;
            nextNode = null;
        } else if (head == node) {//只有唯一一个节点
            head = null;
            node = null;
        } else {//链表有多个节点，欲删除尾节点
            LinkedListNode preNode = head;
            while (preNode.next != node) {
                preNode = preNode.next;
            }
            preNode.next = null;
            node = null;
        }

        print(head);
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
    }

    private static void testCase1() {
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);
        LinkedListNode node5 = new LinkedListNode(5);
        LinkedListNode node6 = new LinkedListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        delete(node1, node3);

    }

    private static void testCase2() {
        LinkedListNode node1 = new LinkedListNode(1);
        node1.next = null;

        delete(node1, node1);

    }


    private static void testCase3() {
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);
        LinkedListNode node5 = new LinkedListNode(5);
        LinkedListNode node6 = new LinkedListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        delete(node1, node6);

    }

    private static void print(LinkedListNode node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println("\nFinish printing\n");
    }

    private static class LinkedListNode {
        int value;
        LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

}
