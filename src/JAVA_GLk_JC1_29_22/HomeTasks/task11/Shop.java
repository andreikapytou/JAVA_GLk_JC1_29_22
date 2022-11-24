package JAVA_GLk_JC1_29_22.HomeTasks.task11;

import java.util.*;

public class Shop {

    private static final String[] PRODUCTS_NAMES = {"Очки", "Плавки", "Велосипед", "Нож", "Чашка", "Лампа", "Книга"};
    
    private static List<Product> productsInWarehouse = new ArrayList<>();
    private List<Product> productsInBasket = new ArrayList<>();
    private static List<Order> listOrders = new ArrayList<>();

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

   DateFormat df = new SimpleDateFormat("dd MMM yyy GG");
   System.out.println(df.format(calendar.getTime()));

    */

    private void basket() {

    }

    private static void unloadProductsInWarehouse(String[] productsNames) {

        for(int i=0; i< productsNames.length; i++){
            productsInWarehouse.add(new Product(i+1, productsNames[i]));
        }

        Calendar dataProduct = new GregorianCalendar();
        fixNewYearMountDay(dataProduct, 1999, 11, 1);
        fixNewHourMinuteSecond(dataProduct, 23, 12, 30);
        productsInWarehouse.add(new Product(123, "Ваза", dataProduct));
     }

    private static void fixDateProductsInWarehouse(){

         for(int i = 0; i<productsInWarehouse.size()-1; i++){

             Product product = productsInWarehouse.get(i);
             Calendar lastDate =  product.getDateOfManufacture();
             fixNewYearMountDay(lastDate, 2000+i, 11, 1);
             fixNewHourMinuteSecond(lastDate, 8+i, 1+i, 20+i);
             product.setDateOfManufacture(lastDate);
             productsInWarehouse.set(i, product);
         }
    }

    private static void fixNewYearMountDay(Calendar calendar, int year, int month, int day){

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
    }

    private static void fixNewHourMinuteSecond(Calendar calendar, int hour, int minute, int second){

        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
    }

    private static String getStringInfoListProducts(String source, boolean fullInfo, List<Product> listProducts){

        String infoProducts = "";
        if(fullInfo){
            System.out.println(source + " Полная информация.");
            for(int i=0; i<listProducts.size(); i++){
                infoProducts = infoProducts.concat("Товар №:" + (i+1) +"\n"+ listProducts.get(i).toString()+"\n\n");
            }
        } else {
            System.out.println(source + " Сокращенная информация.");
            for(int i=0; i<listProducts.size(); i++){
                infoProducts = infoProducts.concat("Товар №:" + (i+1) +" "+ listProducts.get(i).getName()+"\n");
            }
        }

        return infoProducts;
    }

    private static  String getStringInfoListOrders(String source, boolean fullInfo, List<Order> listOrders){

        String infoOrders = "";
        if(fullInfo){
            System.out.println(source + " Полная информация.");
            for(int i=0; i<listOrders.size(); i++){
                infoOrders = infoOrders.concat("Заказ №:" + (i+1) +"\n"+ listOrders.get(i).toString()+"\n");
            }
        } else {
            System.out.println(source + " Сокращенная информация.");
            for(int i=0; i<listOrders.size(); i++){

                infoOrders = infoOrders.concat("Заказ №:" + (i+1) +"\n"+ listOrders.get(i).getShortenedInfoProducts() +"\n");
            }
        }

        return infoOrders;
    }

    public static void startApplication() {

        unloadProductsInWarehouse(PRODUCTS_NAMES);
        fixDateProductsInWarehouse();
        //productsInWarehouse.forEach( nextProduct -> System.out.println(nextProduct.toString()) );
        System.out.println(getStringInfoListProducts("Перечень товаров на СКЛАДЕ:",false, productsInWarehouse));

        Order order = new Order(1);
        order.addProducts(productsInWarehouse);
        listOrders.add(order);
        listOrders.add(new Order(2, productsInWarehouse));
        listOrders.add(new Order(3, productsInWarehouse));
        System.out.print(getStringInfoListOrders( "Перечень заказов в МАГАЗИНЕ:",false,listOrders));

    }

    private static void menuDialog() {

    }

    private Shop() {
    }
}
