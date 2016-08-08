package pointer_to_offer;

/**
 * 面试题27：二叉搜索树转换成双向有序链表
 * 1. 二叉树的中序遍历
 * 2. 递归
 */
public class ConvertBSTtoDeLinkedList {


    public static TreeNode convert(TreeNode root) {
        TreeNode lastNode = null;
        lastNode = convertNode(root, lastNode);

        TreeNode linkedListHead = lastNode;
        while (linkedListHead != null && linkedListHead.left != null)
            linkedListHead = linkedListHead.left;
        return linkedListHead;
    }

    private static TreeNode convertNode(TreeNode node, TreeNode lastNode) {
        if (node == null) return null;

        TreeNode currentNode = node;

        if (currentNode.left != null) {
            lastNode = convertNode(currentNode.left, lastNode);
        }

        currentNode.left = lastNode;
        if (lastNode != null) {
            lastNode.right = currentNode;
        }

        lastNode = currentNode;

        if (currentNode.right != null) {
            lastNode = convertNode(node.right, lastNode);
        }

        return lastNode;
    }

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(14);
        TreeNode node6 = new TreeNode(12);
        TreeNode node7 = new TreeNode(16);

        node1.left = node2;
        node1.right = node5;

        node2.left = node3;
        node2.right = node4;

        node5.left = node6;
        node5.right = node7;

        TreeNode linkedListHead = convert(node1);
        printDeLinkedList(linkedListHead);
    }

    private static void printDeLinkedList(TreeNode head) {
        TreeNode node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.right;
        }
    }
}
