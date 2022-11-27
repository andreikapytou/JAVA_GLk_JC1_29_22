package JAVA_GLk_JC1_29_22.HomeTasks.task11;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyData {

    private static final int MAX_MONTH = 11;
    private static final int MAX_DAY = 28;

    private static final int MAX_YEAR = 2021;

    private static final int MAX_HOUR = 23;

    private int iteratorMonth;
    private int iteratorDay=1;

    private int iteratorYear = 2000;
    private int iteratorHour;

    public Calendar fixDataProduct(){

        Calendar fixDate = new GregorianCalendar();
        fixNewYearMountDay(fixDate, formValueYear(), formValueMonth(), formValueDay());
        fixDate.set(Calendar.HOUR_OF_DAY, formValueHour());

        return fixDate;
    }

    public Calendar fixDataProduct(Calendar fixDate){

        fixNewYearMountDay(fixDate, formValueYear(), formValueMonth(), formValueDay());
        fixDate.set(Calendar.HOUR_OF_DAY, formValueHour());
        return fixDate;
    }

    private int formValueMonth() {

        if (iteratorMonth > MAX_MONTH) {
            iteratorMonth = 0;
        }
        return iteratorMonth++;
    }

    private int formValueDay() {

        if (iteratorDay > MAX_DAY) {
            iteratorDay = 1;
        }
        return iteratorDay++;
    }

    private int formValueYear() {

        if (iteratorYear > MAX_YEAR) {
            iteratorYear = 2000;
        }
        return iteratorYear++;
    }

    private int formValueHour() {

        if (iteratorHour > MAX_HOUR) {
            iteratorHour = 0;
        }
        return iteratorHour++;
    }

    private void fixNewYearMountDay(Calendar calendar, int year, int month, int day) {

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
    }

    private void fixNewHourMinuteSecond(Calendar calendar, int hour, int minute, int second) {

        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
    }

    public MyData() {
    }
}
