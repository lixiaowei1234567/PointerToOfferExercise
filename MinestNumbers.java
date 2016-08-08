package pointer_to_offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

/**
 * 面试题30:最小的K个数
 * 1. 使用快速排序中的partition方法
 * 2. 使用TreeSet保存最小的k个数
 */
public class MinestNumbers {
    public static List<Integer> find(int[] data, int k) {
        if (data == null || k < 1 || k > data.length) {
            return null;
        }

        int start = 0;
        int end = data.length - 1;
        int index = partition(data, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index--;
            } else {
                start = index++;
            }
            index = partition(data, start, end);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(data[i]);
        }

        return result;
    }

    private static Random rand = new Random(47);

    private static int partition(int[] data, int start, int end) {
        int index = start + rand.nextInt(end - start);
        swap(data, index, end);

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

    private static List<Integer> findBySet(int[] data, int k) {
        if (data == null || k < 1 || k > data.length) {
            return null;
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < data.length; i++) {
            if (set.size() < k) {
                set.add(data[i]);
            } else {
                if (data[i] < set.last()) {
                    set.remove(set.last());
                    set.add(data[i]);
                }
            }
        }

        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int[] data = {2, 10, 6, 5, 4, 9, 1, 7};
        System.out.println(find(data, 4));
        System.out.println(findBySet(data, 4));
    }
}
