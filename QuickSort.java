package pointer_to_offer;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Administrator on 2016/8/1.
 */
public class QuickSort {

    private static Random rand = new Random(47);

    public static void quickSort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }

    public static void quickSort(int[] data, int start, int end) {
        if (data == null ||  start < 0 || end >= data.length) {
            throw new RuntimeException("Invalid parameters");
        }
        if (start == end) return;
        int index = partition(data, start, end);
        if (index > start) {
            quickSort(data,  start, index - 1);
        }
        if (index < end) {
            quickSort(data, index + 1, end);
        }
    }

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
        swap(data, smallPos, end);

        return smallPos;
    }

    private static void swap(int[] data, int pos1, int pos2) {
        if (pos1 == pos2) return;
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
