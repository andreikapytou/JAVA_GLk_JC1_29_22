package JAVA_GLk_JC1_29_22.HomeTasks.Task5.Util;

public class PrintData {

    private static final int LEFT_FROM_STR = 1;
    private static final int RIGHT_FROM_STR = 2;
    private static final int LEFT_RIGHT_FROM_STR = 3;
    public static final int FLAG_MAJOR_DIAGONAL = 1;
    public static final int FLAG_SIDE_DIAGONAL = 2;

    public PrintData(){

    }

    private static void initializeArrChar(char[] arrChar, char initValue) {

        for(int i=0; i<arrChar.length; i++) {
            arrChar[i] = initValue;
        }
    }

    // Вставка заданного колличества символов перед-вначало или после-вконец строки
    private static String addChars(String sourceStr, char pasteChar, int qtyChar, int modePaste) {

        StringBuilder sb = new StringBuilder();
        char[] arrChar = new char[qtyChar];
        initializeArrChar(arrChar, pasteChar);
        if (modePaste == LEFT_FROM_STR) {
            sb.append(arrChar).append(sourceStr);
        } else if(modePaste == RIGHT_FROM_STR){
            sb.append(sourceStr).append(arrChar);
        } else if(modePaste == LEFT_RIGHT_FROM_STR){
            sb.append(arrChar).append(sourceStr).append(arrChar);
        } else {
            System.out.println("Задан неизвестный режим вставки символа.");
            return sourceStr;
        }
        return sb.toString();
    }

    // Поиск наибольшего введенного значения размер ячейки в "длине-символов" в каждом столбце матрицы.
    private static int[] findMaxLenColumnInMatrix(String[][] matrix){

        int[] arrMaxLenColumn = new int[matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++)  // По столбцам
        {
            for (int i = 0; i < matrix.length; i++)  // По строкам
            {
                if (arrMaxLenColumn[j] < matrix[i][j].length()) {
                    arrMaxLenColumn[j] = matrix[i][j].length();
                }
            }
        }
        return arrMaxLenColumn;
    }

    private static void printNumColumn(String[][] matrix) {

        int[] arrMaxLenColumn = findMaxLenColumnInMatrix(matrix);
        System.out.print("\n  ");
        for (int j = 0; j < matrix[0].length; j++) { // По столбцам
            System.out.print( addChars(" "+j, ' ', arrMaxLenColumn[j], RIGHT_FROM_STR) ); //Вывод номера столбца
        }
        System.out.println();
    }

    public static void printMatrix(String[][] matrix) {

        printNumColumn(matrix);
        for (int i = 0; i < matrix.length; i++)  /* По строкам */
        {
            System.out.print( i + " "); //Вывод номера троки
            for (int j = 0; j < matrix[i].length; j++)  /* По столбцам */
            {
                System.out.print(" " + matrix[i][j] + " "); //Вывод элемента
            }
            System.out.println(); // Перенос - табличная формы
        }
        System.out.println();
    }

    public static void printArrDiagonal(String title, String[] arrString, int flag) {

        System.out.printf("%s", title);
        if (flag == FLAG_MAJOR_DIAGONAL) {
            for(int i=0; i<arrString.length; i++ ) {
                System.out.printf("[%d][%d]-> %s ", i, i, arrString[i] );
            }
        } else if ((flag == FLAG_SIDE_DIAGONAL)){
            for(int i=0; i<arrString.length; i++ ) {
                System.out.printf("[%d][%d]-> %s ", i, arrString.length-1-i, arrString[i] );
            }
        } else {
            System.out.println("Задан неизвестный флаг.");
        }
        System.out.print("\n");
    }

    public static void printMajorAndSideDiagonal(String[] arrMajorAndSideDiagonal, int lenMajorDiagonal) {

        System.out.println("Главная_и_Побочная :");
        for(int i=0; i<arrMajorAndSideDiagonal.length; i++ ) {
            if(i < lenMajorDiagonal){
                System.out.printf(" [%d]-> %s ", i, arrMajorAndSideDiagonal[i] );
            }
            else if(i == lenMajorDiagonal){
                System.out.println();
                System.out.printf("[%d]-> %s ", i, arrMajorAndSideDiagonal[i] );
            }
            else {
                System.out.printf("[%d]-> %s ", i, arrMajorAndSideDiagonal[i] );
            }
        }
        System.out.print("\n");
    }

    public static void printResultCompareDiagonal(boolean resultCompare) {

        if( resultCompare ){
            System.out.println("Диогонали одинаковые");
        } else {
            System.out.println("Диогонали НЕ одинаковые");
        }
    }

    public static void printSB(StringBuilder sb){

        System.out.println();
        if( sb.length() > 0 ){
            if( (char)(sb.codePointAt(sb.length()-1)) == ',' ) {
                sb.replace(sb.length()-1, sb.length(), ".");
            }
            System.out.println(sb);
        } else {
            System.out.println("Ошибка. Длина StringBuilder <= 0");
        }
    }

    public static void printArrDouble(double[] arrDouble) {

        System.out.println();
        for (int i=0; i<arrDouble.length; i++) {
            if( i < arrDouble.length-1 ) {
                System.out.print(arrDouble[i] + "_");
            } else {
                System.out.print(arrDouble[i]);
            }
        }
        System.out.println();
    }

}
