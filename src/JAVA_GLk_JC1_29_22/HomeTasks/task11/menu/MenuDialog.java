package JAVA_GLk_JC1_29_22.HomeTasks.task11.menu;

import JAVA_GLk_JC1_29_22.HomeTasks.task11.Shop;

import java.util.Scanner;

public class MenuDialog {


    private static final int NO_INT = -1567890895;

    private MenuDialog() {

    }

    public static void startApplication() {

        Shop shop = new Shop();
        shop.unloadNextProductsInWarehouse();
        chooseMenuBasicAction(shop);
    }

    private static void chooseMenuBasicAction(Shop shop) {

        String selectedAction;
        do {
            printTextMenuBasicAction();
            selectedAction = inputStringConsole();
            makeSelectedBaseAction(shop, selectedAction);
        }
        while(!isCheckExitCondition(selectedAction));

        System.out.println("Выход.");
    }

    private static void printTextMenuBasicAction() {

        System.out.println("Выбирете одно из желаемых действий:");
        System.out.println();
        System.out.printf(" %s -  Вывести список товаров доступных для заказа.\n", ConstantMenu.LIST_PRODUCTS_ACT1);
        System.out.printf(" %s -  Вывести список товаров в корзине.\n", ConstantMenu.LIST_PRODUCTS_BASKET_ACT2);
        System.out.printf(" %s -  Вывести список закзов.\n", ConstantMenu.LIST_ORDERS_ACT3);
        System.out.printf(" %s -  Добавить - создать новый заказ.\n", ConstantMenu.ADD_ORDER_ACT4);
        System.out.printf(" %s -  Удалить заказ.\n", ConstantMenu.DEL_ORDER_ACT5);
        System.out.printf(" %s -  Редактировать - существующие заказы.\n", ConstantMenu.EDIT_ORDER_ACT6);
        System.out.printf(" %s -  Добавить товар к текущему заказу.\n", ConstantMenu.ADD_PROD_ORDER_ACT7);
        System.out.printf(" %s -  Удалить товар из текущего заказа.\n", ConstantMenu.DEL_PROD_ORDER_ACT8);
        System.out.printf(" %s -  Добавить товар в корзину.\n", ConstantMenu.ADD_PROD_BASKET_ACT9);
        System.out.printf(" %s - Удалить товар из корзины.\n", ConstantMenu.DEL_PROD_BASKET_ACT10);
        System.out.printf(" %s - Добавить все товары из корзины к текущему заказу.\n", ConstantMenu.ADD_ALL_PROD_ORDER_ACT11);
        System.out.println(" Q -  Выход из программы.");
        System.out.println();
        System.out.print("Введите номер желаемого дейсвия и нажмите клавишу Enter : ");
    }

    private static void makeSelectedBaseAction(Shop shop, String action){

        if(action.equals(ConstantMenu.LIST_PRODUCTS_ACT1)) {
            chooseSubMenuAction123("Для вывода на консоль списка товаров для заказа следуйте инструкции.",
                    shop, ConstantMenu.LIST_PRODUCTS_ACT1);
        } else if (action.equals(ConstantMenu.LIST_PRODUCTS_BASKET_ACT2)) {
            chooseSubMenuAction123("Для вывода на консоль списка товаров в корзине следуйте инструкции.",
                    shop, ConstantMenu.LIST_PRODUCTS_BASKET_ACT2);
        } else if (action.equals(ConstantMenu.LIST_ORDERS_ACT3)) {
            chooseSubMenuAction123("Для вывода на консоль списка заказов следуйте инструкции.",
                    shop, ConstantMenu.LIST_ORDERS_ACT3);
        } else if (action.equals(ConstantMenu.ADD_ORDER_ACT4)) {
             chooseSubMenuAddOrderAction4("Добавлен новый заказ. ID №: ", shop);
        } else if (action.equals(ConstantMenu.DEL_ORDER_ACT5)) {
            chooseSubMenuDelOrderAction5("Для удаления заказа следуйте инструкции.", shop);
        } else if (action.equals(ConstantMenu.EDIT_ORDER_ACT6)) {
            chooseSubMenuEditOrderAction6("Пункт меню № 6 в стадии разработки.", shop);
        } else if (action.equals(ConstantMenu.ADD_PROD_ORDER_ACT7)) {
            chooseSubMenuAddProductOrderAction7( "Для добавления товара к текущему заказу следуйте инструкции.", shop);
        } else if (action.equals(ConstantMenu.DEL_PROD_ORDER_ACT8)) {

        } else if (action.equals(ConstantMenu.ADD_PROD_BASKET_ACT9)) {
            chooseSubMenuAddProductInBasketAction9("Для добавления товара в корзину следуйте инструкции.", shop);
        } else if (action.equals(ConstantMenu.DEL_PROD_BASKET_ACT10)) {

        } else if (action.equals(ConstantMenu.ADD_ALL_PROD_ORDER_ACT11)) {

        } else if (isCheckExitCondition(action)) {
            System.out.println("Выход из программы.");
        } else {
            System.out.printf("Введен №:%s - действие с данным номером отсутсвует в меню.\n\n", action);
        }
    }

    private static void printFullTextSubMenuAction123(String title, Shop shop, String action) {

        System.out.println(title);

        if(action.equals(ConstantMenu.LIST_PRODUCTS_ACT1)){
            SubMenuText.printListAction123("Список товаров доступных для заказа", shop.getProductsInWarehouse().size());
        } else if (action.equals(ConstantMenu.LIST_PRODUCTS_BASKET_ACT2)) {
            SubMenuText.printListAction123("Список товаров в корзине", shop.getProductsInBasket().size());
        } else if (action.equals(ConstantMenu.LIST_ORDERS_ACT3)) {
            SubMenuText.printListAction123("Список заказов", shop.getListOrders().size());
        }
    }

    private static void chooseSubMenuAction123(String title, Shop shop, String action) {

        String subAction;
        do {
            printFullTextSubMenuAction123(title, shop, action);
            subAction = inputStringConsole();
            makeSelectedSubAction12(shop, action, subAction);
        }
        while(!isCheckExitCondition(subAction));
    }

    private static void makeSelectedSubAction12(Shop shop, String action, String subAction){

        if(subAction.equals(ConstantMenu.SUB_ACTION1)){
            printInfoAction123(shop, action, true);
        } else if (subAction.equals(ConstantMenu.SUB_ACTION2)){
            printInfoAction123(shop, action, false);
        } else if (isCheckExitCondition(subAction)) {
            System.out.println("Возврат в главное меню.\n");
        } else {
            System.out.printf("Введен №:%s - действие с данным номером отсутствует в под-меню.\n", subAction);
        }
    }

    private static void chooseSubMenuAddOrderAction4(String title, Shop shop) {

        shop.addOrder();
        System.out.println(title + shop.getListOrders().get(shop.getCountOrders() - 1).getIdNumber());
        makeSubMenuExit();
    }

    private static void chooseSubMenuDelOrderAction5(String title, Shop shop) {

        String subAction = "";
        do {
                SubMenuText.printAction5(title, ConstantMenu.SUB_ACTION1, shop.getListOrders().size());
                subAction = inputStringConsole();
                makeSelectedDelOrderSubAction5(shop, subAction);
         }
        while(!isCheckExitCondition(subAction));
    }

    private static void makeSelectedDelOrderSubAction5(Shop shop, String subAction){

        if(subAction.equals(ConstantMenu.SUB_ACTION1)){
            if( shop.getListOrders().size()>0) {

                System.out.print("Введите номер удаляемого заказа : ");
                int removeNumber = inputNumberParseInt();
                if(removeNumber == NO_INT) {
                    return;
                }

                if((removeNumber > 0) && (removeNumber <= shop.getListOrders().size())){
                    shop.removeOrder(removeNumber-1);
                    System.out.println("Удален заказ № " + removeNumber);
                } else {
                    System.out.printf("Введенный номер №:%d не входит в диапазон допустимых значений.\n", removeNumber);
                }
            }
        } else if (isCheckExitCondition(subAction)) {
            System.out.println("Возврат в главное меню.\n");
        } else {
            System.out.printf("Введен №:%s - действие с данным номером отсутствует в под-меню.\n", subAction);
        }
    }

    private static void chooseSubMenuEditOrderAction6(String title, Shop shop) {

        System.out.println(title);
        makeSubMenuExit();
    }

    private static void chooseSubMenuAddProductOrderAction7(String title, Shop shop) {

        String subAction = "";
        do {
            SubMenuText.printAction7(title, ConstantMenu.SUB_ACTION1, shop.getListOrders().size() );
            subAction = inputStringConsole();
            makeSelectedAddProduct(ConstantMenu.ADD_PROD_ORDER_ACT7, subAction, shop);
        }
        while(!isCheckExitCondition(subAction));
    }

    private static void makeSelectedAddProduct(String basicAction, String subAction, Shop shop){

        if(subAction.equals(ConstantMenu.SUB_ACTION1)){
            alternativeAdd(basicAction, shop);
        } else if (isCheckExitCondition(subAction)) {
            System.out.println("Возврат в главное меню.\n");
        } else {
            System.out.printf("Введен №:%s - действие с данным номером отсутствует в под-меню.\n", subAction);
        }
    }

    private static void alternativeAdd(String basicAction, Shop shop) {

        if(basicAction.equals(ConstantMenu.ADD_PROD_ORDER_ACT7)) {
            addProductInOrder(shop);
        } else if(basicAction.equals(ConstantMenu.ADD_PROD_BASKET_ACT9)) {
            addProduct(ConstantMenu.ADD_PROD_BASKET_ACT9, shop);
        }
    }

    private static void addProductInOrder(Shop shop) {

        if( shop.getListOrders().size()>0) {
            addProduct(ConstantMenu.ADD_PROD_ORDER_ACT7, shop);
        }
    }

    private static void addProduct( String basicAction, Shop shop) {

        printTitleOtherAction(basicAction);

        int addNumber = inputNumberParseInt();
        if(addNumber == NO_INT) {
            return;
        }
        if((addNumber > 0) && (addNumber <= shop.getProductsInWarehouse().size())){

            addProductInOtherSource(addNumber, basicAction, shop);
            shop.removeProductInWarehouse(addNumber-1);

        } else {
            System.out.printf("Введенный номер №:%d не входит в диапазон допустимых значений.\n", addNumber);
        }
    }

    private static void addProductInOtherSource(int addProductNumber, String basicAction, Shop shop) {

        if(basicAction.equals(ConstantMenu.ADD_PROD_ORDER_ACT7)) {
            shop.addProductCurrentOrderFromWarehouse(addProductNumber - 1);
            System.out.printf("Добавлен новый товар -> %s к заказу №:%d \n",
                    shop.getProductInWarehouse(addProductNumber-1).getName(), shop.getCountOrders());
        } else if (basicAction.equals(ConstantMenu.ADD_PROD_BASKET_ACT9)) {
            shop.addProductInBasketFromWarehouse(addProductNumber-1);
            System.out.printf("Добавлен новый товар -> %s в корзину\n",
                    shop.getProductInWarehouse(addProductNumber-1).getName());
        }
    }

    private static void printTitleOtherAction(String basicAction) {

        if(basicAction.equals(ConstantMenu.ADD_PROD_ORDER_ACT7)) {
            System.out.print("Введите номер добавляемого товара к заказу : ");
        } else if (basicAction.equals(ConstantMenu.ADD_PROD_BASKET_ACT9)) {
            System.out.print("Введите номер добавляемого товара в корзину : ");
        }
    }

    private static void chooseSubMenuAddProductInBasketAction9(String title, Shop shop) {

        String subAction = "";
        do {
            SubMenuText.printAction9(title, ConstantMenu.SUB_ACTION1 );
            subAction = inputStringConsole();
        //    makeSelectedAddProductInBasketSubAction9(shop, subAction);
            makeSelectedAddProduct(ConstantMenu.ADD_PROD_BASKET_ACT9, subAction, shop);
        }
        while(!isCheckExitCondition(subAction));
    }

    private static void makeSelectedAddProductInBasketSubAction9(Shop shop, String subAction){

        if(subAction.equals(ConstantMenu.SUB_ACTION1)){

            addProductInBasket(shop);

        } else if (isCheckExitCondition(subAction)) {
            System.out.println("Возврат в главное меню.\n");
        } else {
            System.out.printf("Введен №:%s - действие с данным номером отсутствует в под-меню.\n", subAction);
        }
    }

    private static void addProductInBasket(Shop shop){

        System.out.print("Введите номер добавляемого товара в корзину : ");
        int addNumber = inputNumberParseInt();
        if(addNumber == NO_INT) {
            return;
        }
        if((addNumber > 0) && (addNumber <= shop.getProductsInWarehouse().size())){

            shop.addProductInBasketFromWarehouse(addNumber-1);

            System.out.printf("Добавлен новый товар -> %s в корзину\n",
                    shop.getProductInWarehouse(addNumber-1).getName());
            shop.removeProductInWarehouse(addNumber-1);

        } else {
            System.out.printf("Введенный номер №:%d не входит в диапазон допустимых значений.\n", addNumber);
        }
    }


    private static void printInfoAction123(Shop shop, String action, boolean fullInfo){

        if(action.equals(ConstantMenu.LIST_PRODUCTS_ACT1) && (shop.getProductsInWarehouse().size()>0) ) {
            System.out.println(shop.getStringInfoListProducts("Перечень товаров на СКЛАДЕ:",
                    fullInfo, shop.getProductsInWarehouse()));
        } else if (action.equals(ConstantMenu.LIST_PRODUCTS_BASKET_ACT2) && (shop.getProductsInBasket().size()>0)) {
            System.out.println(shop.getStringInfoListProducts("Перечень товаров в КОРЗИНЕ:",
                    fullInfo, shop.getProductsInBasket()));
        } else if (action.equals(ConstantMenu.LIST_ORDERS_ACT3) && (shop.getListOrders().size()>0)) {
            System.out.print(shop.getStringInfoListOrders("Перечень заказов в МАГАЗИНЕ:",
                    fullInfo, shop.getListOrders()));
        }
    }

    private static void makeSubMenuExit() {

        String subAction = "";
        do {
            SubMenuText.printExit();
            subAction = inputStringConsole();
            if(!isCheckExitCondition(subAction)){
                System.out.printf("Введен №:%s - действие с данным номером отсутсвует в под-меню.\n\n", subAction);
            }
        }
        while(!isCheckExitCondition(subAction));
    }

    private static boolean isCheckExitCondition(String condition){

        return condition.equals(ConstantMenu.EXIT1) || condition.equals(ConstantMenu.EXIT2);
    }

    private static int inputNumberParseInt() {

        int intRemoveNumber = NO_INT;
        String strRemoveNumber = inputStringConsole();
        try
        {
            intRemoveNumber = Integer.parseInt(strRemoveNumber.trim());
        }
        catch (NumberFormatException nfe)
        {
            System.out.printf("Введенный номер №:%s не является числом.\n", strRemoveNumber);
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

        return intRemoveNumber;
    }

    private static String inputStringConsole() {

        Scanner inputData = new Scanner(System.in);
        return inputData.nextLine();
    }

    private static int inputIntConsole() {

        Scanner inputData = new Scanner(System.in);
        return inputData.nextInt();
    }
}
