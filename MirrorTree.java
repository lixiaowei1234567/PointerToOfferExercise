package pointer_to_offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题19：二叉树的镜像
 * 1.递归
 */
public class MirrorTree {
    static TreeNode mirror(TreeNode node) {
        if (node == null) return null;
        TreeNode leftNode = node.getLeft();
        TreeNode rightNode = node.getRight();
        node.setRight(mirror(leftNode));
        node.setLeft(mirror(rightNode));
        return node;
    }

    public static void main(String[] args) {
        TreeNode tree = createNewTree();
        traverse(tree);
        System.out.println();
        tree = mirror(tree);
        traverse(tree);
    }

    private static TreeNode createNewTree() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        root.setLeft(node2);
        root.setRight(node3);

        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);
        node3.setRight(node7);

        node4.setLeft(node8);

        return root;
    }

    private static void traverse(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode pollNode = queue.poll();
            System.out.print(pollNode.getValue() + " ");
            if (pollNode.getLeft() != null)
                queue.offer(pollNode.getLeft());
            if (pollNode.getRight() != null)
                queue.offer(pollNode.getRight());
        }
    }

    private static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private TreeNode parent;
        private final Integer value;

        TreeNode(Integer value) {
            this.value = value;
        }

        Integer getValue() {
            return value;
        }


        TreeNode getLeft() {
            return left;
        }

        void setLeft(TreeNode left) {
            this.left = left;
            if (left != null)
                left.parent = this;
        }

        TreeNode getRight() {
            return right;
        }

        void setRight(TreeNode right) {
            this.right = right;
            if (right != null)
                right.parent = this;
        }

        TreeNode getParent() {
            return parent;
        }

        void setParent(TreeNode parent) {
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "node " + value;
        }
    }
}
