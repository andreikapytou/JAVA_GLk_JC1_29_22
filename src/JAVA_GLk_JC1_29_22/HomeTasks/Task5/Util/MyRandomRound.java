package JAVA_GLk_JC1_29_22.HomeTasks.Task5.Util;

import java.lang .Math;

/**
 * Класс MyRandomRound.
 *
 * @version 1.0
 * @author  Andrei Kapytou (Андрей Копытов)
 */
public class MyRandomRound {

    private static final double CRITERION_ROUND = 1.7;

    public MyRandomRound() {

    }

    /**
     * Диапазон значений от minValueRange до maxValueRange.
     * @param minValueRange начало диапазона.
     * @param maxValueRange конец диапазона.
     * @return Случайное-рандомное число типа int из заданного диапазона занчений.
     */
    public static int nextRandomIntValueRange(int minValueRange, int maxValueRange ) {

        return (int)( Math.random() * ( (maxValueRange - minValueRange) + 1)) + minValueRange; // ((max - min) + 1) + min
    }

    /**
     *  Диапазон значений от 0 до maxValueRange.
     * @param maxValueRange конец диапазона.
     * @return Случайное-рандомное число типа int из заданного диапазона занчений.
     */
    public static int nextRandomIntValueRange( int maxValueRange ) {

        return (int)( Math.random() * (maxValueRange + 1)) ; // (max + 1)
    }

    public static double nextRandomDoubleValueRange( int valueRange ) {

        return  Math.random() + valueRange;
    }

    public static double myRound( double valueRound){

        if (valueRound >= CRITERION_ROUND) {
                return Math.ceil(valueRound);
        } else {
                return Math.floor(valueRound);
        }
    }

    public static char nextRandomChar(String sourceRandomString) {

        char[] arrChar = sourceRandomString.toCharArray();
        return arrChar[ MyRandomRound.nextRandomIntValueRange(arrChar.length-1) ];
    }
}
