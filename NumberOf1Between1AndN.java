package pointer_to_offer;

/**
 * 面试题32: 从1到n中所有数字中出现1的次数
 * 1. 排列组合
 * 2. 递归
 */
public class NumberOf1Between1AndN {
    public static int number(int n) {
        if (n <= 0) return 0;

        String number = String.valueOf(n);
        return numberOf1(number);
    }

    private static int numberOf1(String number) {

        int length = number.length();
        int first = number.charAt(0) - '0';

        if (length == 1) { // 到达个位时，结束递归
            if (first == 0) {
                return 0;
            } else {
                return 1;
            }
        }

        int numberInFirstDigit = 0;
        if (first > 1) {  //假设输入是 21345， 这里 numberInFirstDigit 只计算 10000 ~ 19999
            numberInFirstDigit = powerBase10(length - 1);
        } else if (first == 1) { // 最高位是 1
            numberInFirstDigit = Integer.parseInt(number.substring(1)) + 1;
        }

        //  numberInOtherDigits 是 1346 到 21345 除了第一位之外的数位中 1 的数目
        int numberInOtherDigits = first * (length - 1) * powerBase10(length - 2);

        int numRecursive = numberOf1(number.substring(1));

        return numberInFirstDigit + numberInOtherDigits + numRecursive;
    }

    private static int powerBase10(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        testNumberOf1Between1AndN(12);
        testNumberOf1Between1AndN(102);
        testNumberOf1Between1AndN(21345);
    }

    private static void testNumberOf1Between1AndN(int i) {
        System.out.println(i + " NumberOf1Between1AndN = " + number(i));
    }
}
