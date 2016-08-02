package pointer_to_offer;

/**
 * Created by Administrator on 2016/8/2.
 */
public class PrintOneToMaxOfNDigits {
    static void printWithStringSolution(int n) {
        if (n <= 0) return;

        char[] number = new char[n];
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
    }
}
