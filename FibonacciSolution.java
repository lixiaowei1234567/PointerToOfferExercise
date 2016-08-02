package pointer_to_offer;

/**
 * Created by Administrator on 2016/8/2.
 */
public class FibonacciSolution {
    public static long fibonacci(int n) {
        int[] result = {0, 1};
        if (n < 2) return result[n];

        long numberOne = 0;
        long numberTwo = 1;
        long numberN = 0;
        for (int i = 2; i <= n; i++) {
            numberN = numberOne + numberTwo;
            numberOne = numberTwo;
            numberTwo = numberN;
        }

        return numberN;
    }

    public static void main(String[] args){
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(100));
    }
}
