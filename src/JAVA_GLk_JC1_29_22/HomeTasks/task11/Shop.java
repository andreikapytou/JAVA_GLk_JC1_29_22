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
                if(i<(listProducts.size()-1)) {
                    infoProducts = infoProducts.concat("\nТовар №:" + (i + 1) + "\n" + listProducts.get(i).toString() + "\n");
                } else {
                    infoProducts = infoProducts.concat("\nТовар №:" + (i + 1) + "\n" + listProducts.get(i).toString() + "");
                }
            }
        } else {
            System.out.println(source + " Сокращенная информация.");
            for (int i = 0; i < listProducts.size(); i++) {
                if (i==0) {
                    infoProducts = infoProducts.concat("\nТовар №:" + (i + 1) + " " + listProducts.get(i).getName() + "\n");
                }
                else if(i<(listProducts.size()-1)) {
                    infoProducts = infoProducts.concat("Товар №:" + (i + 1) + " " + listProducts.get(i).getName() + "\n");
                } else {
                    infoProducts = infoProducts.concat("Товар №:" + (i + 1) + " " + listProducts.get(i).getName() + "");
                }
            }
        }
        return infoProducts;
    }

    public String getStringInfoListOrders(String source, boolean fullInfo, List<Order> listOrders) {

        String infoOrders = "";
        if (fullInfo) {
            System.out.println(source + " Полная информация.");
            for (int i = 0; i < listOrders.size(); i++) {
                infoOrders = infoOrders.concat("\nЗаказ №:" + (i + 1) + "\n" + listOrders.get(i).toString() + "\n");
            }
        } else {
            System.out.println(source + " Сокращенная информация.");
            for (int i = 0; i < listOrders.size(); i++) {

                if(listOrders.get(i).getProducts().size() > 0) {
                    infoOrders = infoOrders.concat("\nЗаказ №:" + (i + 1) + "\n" +
                            listOrders.get(i).getShortenedInfoProducts() + "\n");
                } else {
                    infoOrders = infoOrders.concat("\nЗаказ №:" + (i + 1) + " - " +
                            listOrders.get(i).getShortenedInfoProducts() + "\n");
                }
            }
        }
        return infoOrders;
    }


    public void addProductInWarehouse(Product product){

        productsInWarehouse.add(product);
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

    public void delProductInCurrentOrder(int index){
        if(countOrders > 0 && (listOrders.get(countOrders-1).getProducts().size() > 0)) {
            listOrders.get(countOrders-1).delProduct(index);
        } else {
            System.out.printf("Введенный номер №:%d товара не входит в диапазон допустимых значений.\n", index);
        }
    }

    public Product getProductInCurrentOrder(int index){

      return listOrders.get(countOrders-1).getProduct(index);
    }

    public int getSizeProductsInCurrentOrder(){

        if(countOrders > 0) {

            return listOrders.get(countOrders - 1).getProducts().size();
        }
        return 0;
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

    public void addProductsInBasketInCurrentOrder(){

        if(countOrders > 0) {
            listOrders.get(countOrders-1).addProducts(productsInBasket);
            productsInBasket.clear();
        }
    }

    public Product getProductInBasket(int index) {
        return productsInBasket.get(index);
    }

    public void delProductInBasket(int index){

      productsInBasket.remove(index);

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
