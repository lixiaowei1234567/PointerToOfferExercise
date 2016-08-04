package pointer_to_offer;

/**
 * 面试题10
 * 1.考虑特殊输入——负数
 * 2.位运算的使用——把一个整数减去1，再和原整数做 与运算（&），就会把最右边的一个1变成0；（所以一个整数的二进制表示中有多少个1就可以做多少次这样的运算）
 */
public class NumberOfI {
    static int numberOfOne(int n) {
        int counter = 0;
        while (n != 0) {
            counter++;
            n = (n - 1) & n;
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(numberOfOne(3));
        System.out.println(numberOfOne(-1));
    }
}
