package pointer_to_offer;

/**
 * Created by Administrator on 2016/8/1.
 */
public class SearchIn2DArray {
    final int[][] theArray;

    public SearchIn2DArray(int[][] theArray) {
        this.theArray = theArray;
    }

    public void searchTarget(int target) {
        if (theArray == null) {
            System.err.println("The input Array is null");
            return;
        }
        System.out.println("start search for " + target);
        int lineNum = 0;
        int columnNum = theArray[0].length - 1;
        int targetLine = -1, targetColumn = -1;
        boolean foundFlag = false;
        while (true) {
            if (target < theArray[lineNum][columnNum]) {
                columnNum--;
                if (columnNum < 0) {
                    foundFlag = false;
                    break;
                }
            } else if (target > theArray[lineNum][columnNum]) {
                lineNum++;
                if (lineNum == theArray.length) {
                    foundFlag = false;
                    break;
                }
            } else {
                foundFlag = true;
                targetLine = lineNum;
                targetColumn = columnNum;
                break;
            }
        }

        System.out.println(foundFlag ? "Found it in : line " + targetLine + " column " + targetColumn : "Not found");
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {
        int[][] myArray = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        SearchIn2DArray searchIn2DArray = new SearchIn2DArray(myArray);
        searchIn2DArray.searchTarget(7);
        searchIn2DArray.searchTarget(15);
        searchIn2DArray.searchTarget(1);
        searchIn2DArray.searchTarget(16);
        searchIn2DArray.searchTarget(0);
        searchIn2DArray.searchTarget(5);
    }
}
