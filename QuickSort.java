package pointer_to_offer;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Administrator on 2016/8/1.
 */
public class QuickSort {

    private static Random rand = new Random(47);

    public static void quickSort(int[] data) {
        quickSort(data, data.length, 0, data.length - 1);
    }

    public static void quickSort(int[] data, int len, int start, int end) {
        if (start == end) return;
        int index = partition(data, len, start, end);
        if (index > start) {
            quickSort(data, len, start, index - 1);
        }
        if (index < end) {
            quickSort(data, len, index + 1, end);
        }
    }

    private static int partition(int[] data, int len, int start, int end) {
        if (data == null || len <= 0 || start < 0 || end >= len) {
            throw new RuntimeException("Invalid parameters");
        }

        int index = start + rand.nextInt(end - start);
        swap(data, index, end);

        int smallPos = start - 1;
        for (index = start; index < end; index++) {
            if (data[index] < data[end]) {
                smallPos++;
                if (smallPos != index) {
                    swap(data, index, smallPos);
                }
            }
        }
        smallPos++;
        swap(data, smallPos, end);

        return smallPos;
    }

    private static void swap(int[] data, int pos1, int pos2) {
        int temp = data[pos2];
        data[pos2] = data[pos1];
        data[pos1] = temp;
    }

    public static void main(String[] args) {
        int[] data = {2, 3, 1, 7, 10, 6, 4};
        quickSort(data);
        System.out.println(Arrays.toString(data));
    }

}
