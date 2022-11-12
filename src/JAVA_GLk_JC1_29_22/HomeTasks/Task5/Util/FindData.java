package JAVA_GLk_JC1_29_22.HomeTasks.Task5.Util;

import java.util.Arrays;

public class FindData {

    public FindData() {

    }

    public static String[] findMajorDiagonal(String[][] matrix) {

        String[] arrMajorDiagonal = new String[matrix.length];
        for (int i = 0; i < matrix.length; i++) { /* По строкам */
            arrMajorDiagonal[i] = matrix[i][i];
        }
        return arrMajorDiagonal; // if (i=j)
    }

    public static String[] findSideDiagonal(String[][] matrix) {

        String[] arrSideDiagonal = new String[matrix.length];
        for (int i = 0; i < matrix.length; i++) { /* По строкам */
            arrSideDiagonal[i] = matrix[i][(matrix.length - 1) - i];
        }
        return arrSideDiagonal; // if ( matrix.length == i+j +1 )
    }

    public static void findDoubleOrStringInArrString(String[] arrMajorAndSide, String arrFind, int beginI, int endI) {

        double[] arrFullValueDouble = new double[arrMajorAndSide.length];
        StringBuilder sb = new StringBuilder();
        int len = 0;
        for (String nexString : arrMajorAndSide) {
            if (isFoundValueDouble(nexString.toCharArray(), arrFind)) {
                arrFullValueDouble[len] = MyRandomRound.myRound(Double.parseDouble(nexString));
                len++;
            } else {
                String strShort = nexString.substring(beginI, endI + 1);
                sb.append(strShort);
                sb.append(",");
            }
        }
        PrintData.printSB(sb);

        double[] arrResultValueDouble = Arrays.copyOf(arrFullValueDouble, len);
        PrintData.printArrDouble(arrResultValueDouble);
    }

    private static boolean isFoundValueDouble(char[] arrCharValueOneCell, String arrForFind) {

        if (isPointInBeginOrEndCell(arrCharValueOneCell)) {
            return false;
        }
        for (char nextChar : arrCharValueOneCell) {
            if ((!isCorrectValueChar(nextChar, arrForFind))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPointInBeginOrEndCell(char[] arrCharValueOneCell) {

        if ((arrCharValueOneCell[0] == '.') || (arrCharValueOneCell[arrCharValueOneCell.length - 1] == '.')) {
            return true;
        }
        return false;
    }

    private static boolean isCorrectValueChar(char oneChar, String arrForFind) {

        char[] arrChar = arrForFind.toCharArray();
        for (char nextChar : arrChar) {
            if (oneChar == nextChar) {
                return true;
            }
        }
        return false;
    }

    private double[] findDoubleValueInArrString(String[] arrMajorAndSideDiagonal, String arrForFind) {

        double[] arrFullValueDouble = new double[arrMajorAndSideDiagonal.length];
        int len = 0;
        for (String nextString : arrMajorAndSideDiagonal) {
            if (isFoundValueDouble(nextString.toCharArray(), arrForFind)) {
                arrFullValueDouble[len] = Double.parseDouble(nextString);
                len++;
            }
        }
        return Arrays.copyOf(arrFullValueDouble, len);
    }

    public static String[] finStringValueInArrString(String[] arrMajorAndSideDiagonal, String arrForFind) {

        String[] arrFullValueString = new String[arrMajorAndSideDiagonal.length];
        int len = 0;
        for (String nextString : arrMajorAndSideDiagonal) {
            if (!isFoundValueDouble(nextString.toCharArray(), arrForFind)) {
                arrFullValueString[len] = nextString.substring(2, 5);
                len++;
            }
        }
        return Arrays.copyOf(arrFullValueString, len);
    }
}