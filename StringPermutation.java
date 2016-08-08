package pointer_to_offer;

import java.util.Arrays;

/**
 * 面试题28：字符串的排列
 * 1. 分治法——看成两部分：第一个字符和后面的字符
 * 2. 递归
 */
public class StringPermutation {
    public static void permutation(char[] chars) {
        int length = chars.length;
        permutation(chars, 0);
    }

    private static void permutation(char[] chars, int start) {
        if (start == chars.length) {
            System.out.println(Arrays.toString(chars));
        } else {
            for (int i = start; i < chars.length; i++) {
                //交换第一个字符和后面的某个字符
                char temp = chars[i];
                chars[i] = chars[start];
                chars[start] = temp;

                permutation(chars, start + 1);

                //再换回来
                temp = chars[i];
                chars[i] = chars[start];
                chars[start] = temp;
            }
        }
    }

    public static void main(String[] args) {
        permutation("abc".toCharArray());
    }
}
