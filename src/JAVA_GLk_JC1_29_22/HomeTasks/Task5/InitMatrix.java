package JAVA_GLk_JC1_29_22.HomeTasks.Task5;

import JAVA_GLk_JC1_29_22.HomeTasks.Task5.Util.*;
import java.util.Arrays;

public class InitMatrix {

    public InitMatrix() {
    }

    public static void initializeMatrix(String[][] matrix, String initValue) {

        for (String[] nextCell : matrix) {
            Arrays.fill(nextCell, initValue);
        }
    }

    public static void initializeMatrix(String[][] matrix, int sizeCell, String arrAlphabet) {

        int counter = 0;
        for (int i = 0; i < matrix.length; i++) { /* По строкам */
            for (int j = 0; j < matrix[i].length; j++) { /* По столбцам */
                counter++;
                if( counter == 3 ) {
                    counter = 0;
                    matrix[i][j] = initStringRandomDouble(j); // Ввод нового значения Double
                } else {
                    matrix[i][j] = initStringCharRandom(sizeCell, arrAlphabet); // Ввод нового значения String
                }
            }
        }
    }

    private static String initStringRandomDouble(int numForRandom, int sizeCell) {

        String resultString = Double.toString( MyRandomRound.nextRandomDoubleValueRange(numForRandom) );
        return  resultString.substring(0, sizeCell);
    }

    private static String initStringRandomDouble(int numForRandom) {

        return  Double.toString( MyRandomRound.nextRandomDoubleValueRange(numForRandom) ) ;
    }

    private static String initStringCharRandom(int sizeCell, String strAlphabet) {

        char[] resultArrChar = new char[sizeCell];
        for(int i=0; i < sizeCell; i++) {
            resultArrChar[i] = MyRandomRound.nextRandomChar( strAlphabet );
        }
        StringBuilder sb = new StringBuilder();
        for (char charValue: resultArrChar) {
            sb.append(charValue);
        }
        return sb.toString();
    }

}
