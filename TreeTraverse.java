package pointer_to_offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2016/7/30.
 */
public class TreeTraverse {

    public static void horizontallyTraverse(TreeNode node) { //横向遍历
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(node);
        /**
         * 每次只出队一个，从而保证每次都是左结点先打印，并且把左结点的左右子结点入队，再打印右结点并且把右节点的左右子结点入队
         * 从而队列中的元素都是每一层整齐地从左向右排列，接着排列下一层
         */
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            print(temp.getValue());

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

    public static void preorderTraverse(TreeNode node) { //纵向前序 循环算法
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        //先输出Stack的顶部元素，再使用Stack后进先出的原理，先放入右子结点再放左子结点
        //到叶子结点的时候，没有新的结点入队，就先输出上一层的左结点再输出上一层的右结点，再继续放入上一层的右节点的右左子结点
        if (node != null) {
            stack.push(node);
            while (!stack.isEmpty()) {
                node = stack.pop();
                print(node.getValue());
                if (node.getRight() != null)
                    stack.push(node.getRight());
                if (node.getLeft() != null)
                    stack.push(node.getLeft());
            }
        }
    }


    public static void preorderTraverse2(TreeNode node) { //纵向前序 递归算法
        if (node == null) return;
        print(node.getValue());
        preorderTraverse2(node.getLeft());
        preorderTraverse2(node.getRight());
    }

    public static void inorderTraverse(TreeNode node) {//纵向中序  循环算法
        if (node==null) return;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (true) {
            //循环地把右和中放入stack，直到再也没有左子结点
            while (node != null) {
                if (node.getRight() != null) {
                    stack.push(node.getRight());
                }
                stack.push(node);
                node = node.getLeft();//对当前结点的左子结点进行操作
            }

            node = stack.pop();//获取stack顶层结点——没有左子结点的一个结点
            while (!stack.isEmpty() && node.getRight() == null) {
                //如果这个结点也没有右子结点，那么直接输出
                print(node.getValue());
                node = stack.pop();//获取上一个结点——一定是现在结点的父结点
            }

            //如果当前的结点有右子结点
            //那么输出当前结点
            //根据之前的逻辑，下一个stack出来的结点一定是当前结点的右结点
            //将该右结点弹出，并且运用相同的逻辑遍历它的子孙结点们

            print(node.getValue());
            if (!stack.isEmpty()) {
                node = stack.pop();
            } else {
              return;
            }
        }
    }

    public static void inorderTraverse2(TreeNode node) {//纵向中序  递归算法
        if (node == null) return;
        inorderTraverse2(node.getLeft());
        print(node.getValue());
        inorderTraverse2(node.getRight());
    }

    public static void postorderTraverse(TreeNode node) {//纵向后序  循环算法
        TreeNode temp = node;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while (node != null) {
            // 左子树入栈
            for (; node.getLeft() != null; node = node.getLeft()) {
                stack.push(node);
            }

            // 当前节点无右子——即只需要输出左和中;或右子刚刚已经输出，说明左右都已经输出，接着输出当前结点
            while (node != null && (node.getRight() == null || node.getRight() == temp)) {
                print(node.getValue());
                temp = node;// 记录上一个已输出节点
                if (stack.isEmpty()) return;
                node = stack.pop();
            }

            //当前结点下的左侧子结点已经处理完毕，接着处理右子结点
            stack.push(node);
            node = node.getRight();
        }
    }

    public static void postorderTraverse2(TreeNode node) {//纵向后序  递归算法
        if (node == null) return;
        postorderTraverse2(node.getLeft());
        postorderTraverse2(node.getRight());
        print(node.getValue());
    }

    private static void print(int val) {
        System.out.print(val + " ");
    }

    public static void main(String[] args) {

        TreeNode testTree = createNewTree();
// TODO
        System.out.println("\n-------horizontallyTraverse start-------- ");
        horizontallyTraverse(testTree);
        System.out.println("\n-------horizontallyTraverse finish-------- \n");
        // 1 2 3 4 5 6 7 8

        System.out.println("\n-------preorderTraverse loop start-------- ");
        preorderTraverse(testTree);
        System.out.println("\n-------preorderTraverse loop finish-------- \n");

        System.out.println("\n-------preorderTraverse recursion start--------");
        preorderTraverse2(testTree);
        System.out.println("\n-------preorderTraverse recursion finish-------- \n");
        //1 2 4 8 5 3 6 7

        System.out.println("\n-------inorderTraverse loop start-------- ");
        inorderTraverse(testTree);
        System.out.println("\n-------inorderTraverse loop finish-------- \n");

        System.out.println("\n-------inorderTraverse recursion start-------- ");
        inorderTraverse2(testTree);
        System.out.println("\n-------inorderTraverse recursion finish-------- \n");
        // 8 4 2 5 1 6 3 7

        System.out.println("\n-------postorderTraverse loop start-------- ");
        postorderTraverse(testTree);
        System.out.println("\n-------postorderTraverse loop finish-------- \n");

        System.out.println("\n-------postorderTraverse recursion start-------- ");
        postorderTraverse2(testTree);
        System.out.println("\n-------postorderTraverse recursion finish-------- \n");
        //8 4 5 2 6 7 3 1
    }

    /**
     * 1
     * /   \
     * 2     3
     * / \   / \
     * 4   5 6   7
     * /
     * 8
     */
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


