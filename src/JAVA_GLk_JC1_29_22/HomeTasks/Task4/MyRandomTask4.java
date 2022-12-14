package JAVA_GLk_JC1_29_22.HomeTasks.Task4;

import java.lang .Math;

/**
 * Класс MyRandomTask4.
 *
 * В данном класе реализован метод nextRandomIntValueRange().
 * Метод может возвращать рандомныое значение типа int в заданном диапозоне от minValueRange до maxValueRange.
 *  Метод может возвращать рандомныое значение типа int в заданном диапозоне от 0 до maxValueRange.
 *
 * @version 1.0
 * @author  Andrei Kapytou (Андрей Копытов)
 */
public class MyRandomTask4 {

    public MyRandomTask4() {

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

}
