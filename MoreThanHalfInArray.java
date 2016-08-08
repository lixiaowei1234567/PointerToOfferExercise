package pointer_to_offer;

import java.util.Random;

/**
 * 面试题29：查找数组中出现次数超过一半的数字
 * 1. 使用快速排序中的partition方法 和 递归
 * 2. 根据题目逻辑，将出现的次数和结果保存起来，由于目标出现次数超过数组的一半，所以遍历结束后结果就是目标
 */
public class MoreThanHalfInArray {

    private static Random rand = new Random(47);

    public static int findByPartition(int[] data) {
        if (data == null) return -1;

        int length = data.length;
        int middle = length >> 1;
        int start = 0;
        int end = length - 1;
        int index = partition(data, start, end);
        while (index != middle) {
            if (index > middle) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(data, start, end);
        }

        int result = data[middle];
//有必要的话再检查一下，这个数字是否真的占据了一半以上（针对非法的输入）
        return result;
    }

    private static int partition(int[] data, int start, int end) {

        int index = start + rand.nextInt(end - start);
        swap(data, end, index);

        int smallPos = start - 1;
        for (index = start; index < end; index++) {
            if (data[index] < data[end]) {
                smallPos++;
                swap(data, index, smallPos);
            }
        }

        smallPos++;
        swap(data, end, smallPos);

        return smallPos;
    }

    private static void swap(int[] data, int pos1, int pos2) {
        if (pos1 == pos2) return;
        int temp = data[pos1];
        data[pos1] = data[pos2];
        data[pos2] = temp;
    }

    private static int findByLogic(int[] data) {
        if (data == null) return -1;
        int result = data[0];
        int times = 1;
        for (int i = 0; i < data.length; i++) {
            if (times == 0) {
                result = data[i];
                times = 1;
            } else {
                if (result == data[i]) {
                    times++;
                } else {
                    times--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 1, 1, 1, 1, 1, 1, 3, 5, 1};
        System.out.println(findByPartition(data));
        System.out.println(findByLogic(data));
    }
}
