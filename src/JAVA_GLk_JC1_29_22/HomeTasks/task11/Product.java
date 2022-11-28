package JAVA_GLk_JC1_29_22.HomeTasks.task11;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Objects;

public class Product {

    private Integer idNumber;
    private String name;
    private Calendar dateOfManufacture;

    public Integer getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return name;
    }

    public void setDateOfManufacture(Calendar dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public Calendar getDateOfManufacture() {
        return dateOfManufacture;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy HH:mm:ss", new Locale("ru"));
        return "ID номер          = " + idNumber +"\n"+
               "Название          = " + name +"\n"+
               "Дата изготовления = " + df.format(dateOfManufacture.getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(idNumber, product.idNumber) && Objects.equals(name, product.name) &&
                Objects.equals(dateOfManufacture, product.dateOfManufacture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumber, name, dateOfManufacture);
    }

    public Product(Integer idNumber, String name, Calendar dateOfManufacture) {

        this.idNumber = idNumber;
        this.name = name;
        this.dateOfManufacture = dateOfManufacture;
    }

    public Product(Integer idNumber, String name) {

        this.idNumber = idNumber;
        this.name = name;
        dateOfManufacture = new GregorianCalendar();
    }



    /*
     GregorianCalendar calendar = new GregorianCalendar(2017, Calendar.JANUARY , 25);
     Calendar calendar = new GregorianCalendar();
   calendar.set(Calendar.YEAR, 2017);
   calendar.set(Calendar.MONTH, 0);
   calendar.set(Calendar.DAY_OF_MONTH, 25);
   calendar.set(Calendar.HOUR_OF_DAY, 19);
   calendar.set(Calendar.MINUTE, 42);
   calendar.set(Calendar.SECOND, 12);

   System.out.println(calendar.getTime());

   System.out.println("Год: " + calendar.get(Calendar.YEAR));
   System.out.println("Месяц: " + calendar.get(Calendar.MONTH));
   System.out.println("Порядковый номер недели в месяце: " + calendar.get(Calendar.WEEK_OF_MONTH));//порядковый номер недели в месяце

   System.out.println("Число: " + calendar.get(Calendar.DAY_OF_MONTH));

   System.out.println("Часы: " + calendar.get(Calendar.HOUR));
   System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
   System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
   System.out.println("Миллисекунды: " + calendar.get(Calendar.MILLISECOND));

    */
}
