package pointer_to_offer;

import java.util.LinkedList;

/**
 * 面试题25：二叉树中和为某一值的路径
 */
public class FindTreePath {

    private static void findPath(TreeNode tree, int expectedSum) {
        if (tree == null) return;
        LinkedList<Integer> stack = new LinkedList<>();

        if (tree.getLeft() == null && tree.getRight() == null) {//only root node
            if (tree.getValue() == expectedSum) {
                System.out.println("Path found : " + tree.getValue());
            }
        } else {
            findPath(tree, expectedSum, stack);
        }
        System.out.println("Path search completed !");
    }

    private static void findPath(TreeNode node, int expectedSum, LinkedList<Integer> stack) {
        if (node == null)
            return;
        stack.push(node.getValue());
        if (node.getLeft() == null && node.getRight() == null) {//Leaf
            if (node.getValue() == expectedSum) {
                printPath(stack);
            }
        } else {
            if (node.getLeft() != null) {
                findPath(node.getLeft(), expectedSum - node.getValue(), stack);
            }
            if (node.getRight() != null) {
                findPath(node.getRight(), expectedSum - node.getValue(), stack);
            }
        }
        stack.pop();
    }

    private static void printPath(LinkedList<Integer> stack) {
        System.out.print("Path found : ");
        for (int i = stack.size()-1; i >=0 ; i--) {
            System.out.print(stack.get(i) + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(12);
        node1.setLeft(node2);
        node1.setRight(node5);
        node2.setLeft(node3);
        node2.setRight(node4);

        findPath(node1, 22);
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
