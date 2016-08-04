package pointer_to_offer;

/**
 * 面试题18：树的子结构
 */
public class WhetherIsSubtree {
    static boolean haveSubtree(TreeNode tree1, TreeNode tree2) {

        boolean result = false;

        if (tree1 != null && tree2 != null) {
            if (tree1.getValue() == tree2.getValue()) {//先找与tree2的根节点值相等的节点
                result = doesTree1HaveTree2(tree1, tree2);//如果相等进行判断结构中的其他值是否相同
            }
            if (!result) {//如果根节点值不同或者值相同但是结构中有所不同，递归尝试判断左子树
                result = haveSubtree(tree1.getLeft(), tree2);
            }
            if (!result) {//如果左子树也没有，递归尝试判断右子树
                result = haveSubtree(tree1.getRight(), tree2);
            }
        }

        return result;
    }

    private static boolean doesTree1HaveTree2(TreeNode tree1, TreeNode tree2) {
        if (tree2 == null) {
            return true;
        }
        if (tree1 == null) {
            return false;
        }
        if (tree1.getValue() != tree2.getValue()) {
            return false;
        }

        return doesTree1HaveTree2(tree1.getLeft(), tree2.getLeft()) && doesTree1HaveTree2(tree1.getRight(), tree2.getRight());
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(7);
        node1.setLeft(node2);
        node1.setRight(node7);
        node2.setLeft(node3);
        node2.setRight(node4);
        node4.setLeft(node5);
        node4.setRight(node6);

        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(2);
        node8.setLeft(node9);
        node8.setRight(node10);

        System.out.println(haveSubtree(node1, node8));

    }

    private static class TreeNode {

        private TreeNode left;
        private TreeNode right;
        private TreeNode parent;
        private final int value;

        TreeNode(int value) {
            this.value = value;
        }

        int getValue() {
            return value;
        }


        TreeNode getLeft() {
            return left;
        }

        void setLeft(TreeNode left) {
            this.left = left;
            left.parent = this;
        }

        TreeNode getRight() {
            return right;
        }

        void setRight(TreeNode right) {
            this.right = right;
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
