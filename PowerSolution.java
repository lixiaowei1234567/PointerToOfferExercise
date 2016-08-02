package pointer_to_offer;

/**
 * Created by Administrator on 2016/8/2.
 */
public class PowerSolution {

    static double power(double base, int exponent) {

        if (base == 0 && exponent < 0) {
            throw new RuntimeException("Invalid parameters: base " + base + " exponent " + exponent);
        }
        int absoluteExponent = exponent;
        if (exponent < 0) {
            absoluteExponent = -exponent;
        }

        double result = powerWithPositiveExp(base, absoluteExponent);
        if (exponent < 0) {
            result = 1.0 / result;
        }

        return result;
    }

    private static double powerWithPositiveExp(double base, int exponent) {

        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;

        double result = powerWithPositiveExp(base, exponent >> 1);//递归
        result *= result;
        if ((exponent & 0x1) == 1) {//判断是否是奇数
            result *= base;
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(power(3.12,5));
        System.out.println(power(0.000000000003,5));
    }
}
