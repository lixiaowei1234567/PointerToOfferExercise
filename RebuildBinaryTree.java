package pointer_to_offer;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/8/1.
 */
public class RebuildBinaryTree {

    public static TreeNode rebuild(int[] preorders, int[] inorders) {
        if (preorders.length == 0) return null;
        TreeNode head = new TreeNode(preorders[0]);
        int headIndex = 0;
        for (int i = 0; i < inorders.length; i++) {
            if (inorders[i] == preorders[0]) {
                headIndex = i;
                break;
            }
        }
        int leftTreeLen = headIndex;
        int rightTreeLen = inorders.length - leftTreeLen - 1;
        int[] leftInorders = new int[leftTreeLen];
        int[] rightInorders = new int[rightTreeLen];
        System.arraycopy(inorders, 0, leftInorders, 0, leftTreeLen);
        System.arraycopy(inorders, leftTreeLen + 1, rightInorders, 0, rightTreeLen);


        int[] leftPreorders = new int[leftTreeLen];
        int[] rightPreorders = new int[rightTreeLen];
        System.arraycopy(preorders, 1, leftPreorders, 0, leftTreeLen);
        System.arraycopy(preorders, 1 + leftTreeLen, rightPreorders, 0, rightTreeLen);

        head.left = rebuild(leftPreorders, leftInorders);
        head.right = rebuild(rightPreorders, rightInorders);

        return head;
    }

    public static void main(String[] args) {
        int[] preorders = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorders = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode node = rebuild(preorders, inorders);
        printTree(node);
    }

    public static void printTree(TreeNode node) {
        System.out.println("Preorder : ");
        preorderTraverse2(node);
        System.out.println("");

        System.out.println("Inorder : ");
        inorderTraverse2(node);
        System.out.println("");

        System.out.println("Postorder : ");
        postorderTraverse2(node);
        System.out.println("");
    }

    public static void preorderTraverse2(TreeNode node) { //纵向前序 递归算法
        if (node == null) return;
        print(node.getValue());
        preorderTraverse2(node.getLeft());
        preorderTraverse2(node.getRight());
    }

    public static void inorderTraverse2(TreeNode node) {//纵向中序  递归算法
        if (node == null) return;
        inorderTraverse2(node.getLeft());
        print(node.getValue());
        inorderTraverse2(node.getRight());
    }

    public static void postorderTraverse2(TreeNode node) {//纵向后序  递归算法
        if (node == null) return;
        postorderTraverse2(node.left);
        postorderTraverse2(node.right);
        print(node.getValue());
    }

    private static void print(int value) {
        System.out.print(value + " ");
    }

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }
    }
}
