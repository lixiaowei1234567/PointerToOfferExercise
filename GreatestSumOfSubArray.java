package pointer_to_offer;

import java.security.InvalidParameterException;

/**
 * 面试题31：连续子数组的最大和
 * 1， 动态规划
 * 2.  举例分析
 */
public class GreatestSumOfSubArray {
    public static int findSum(int[] data) {
        if (data == null) throw new InvalidParameterException();

        int length = data.length;
        int currentSum = 0;
        int greatestSum = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if (currentSum <= 0) {
                currentSum = data[i];
            } else {
                currentSum += data[i];
            }

            if (currentSum > greatestSum) {
                greatestSum = currentSum;
            }
        }

        return greatestSum;
    }

    public static void main(String[] args) {
        int[] data = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(findSum(data));
    }
}
