package pointer_to_offer;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/8/8.
 */
public class HeapSort {
    public static void sort(int[] data) {
        buildMaxheap(data);//第一步，将当前的数据变成一个大根堆
        sortHeap(data);//第二步，依次将大根堆的根（即最大值）与数组尾部交换，然后重新将前面除了尾部的部分变成大根堆，循环操作
    }

    private static void buildMaxheap(int[] data) {
        int startIndex = getParentIndex(data.length - 1);//从最接近叶子的一个节点开始

        for (int i = startIndex; i >= 0; i--) {
            maxheapify(data, data.length, i);
        }
    }

    private static void maxheapify(int[] data, int heapSize, int index) {

        int left = getChildLeftIndex(index);
        int right = getChildRightIndex(index);

        //对比节点与左右子节点，将最大值放于节点处
        int indexOfLarger = index;
        if (left < heapSize && data[index] < data[left]) {
            indexOfLarger = left;
        }
        if (right < heapSize && data[indexOfLarger] < data[right]) {
            indexOfLarger = right;
        }

        if (indexOfLarger != index) {
            swap(data, index, indexOfLarger);//每次交换节点后，原本的子树需要重新调整成堆
            maxheapify(data, heapSize, indexOfLarger);
        }
    }

    private static void swap(int[] data, int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    //父节点是当前节点下标的一半
    private static int getParentIndex(int current) {
        return (current - 1) >> 1;//对应heap的 (current+1) / 2  - 1, 即(current-1)/2
    }

    //左子节点是当前节点下标的2倍
    private static int getChildLeftIndex(int current) {
        return (current << 1) + 1;//对应heap的 (current+1)*2 ,转成array的index要 -1，所以 (current << 1) + 1
    }

    //右子节点是当前节点下标的2倍加1
    private static int getChildRightIndex(int current) {
        return (current + 1) << 1;//对应heap的 (current+1)*2+1 ,转成array的index要 -1，所以 (current+1)*2
    }

    private static void sortHeap(int[] data) {
        for (int i = data.length - 1; i > 0; i--) {
            swap(data, 0, i);
            maxheapify(data, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] data = {4, 3, 6, 8, 1, 2, 9};
        sort(data);
        System.out.println(Arrays.toString(data));
    }
}
