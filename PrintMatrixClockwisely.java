package pointer_to_offer;

/**
 * 面试题20：顺时针打印矩阵
 * 1.使用画图帮助理清思路
 * 2.考虑最后一圈的各种特殊情况
 */
public class PrintMatrixClockwisely {

    private static void printMatrix(int[][] matrix, int rows, int columns) {
        if (matrix == null || columns <= 0 || rows <= 0)
            return;

        int start = 0;
        while (columns > start * 2 && rows > start * 2) {
            printMatrixCircle(matrix, columns, rows, start);
            start++;
        }
    }

    private static void printMatrixCircle(int[][] matrix, int columns, int rows, int start) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        //从左往右打印一行
        for (int i = start; i <= endX; i++) {
            int number = matrix[start][i];
            System.out.print(number + " ");
        }

        //从上到下打印一列
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                int number = matrix[i][endX];
                System.out.print(number + " ");
            }
        }

        //从右到左打印一行
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                int number = matrix[endY][i];
                System.out.print(number + " ");
            }
        }

        //从下到上打印一列
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                int number = matrix[i][start];
                System.out.print(number + " ");
            }
        }
    }

    public static void main(String[] args) {
        test(3, 3);
        test(1, 3);
        test(2, 3);
        test(4, 4);
        test(5, 3);
    }

    private static void test(int row, int column) {
        int[][] matrix = new int[row][column];
        int counter = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = counter++;
            }
        }
        printMatrix(matrix, row, column);
        System.out.println();
    }
}
