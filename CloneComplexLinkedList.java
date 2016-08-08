package pointer_to_offer;

import java.util.HashMap;

/**
 * 面试题26：复杂链表的复制
 * 1. 方法一使用了HashMap来保存原结点对应的复制结点，方便后面sibling的查找
 * 2. 方法二先将复制结点依次拼接到原结点的后面，形成一条链，利用位置关系复制完sibling，最后将两条链表拆开独立。
 */
public class CloneComplexLinkedList {
    public static ComplexListNode solution1(ComplexListNode head) {
        HashMap<ComplexListNode, ComplexListNode> map = new HashMap<>();
        ComplexListNode tempNode = head;
        ComplexListNode cloneHead = new ComplexListNode(head.value);
        ComplexListNode cloneNode = cloneHead;
        map.put(head, cloneHead);

        while (tempNode.next != null) {
            ComplexListNode cloneTempNode = new ComplexListNode(tempNode.next.value);
            cloneNode.next = cloneTempNode;

            map.put(tempNode.next, cloneTempNode);

            tempNode = tempNode.next;
            cloneNode = cloneTempNode;
        }

        tempNode = head;
        cloneNode = cloneHead;
        while (tempNode.next != null) {
            if (tempNode.sibling != null) {
                cloneNode.sibling = map.get(tempNode.sibling);
            }

            tempNode = tempNode.next;
            cloneNode = cloneNode.next;
        }

        return cloneHead;
    }

    public static ComplexListNode solution2(ComplexListNode head) {
        cloneAndJoinNodes(head);
        cloneSibling(head);
        return teardownAndReconnectNodes(head);
    }

    private static void cloneAndJoinNodes(ComplexListNode head) {
        ComplexListNode node = head;
        while (node != null) {
            ComplexListNode cloneNode = new ComplexListNode(node.value);
            cloneNode.next = node.next;

            node.next = cloneNode;
            node = cloneNode.next;
        }
    }

    private static void cloneSibling(ComplexListNode head) {
        ComplexListNode node = head;
        while (node != null) {
            ComplexListNode cloneNode = node.next;
            if (node.sibling != null) {
                cloneNode.sibling = node.sibling.next;
            }
            node = cloneNode.next;
        }
    }

    private static ComplexListNode teardownAndReconnectNodes(ComplexListNode head) {
        ComplexListNode node = head;
        ComplexListNode cloneHead = null;
        ComplexListNode cloneNode = null;
        if (node != null) {
            cloneHead = cloneNode = node.next;
            node.next = cloneNode.next;
            node = node.next;
        }

        while (node != null) {
            cloneNode.next = node.next;
            cloneNode = cloneNode.next;

            node.next = cloneNode.next;
            node = node.next;
        }

        return cloneHead;
    }

    public static void main(String[] args) {
        ComplexListNode node1 = new ComplexListNode(1);
        ComplexListNode node2 = new ComplexListNode(2);
        ComplexListNode node3 = new ComplexListNode(3);
        ComplexListNode node4 = new ComplexListNode(4);
        ComplexListNode node5 = new ComplexListNode(5);

        node1.next = node2;
        node1.sibling = node3;

        node2.next = node3;
        node2.sibling = node5;

        node3.next = node4;
        node3.sibling = null;

        node4.next = node5;
        node4.sibling = node2;

        node5.next = null;
        node5.sibling = null;

        printComplexList(node1);

        ComplexListNode clone1 = solution1(node1);
        printComplexList(clone1);

        ComplexListNode clone2 = solution2(node1);
        printComplexList(clone2);
    }

    private static void printComplexList(ComplexListNode node) {
        while (node != null) {
            System.out.print("node " + node.value + " next=" + getNodeVal(node.next) + "; sibling=" + getNodeVal(node.sibling));
            System.out.println();
            node = node.next;
        }
        System.out.println("------------------------------");
    }

    private static String getNodeVal(ComplexListNode node) {
        if (node == null) {
            return "null";
        }
        return node.value + "";
    }

    private static class ComplexListNode {
        int value;
        ComplexListNode next;
        ComplexListNode sibling;

        public ComplexListNode(int value) {
            this.value = value;
        }
    }
}
