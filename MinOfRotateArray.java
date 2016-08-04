package pointer_to_offer;

/**
 * 面试题8——旋转数组的最小数字
 * 1.二分查找法
 * 2.考虑特殊输入——顺序输入（旋转为0）
 * 3.考虑特殊输入——数组中包含多个重复数字
 */
public class MinOfRotateArray {
    public static int min(int[] data) {
        if (data == null) throw new RuntimeException("Null data");
        int start = 0;
        int end = data.length - 1;
        int probe = start;
        while (data[start] >= data[end]) {
            if (end - start == 1) {
                probe = end;
                break;
            }

            probe = (start + end) / 2;

            if (data[start] == data[end] && data[start] == data[probe]) {
                return minInorder(data, start, end);
            }

            if (data[probe] >= data[start]) {
                start = probe;
            } else if (data[probe] <= data[end]) {
                end = probe;
            }
        }
        return data[probe];
    }

    private static int minInorder(int[] data, int start, int end) {
        int min = data[start];
        for (int i = start; i < end; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        return min;
    }


    public static void main(String[] args) {
        int[] rotateArray = {1, 2, 3, 4, 5, 6};//顺序
        System.out.println(min(rotateArray));
        int[] rotateArray1 = {3, 1, 2};
        System.out.println(min(rotateArray1));
        int[] rotateArray2 = {3, 4, 5, 1, 2};
        System.out.println(min(rotateArray2));
        int[] rotateArray3 = {3, 4, 5, 6, 1, 2};
        System.out.println(min(rotateArray3));
        int[] rotateArray4 = {1, 1, 1, 1, 0, 1};//重复的
        System.out.println(min(rotateArray4));
    }
}
