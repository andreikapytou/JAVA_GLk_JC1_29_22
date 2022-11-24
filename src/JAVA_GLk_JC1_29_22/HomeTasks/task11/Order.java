package JAVA_GLk_JC1_29_22.HomeTasks.task11;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Order {

    private Integer idNumber;

    private Calendar date;

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {

        products.add(product);
    }

    public void delProduct(int indexProduct) {

        products.remove(indexProduct);
    }

    public void addProducts(Collection<? extends Product> prod) {

        products.addAll(prod);
    }

    public void delAllProducts() {

        products.clear();
    }

    public String getFullInfoProducts( ){

        String infoFullProducts = "";
        for(int i=0; i<products.size(); i++){
            infoFullProducts = infoFullProducts.concat("Товар №:" + (i+1) +"\n"+ products.get(i).toString()+"\n");
        }
        return infoFullProducts;
    }

    public String getShortenedInfoProducts( ) {

        String infoProducts = "";
        for (int i = 0; i < products.size(); i++) {
            infoProducts = infoProducts.concat("Товар №:" + (i + 1) +" "+ products.get(i).getName() + "\n");
        }
        return infoProducts;
    }


    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy HH:mm:ss", new Locale("ru"));

        return "ID номер заказа = " + idNumber +"\n"+
                "Дата заказа     = " + df.format(date.getTime())+"\n"+"-----------------------------------------------"+
                "\n"+ getFullInfoProducts();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Objects.equals(idNumber, order.idNumber) && Objects.equals(date, order.date) && Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumber, date, products);
    }

    public Order(Integer idNumber, Collection<? extends Product> prod) {

        this.idNumber = idNumber;
        products.addAll(prod);
        date = new GregorianCalendar();
    }

    public Order(Integer idNumber) {

        this.idNumber = idNumber;
        date = new GregorianCalendar();
    }

    public Order() {
    }
}
