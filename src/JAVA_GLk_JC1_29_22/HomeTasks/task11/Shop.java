package JAVA_GLk_JC1_29_22.HomeTasks.task11;

import java.util.*;

public class Shop {

    private static List<Product> productsInWarehouse = new ArrayList<>();
    private List<Product> productsInBasket = new ArrayList<>();
    private static List<Order> listOrders = new ArrayList<>();


    private void basket() {

    }

    public void unloadProductsInWarehouse(String[] productsNames) {

        for(int i=0; i< productsNames.length; i++){
            productsInWarehouse.add(new Product(i+1, productsNames[i]));
        }

        Calendar dataProduct = new GregorianCalendar();
        fixNewYearMountDay(dataProduct, 1999, 11, 1);
        fixNewHourMinuteSecond(dataProduct, 23, 12, 30);
        productsInWarehouse.add(new Product(123, "Ваза", dataProduct));
     }

    public void fixDateProductsInWarehouse(){

         for(int i = 0; i<productsInWarehouse.size()-1; i++){

             Product product = productsInWarehouse.get(i);
             Calendar lastDate =  product.getDateOfManufacture();
             fixNewYearMountDay(lastDate, 2000+i, 1+i, 1+i);
             fixNewHourMinuteSecond(lastDate, 8+i, 1+i, 20+i);
             product.setDateOfManufacture(lastDate);
             productsInWarehouse.set(i, product);
         }
    }

    private void fixNewYearMountDay(Calendar calendar, int year, int month, int day){

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
    }

    private void fixNewHourMinuteSecond(Calendar calendar, int hour, int minute, int second){

        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
    }

    public String getStringInfoListProducts(String source, boolean fullInfo, List<Product> listProducts){

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

    public String getStringInfoListOrders(String source, boolean fullInfo, List<Order> listOrders){

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

    public void startApplication() {

        //productsInWarehouse.forEach( nextProduct -> System.out.println(nextProduct.toString()) );

        Order order = new Order(1);
        order.addProducts(productsInWarehouse);
        order.addProduct( new Product(666, "Галеты"));
        listOrders.add(order);
        listOrders.add(new Order(2, productsInWarehouse));
        listOrders.add(new Order(3, productsInWarehouse));
        System.out.print(getStringInfoListOrders( "Перечень заказов в МАГАЗИНЕ:",false,listOrders));

    }

    public static List<Product> getProductsInWarehouse() {
        return productsInWarehouse;
    }

    public List<Product> getProductsInBasket() {
        return productsInBasket;
    }

    public static List<Order> getListOrders() {
        return listOrders;
    }

    public Shop() {
    }
}
