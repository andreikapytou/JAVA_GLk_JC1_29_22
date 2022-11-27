package JAVA_GLk_JC1_29_22.HomeTasks.task11;

import java.util.*;

public class Shop {

    private static final String[] PRODUCTS_NAMES1 = {"Очки", "Плавки", "Велосипед", "Нож", "Чашка", "Лампа", "Книга",
            "Дрель", "Отвертка", "Колесо", "Проволока", "Поднос", "Ведро", "Веревка"};
    private static final String[] PRODUCTS_NAMES2 = {"Вилка", "Ботинки", "Скатерть", "Топор", "Термос", "Лопата", "Спички"};

    private static final String[] PRODUCTS_NAMES3 = {"Веревка", "Свечка", "Штопор", "Палатка"};

    private static final String[][] arrProductNames = {PRODUCTS_NAMES1, PRODUCTS_NAMES2, PRODUCTS_NAMES3};

    private int countUnload;
    private int fixIdOrder = 1;

    private int countOrders;

    private List<Product> productsInWarehouse = new ArrayList<>();
    private List<Product> productsInBasket = new ArrayList<>();
    private List<Order> listOrders = new ArrayList<>();


    private void basket() {

    }

    public void unloadNextProductsInWarehouse() {

        if (countUnload < arrProductNames.length) {
            unloadProductsInWarehouse(arrProductNames[countUnload++]);
        } else {
            System.out.println("\nТовары для отгрузки на склад - отсутствуют!\n");
            countUnload = 0;
        }
    }

    private void unloadProductsInWarehouse(String[] productsNames) {

        MyData myData = new MyData();

        for (int i = 0; i < productsNames.length; i++) {

            Calendar dataProduct = myData.fixDataProduct();
            productsInWarehouse.add(new Product(i + 1, productsNames[i], dataProduct));
        }
    }

    private void fixDateProductsInWarehouse() {

        MyData myData = new MyData();

        for (int i = 0; i < productsInWarehouse.size() - 1; i++) {

            Product product = productsInWarehouse.get(i);
            Calendar lastDate = product.getDateOfManufacture();
            myData.fixDataProduct(lastDate);
            product.setDateOfManufacture(lastDate);
            productsInWarehouse.set(i, product);
        }
    }

    public String getStringInfoListProducts(String source, boolean fullInfo, List<Product> listProducts) {

        String infoProducts = "";
        if (fullInfo) {
            System.out.println(source + " Полная информация.");
            for (int i = 0; i < listProducts.size(); i++) {
                infoProducts = infoProducts.concat("Товар №:" + (i + 1) + "\n" + listProducts.get(i).toString() + "\n\n");
            }
        } else {
            System.out.println(source + " Сокращенная информация.");
            for (int i = 0; i < listProducts.size(); i++) {
                infoProducts = infoProducts.concat("Товар №:" + (i + 1) + " " + listProducts.get(i).getName() + "\n");
            }
        }

        return infoProducts;
    }

    public String getStringInfoListOrders(String source, boolean fullInfo, List<Order> listOrders) {

        String infoOrders = "";
        if (fullInfo) {
            System.out.println(source + " Полная информация.");
            for (int i = 0; i < listOrders.size(); i++) {
                infoOrders = infoOrders.concat("Заказ №:" + (i + 1) + "\n" + listOrders.get(i).toString() + "\n");
            }
        } else {
            System.out.println(source + " Сокращенная информация.");
            for (int i = 0; i < listOrders.size(); i++) {

                infoOrders = infoOrders.concat("Заказ №:" + (i + 1) + "\n" + listOrders.get(i).getShortenedInfoProducts() + "\n");
            }
        }

        return infoOrders;
    }

    public void startApplication() {

        //productsInWarehouse.forEach( nextProduct -> System.out.println(nextProduct.toString()) );

        Order order = new Order(1);
        order.addProducts(productsInWarehouse);
        order.addProduct(new Product(666, "Галеты"));
        listOrders.add(order);
        listOrders.add(new Order(2, productsInWarehouse));
        listOrders.add(new Order(3, productsInWarehouse));
        System.out.print(getStringInfoListOrders("Перечень заказов в МАГАЗИНЕ:", false, listOrders));

    }

    public Product getProductInWarehouse(int index){

        return productsInWarehouse.get(index);
    }

    public Product removeProductInWarehouse(int index){

        return productsInWarehouse.remove(index);
    }

    public void addProductCurrentOrderFromWarehouse(int index){
        if(countOrders > 0) {
            listOrders.get(countOrders-1).addProduct(productsInWarehouse.get(index));
        }
    }

    public void addOrder(){
        listOrders.add(new Order(fixIdOrder++));
        countOrders++;
    }

    public void removeOrder(int index){
        listOrders.remove(index);
        countOrders--;
    }

    public void addProductInBasketFromWarehouse(int index){

        productsInBasket.add(productsInWarehouse.get(index));
    }

    public void removeProductInBasket(int index){

        if ( productsInBasket.size() >0 ) {

            if ( (index >0) && (index < productsInBasket.size()) ) {

                productsInBasket.add(productsInWarehouse.get(index));
            }
        }
   }

    public List<Product> getProductsInWarehouse() {
        return productsInWarehouse;
    }

    public List<Product> getProductsInBasket() {
        return productsInBasket;
    }

    public List<Order> getListOrders() {
        return listOrders;
    }

    public int getCountOrders() {
        return countOrders;
    }

    public Shop() {
    }
}
