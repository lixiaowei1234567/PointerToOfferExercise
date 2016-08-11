package pointer_to_offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 面试题33：把数组中的数字排列成最小的数
 * 1。 隐藏的大数问题
 * 2。 使用新规则排序字符串
 */
public class MinestNumberCreatedByArray {
    public static void findMin(int[] numbers) {
        List<String> numStrs = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            numStrs.add(String.valueOf(numbers[i]));
        }

        Collections.sort(numStrs, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String combin1 = str1 + str2;
                String combin2 = str2 + str1;
                return combin1.compareTo(combin2);
            }
        });

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numStrs.size(); i++) {
            builder.append(numStrs.get(i));
        }

        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        int[] numbers = {3, 32, 321};
        findMin(numbers);
        int[] numbers2 = {1, 42, 321};
        findMin(numbers2);
        int[] numbers3 = {30, 32, 321};
        findMin(numbers3);
    }
}
