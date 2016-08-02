package pointer_to_offer;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/8/1.
 */
public class SortAgeByArray {
    private static void sortAges(int[] ages) {
        if (ages == null) return;

        int oldestAge = 99;
        int[] records = new int[oldestAge + 1];

        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            if (age < 0 || age > oldestAge) throw new RuntimeException("age out of range");
            records[age]++;
        }

        int index = 0;
        for (int i = 0; i <= oldestAge; i++) {
            for (int j = 0; j < records[i]; j++) {
                ages[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] ages = {23, 43, 21, 12, 98, 78, 56, 99};
        sortAges(ages);
        System.out.println(Arrays.toString(ages));
    }
}
