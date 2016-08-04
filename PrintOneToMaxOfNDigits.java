package pointer_to_offer;

/**
 * 面试题12
 * 1. 考虑大数问题——字符数组模拟数字
 * 2。打印数字要适应用户体验——前面不出现0
 * 3. 排列思想与递归算法
 */
public class PrintOneToMaxOfNDigits {
    static void printWithStringSolution(int n) {
        if (n <= 0) return;

        char[] number = new char[n];
        for (int i = 0; i < n; i++) {
            number[i] = '0';
        }
        while (!increase(number)) {
            printNumber(number);
        }
    }


    private static boolean increase(char[] number) {
        boolean isOverflow = false;
        int takeOver = 0;
        int length = number.length;

        for (int i = length - 1; i >= 0; i--) {
            int sum = number[i] - '0' + takeOver;
            if (i == length - 1) {
                sum++;
            }

            if (sum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    sum -= 10;
                    takeOver = 1;
                    number[i] = (char) ('0' + sum);
                }
            } else {
                number[i] = (char) ('0' + sum);
                break;
            }
        }

        return isOverflow;
    }


    private static void printWithPermutation(int n) {
        if (n <= 0) return;

        char[] number = new char[n];

        for (int i = 0; i < 10; i++) {
            number[0] = (char) (i + '0');
            printWithPermutationRecursively(number, n, 0);
        }

    }

    private static void printWithPermutationRecursively(char[] number, int length, int index) {
        if (index == length - 1) {
            printNumber(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char) (i + '0');
            printWithPermutationRecursively(number, length, index + 1);
        }
    }

    private static void printNumber(char[] number) {
        boolean isBeginning = true;
        for (int i = 0; i < number.length; i++) {
            if (isBeginning && number[i] != '0') {
                isBeginning = false;
            }

            if (!isBeginning) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printWithStringSolution(3);
        System.out.println("------------------------------");
        printWithPermutation(3);
    }
}
