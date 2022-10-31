package JAVA_GLk_JC1_29_22.HomeTasks.Task5.Util;

public class FindData {

    public FindData(){

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
            arrSideDiagonal[i] = matrix[i][(matrix.length-1)-i];
        }
        return arrSideDiagonal; // if ( matrix.length == i+j +1 )
    }

    public static void findDoubleOrStringInArrString(String[] arrMajorAndSide, String arrFind, int beginI, int endI) {

        double[] arrFullValueDouble = new double[arrMajorAndSide.length];
        StringBuilder sb = new StringBuilder();
        int j=0;
        for(int i=0; i<arrMajorAndSide.length; i++){
            if( isFoundValueDouble(arrMajorAndSide[i].toCharArray(), arrFind) ) {
                arrFullValueDouble[j] = MyRandomRound.myRound( Double.parseDouble(arrMajorAndSide[i]) );
                j++;
            } else {
                sb.append( arrMajorAndSide[i].substring(beginI, endI+1) + "," );
            }
        }
        PrintData.printSB(sb);

        double[] arrResultValueDouble = new double[j];
        for(int i=0; i<arrResultValueDouble.length; i++) {
            arrResultValueDouble [i] = arrFullValueDouble[i];
        }
        PrintData.printArrDouble(arrResultValueDouble);
    }

    private static boolean isFoundValueDouble(char[] arrCharValueOneCell, String arrForFind) {

        if( isPointInBeginOrEndCell(arrCharValueOneCell) ) {
            return false;
        }
        for(int i=0; i<arrCharValueOneCell.length; i++) {
            if( (! isCorrectValueChar( arrCharValueOneCell[i], arrForFind)) ) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPointInBeginOrEndCell(char[] arrCharValueOneCell) {

        if( (arrCharValueOneCell[0] == '.') || (arrCharValueOneCell[arrCharValueOneCell.length-1] == '.')  ){
            return true;
        }
        return false;
    }

    private static boolean isCorrectValueChar(char oneChar, String arrForFind) {

        char[] arrChar = arrForFind.toCharArray();
        boolean isCorrectValue = false;
        for (int i = 0; i < arrChar.length; i++) {
            if (oneChar == arrChar[i]) {
                isCorrectValue = true;
            }
        }
        return isCorrectValue;
    }

    private double[] findDoubleValueInArrString(String[] arrMajorAndSideDiagonal, String arrForFind) {

        double[] arrFullValueDouble = new double[arrMajorAndSideDiagonal.length];
        int j=0;
        for(int i=0; i<arrMajorAndSideDiagonal.length; i++){
            if( isFoundValueDouble(arrMajorAndSideDiagonal[i].toCharArray(), arrForFind) ) {
                arrFullValueDouble[j] = Double.parseDouble(arrMajorAndSideDiagonal[i]);
                j++;
            }
        }
        double[] arrResultValueDouble = new double[j];
        for(int i=0; i<arrResultValueDouble.length; i++) {
            arrResultValueDouble [i] =  arrFullValueDouble[i];
        }
        return arrResultValueDouble;
    }

    public static String[] finStringValueInArrString(String[] arrMajorAndSideDiagonal, String arrForFind) {

        String[] arrFullValueString = new String[arrMajorAndSideDiagonal.length];
        int j=0;
        for(int i=0; i<arrMajorAndSideDiagonal.length; i++){
            if( ! isFoundValueDouble(arrMajorAndSideDiagonal[i].toCharArray(), arrForFind) ) {
                arrFullValueString[j] = arrMajorAndSideDiagonal[i].substring(2, 5);
                j++;
            }
        }
        String[] arrResultValueString = new String[j];
        for(int i=0; i<arrResultValueString.length; i++) {
            arrResultValueString[i] =  arrFullValueString[i];
        }
        return arrResultValueString;
    }

    public static double[] findDoubleValueInArrString_Alternative(String[] arrMajorAndSideDiagonal) {

        double[] arrFullValueDouble = new double[arrMajorAndSideDiagonal.length];
        int j=0;
        for(int i=0; i<arrMajorAndSideDiagonal.length; i++){
            try {
                arrFullValueDouble[j] = Double.parseDouble(arrMajorAndSideDiagonal[i]);
                j++;
            }
            catch (Exception e) {
                // System.out.println("Exception: " + e);
            }
        }
        double[] arrResultValueDouble = new double[j];
        for(int i=0; i<arrResultValueDouble.length; i++) {
            arrResultValueDouble [i] =  arrFullValueDouble[i];
        }
        return arrResultValueDouble;
    }

    public static String[] findStringValueInArrString_Alternative(String[] arrMajorAndSideDiagonal) {

        String[] arrFullValueString = new String[arrMajorAndSideDiagonal.length];
        int j=0;
        for(int i=0; i<arrMajorAndSideDiagonal.length; i++){

            try {
                double nextValueDouble = Double.parseDouble(arrMajorAndSideDiagonal[i]);
            }
            catch (Exception e) {
                //System.out.println("Exception: " + e);
                arrFullValueString[j] = arrMajorAndSideDiagonal[i];
                j++;
            }
        }
        String[] arrResultValueString = new String[j];
        for(int i=0; i<arrResultValueString.length; i++) {
            arrResultValueString[i] =  arrFullValueString[i];
        }
        return arrResultValueString;
    }
}
