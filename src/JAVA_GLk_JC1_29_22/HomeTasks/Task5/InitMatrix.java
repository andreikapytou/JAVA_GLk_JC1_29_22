package JAVA_GLk_JC1_29_22.HomeTasks.Task5;

import JAVA_GLk_JC1_29_22.HomeTasks.Task5.Util.MyRandomRound;

public class InitMatrix {

    public InitMatrix() {
    }

    public static void initializeMatrix(String[][] matrix, String initValue) {

        for (int i = 0; i < matrix.length; i++) { /* По строкам */
            for (int j = 0; j < matrix[i].length; j++) { /* По столбцам */
                matrix[i][j] = initValue; // Ввод нового значения
            }
        }
    }

    public static void initializeMatrix(String[][] matrix, int sizeCell, String arrAlphabet) {

        int counter = 0;
        for (int i = 0; i < matrix.length; i++) { /* По строкам */
            for (int j = 0; j < matrix[i].length; j++) { /* По столбцам */
                counter++;
                if( counter == 3 ) {
                    counter = 0;
                    matrix[i][j] = initStringRandomDouble(j, sizeCell); // Ввод нового значения Double
                } else {
                    matrix[i][j] = initStringCharRandom(sizeCell, arrAlphabet); // Ввод нового значения String
                }
            }
        }
    }

    private static String initStringRandomDouble(int numForRandom, int sizeCell) {

        String resultString = Double.toString( MyRandomRound.nextRandomDoubleValueRange(numForRandom) );
        resultString = mySubstring(resultString, 0, sizeCell);
        return resultString;
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

    private static boolean isTrueCriterionSubstring(String sourceStr, int numBeginChar, int numEndChar) {

        if( (numBeginChar >= 0) && (numBeginChar < numEndChar) && sourceStr.length() > numEndChar) {
            return true;
        } else {
            System.out.printf("Неверные занчения numBeginChar=%d или numEndChar=%d", numBeginChar,numEndChar);
            return false;
        }
    }

    private static String mySubstring(String sourceStr, int numBeginChar, int numEndChar) {

        if( isTrueCriterionSubstring(sourceStr, numBeginChar, numEndChar) ) {
            return sourceStr.substring(numBeginChar, numEndChar);
        } else {
            return sourceStr;
        }
    }

}
