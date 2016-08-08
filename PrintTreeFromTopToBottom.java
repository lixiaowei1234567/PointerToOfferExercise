package pointer_to_offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2016/8/5.
 */
public class PrintTreeFromTopToBottom {

    public static void horizontallyTraverse(TreeNode node) { //横向遍历
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(node);
        /**
         * 每次只出队一个，从而保证每次都是左结点先打印，并且把左结点的左右子结点入队，再打印右结点并且把右节点的左右子结点入队
         * 从而队列中的元素都是每一层整齐地从左向右排列，接着排列下一层
         */
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            print(temp);

            TreeNode left = temp.getLeft();//先把左子树结点入队
            if (left != null) {
                queue.add(left);
            }

            TreeNode right = temp.getRight();//再把右子树结点入队
            if (right != null) {
                queue.add(right);
            }
        }
    }

    private static void print(TreeNode node) {
        System.out.print(node.getValue() + " ");
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
