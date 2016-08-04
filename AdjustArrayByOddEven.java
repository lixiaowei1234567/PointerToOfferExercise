package pointer_to_offer;

import java.util.Arrays;

/**
 * 面试题14 ：调整数组顺序使得奇数位于偶数前面
 * 1.使用头尾两个指针
 * 2.使用策略模式使得扩展性更强
 */
public class AdjustArrayByOddEven {
    static void reorder(int[] data, OrderStratege stratege) {

        int preIndex = 0;
        int postIndex = data.length - 1;

        while (postIndex > preIndex) {

            while (postIndex > preIndex && stratege.isValid(data[preIndex])) {
                preIndex++;
            }

            while (postIndex > preIndex && !stratege.isValid(data[postIndex])) {
                postIndex--;
            }

            if (postIndex > preIndex) {
                swap(data, preIndex, postIndex);
            }

        }

    }

    private static void swap(int[] data, int preIndex, int postIndex) {
        int temp = data[preIndex];
        data[preIndex] = data[postIndex];
        data[postIndex] = temp;
    }

    interface OrderStratege {
        boolean isValid(int i);
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        reorder(data, new OrderStratege() {
            @Override
            public boolean isValid(int i) {
                return (i & 1) == 1;
            }
        });
        System.out.println(Arrays.toString(data));

    }
}
