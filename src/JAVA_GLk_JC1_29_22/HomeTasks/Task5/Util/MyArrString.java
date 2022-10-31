package JAVA_GLk_JC1_29_22.HomeTasks.Task5.Util;

public class MyArrString {

    public MyArrString() {
    }

    public static String[] concatTwoArr(String[] firstArrString, String[] secondArrString ){

        int resultLen = firstArrString.length + secondArrString.length;
        String[] resultArr = new String[resultLen];
        for (int i = 0; i < resultArr.length; i++) {
            if ( i < firstArrString.length) {
                resultArr[i] = firstArrString[i];
            } else {
                if ( (i-secondArrString.length) < secondArrString.length ) {
                    resultArr[i] = secondArrString[i - secondArrString.length];
                }
            }
        }
        return resultArr;
    }
}
