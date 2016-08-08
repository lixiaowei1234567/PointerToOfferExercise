package pointer_to_offer;

/**
 * 面试题24：判断数组是否是某个二叉搜索树的后序遍历序列
 * 1.二叉树的后序遍历
 * 2.递归
 */
public class WhetherIsPostorderOfBST {
    private static boolean verify(int[] sequence, int start, int end) {
        if (sequence == null) return false;

        int root = sequence[end];

        int leftEnd = start;
        for (; leftEnd < end; leftEnd++) {
            if (sequence[leftEnd] > root) {
                break;
            }
        }

        int rightEnd = leftEnd;
        for (; rightEnd < end; rightEnd++) {
            if (sequence[rightEnd] < root)//如果右子树中有元素比根节点小，就判定为错误
                return false;
        }

        boolean leftVerified = true;
        if (leftEnd > start) {
            leftVerified = verify(sequence, start, leftEnd - 1);
        }

        boolean rightVerified = true;
        if (rightEnd < end) {
            rightVerified = verify(sequence, leftEnd, end - 1);
        }

        return (leftVerified && rightVerified);

    }

    public static void main(String[] args) {
        int[] sequence1 = {5, 7, 6, 9, 11, 10, 8};
        System.out.println(verify(sequence1, 0, sequence1.length - 1));
        int[] sequence2 = {7, 4, 6, 5};
        System.out.println(verify(sequence2, 0, sequence2.length - 1));
    }

}
