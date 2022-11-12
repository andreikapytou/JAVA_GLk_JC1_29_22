package JAVA_GLk_JC1_29_22.HomeTasks.Task5;

import java.util.Arrays;
import JAVA_GLk_JC1_29_22.HomeTasks.Task5.Util.*;

/**
 * Класс BoxForRunnerTask5.
 *
 * @version 1.0
 * @author  Andrei Kapytou (Андрей Копытов)
 */
public class MatrixWork {

    private static final int SIZE_MATRIX = 10;
    private static final int SIZE_VALUE_CELL = 7;
    private static final String ALPHABET_ENGLISH =  "AaBbCcDdEeFfGgHhIiJjKkLlMmNnJoPpQqRrSsTtUuVvWwXxYyZz";
    private static final String CHAR_VALUE_FOR_FIND =  ".0123456789";

    private static final int BEGIN_EXTRACTION = 2;
    private static final int END_EXTRACTION = 4;

    public MatrixWork() {

    }

    public void startTask() {

        String[][] originalStringMatrix = new String[SIZE_MATRIX][SIZE_MATRIX];
        InitMatrix.initializeMatrix(originalStringMatrix, SIZE_VALUE_CELL, ALPHABET_ENGLISH);
        String[] arrMajorDiagonal = FindData.findMajorDiagonal(originalStringMatrix);
        String[] arrSideDiagonal = FindData.findSideDiagonal(originalStringMatrix);
        String[] arrMajorAndSide = MyArrString.concatTwoArr(arrMajorDiagonal, arrSideDiagonal);

        int modeWork = InputConsoleData.input("\n1-Полный вывод результата. 2-Сокращенныйц вывод результата. Введите режим работы ");
        if ( modeWork == 1 ) {
                System.out.println();
                PrintData.printArrDiagonal("Главная диогональ  :", arrMajorDiagonal, PrintData.FLAG_MAJOR_DIAGONAL);
                PrintData.printArrDiagonal("Побочная диогональ :", arrSideDiagonal, PrintData.FLAG_SIDE_DIAGONAL);
                //PrintData.printResultCompareDiagonal( isCompareDiagonal(arrMajorDiagonal, arrSideDiagonal) );
                PrintData.printResultCompareDiagonal( Arrays.equals(arrMajorDiagonal, arrSideDiagonal) );
                PrintData.printMajorAndSideDiagonal(arrMajorAndSide, arrMajorDiagonal.length);
                FindData.findDoubleOrStringInArrString(arrMajorAndSide, CHAR_VALUE_FOR_FIND, BEGIN_EXTRACTION, END_EXTRACTION  );
                PrintData.printMatrix(originalStringMatrix);
        } else if ( modeWork == 2 ) {
                System.out.println();
                //PrintData.printResultCompareDiagonal( isCompareDiagonal(arrMajorDiagonal, arrSideDiagonal) );
                PrintData.printResultCompareDiagonal( Arrays.equals(arrMajorDiagonal, arrSideDiagonal) );
                FindData.findDoubleOrStringInArrString(arrMajorAndSide, CHAR_VALUE_FOR_FIND, BEGIN_EXTRACTION, END_EXTRACTION  );
                PrintData.printMatrix(originalStringMatrix);
        } else {
                System.out.println("Введен неизвестный режим вывода на печат результат работы программы.");
        }
    }

    private boolean isCompareDiagonal(String[] arrMajorDiagonal, String[] arrSideDiagonal ){

        if( arrMajorDiagonal.length == arrSideDiagonal.length ){
            for (int i = 0; i < arrMajorDiagonal.length; i++){

               if( ! arrMajorDiagonal[i].equals( arrSideDiagonal[i] ) ){
                    return false;
               }
            }
            return true;
        } else {
                return false;
        }
    }

}
