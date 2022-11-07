package JAVA_GLk_JC1_29_22.HomeTasks.task6.util;

/**
 * Класс MyRandom.
 *
 * @author Andrei Kapytou (Андрей Копытов)
 * @version 1.0
 */
public class MyRandom {

    private static final double CRITERION_ROUND = 1.7;

    public MyRandom() {

    }

    /**
     * Диапазон значений от minValueRange до maxValueRange.
     *
     * @param minValueRange начало диапазона.
     * @param maxValueRange конец диапазона.
     * @return Случайное-рандомное число типа int из заданного диапазона занчений.
     */
    public static int nextRandomIntValueRange(int minValueRange, int maxValueRange) {

        return (int) (Math.random() * ((maxValueRange - minValueRange) + 1)) + minValueRange; // ((max - min) + 1) + min
    }

    /**
     * Диапазон значений от 0 до maxValueRange.
     *
     * @param maxValueRange конец диапазона.
     * @return Случайное-рандомное число типа int из заданного диапазона занчений.
     */
    public static int nextRandomIntValueRange(int maxValueRange) {

        return (int) (Math.random() * (maxValueRange + 1)); // (max + 1)
    }

    public static double nextRandomDoubleValueRange(int valueRange) {

        return Math.random() + valueRange;
    }

    public static char nextRandomChar(String sourceRandomString) {

        char[] arrChar = sourceRandomString.toCharArray();
        return arrChar[MyRandom.nextRandomIntValueRange(arrChar.length - 1)];
    }
}
