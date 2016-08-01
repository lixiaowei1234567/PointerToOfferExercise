package pointer_to_offer;

/**
 * Created by Administrator on 2016/8/1.
 */
public class ReplaceSpaceDemo {
    final char[] chars;

    public ReplaceSpaceDemo(char[] chars) {
        this.chars = chars;
    }

    public char[] replaceSpaceWithExtraSpace() {
        int counter = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') counter++;
        }
        char[] newArray = new char[chars.length + counter * 2];
        int originIndex = chars.length - 1;
        int newIndex = newArray.length - 1;

        while (originIndex >= 0) {
            if (chars[originIndex] == ' ') {
                newArray[newIndex--] = '0';
                newArray[newIndex--] = '2';
                newArray[newIndex--] = '%';
                originIndex--;
            } else {
                newArray[newIndex--] = chars[originIndex--];
            }
        }

        return newArray;
    }

    public char[] replaceSpaceWithOutExtraSpace(int endIndex) {
        int counter = 0;
        for (int i = 0; i <= endIndex; i++) {
            if (chars[i] == ' ') counter++;
        }

        int originIndex = endIndex;
        int newIndex = originIndex + counter * 2;

        while (originIndex != newIndex) {
            if (chars[originIndex] == ' ') {
                chars[newIndex--] = '0';
                chars[newIndex--] = '2';
                chars[newIndex--] = '%';
                originIndex--;
            } else {
                chars[newIndex--] = chars[originIndex--];
            }

        }

        return chars;
    }

    public static void main(String[] args) {
        ReplaceSpaceDemo demo = new ReplaceSpaceDemo(new char[]{' ', 'w', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y'});
        char[] chars = demo.replaceSpaceWithExtraSpace();
        System.out.println(chars);
        ReplaceSpaceDemo demo2 = new ReplaceSpaceDemo(new char[]{' ', 'w', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', ' ', ' ', ' ', ' ', ' ', ' '});
        char[] chars2 = demo2.replaceSpaceWithOutExtraSpace(12);
        System.out.println(chars2);
    }
}
