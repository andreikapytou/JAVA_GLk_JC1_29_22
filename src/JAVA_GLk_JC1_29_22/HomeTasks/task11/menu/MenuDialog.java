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
        chooseMenuBaseAction(shop);
    }

    private static void chooseMenuBaseAction(Shop shop) {

        String selectBaseAction;
        do {
            SubMenuText.printTextMenuBasicAction();
            selectBaseAction = inputStringConsole();
            makeSelectedBaseAction(shop, selectBaseAction);
        }
        while(!isCheckExitCondition(selectBaseAction));

        System.out.println("Выход.");
    }

    private static void makeSelectedBaseAction(Shop shop, String action){

        if(action.equals(ConstantMenu.LIST_PRODUCTS_ACT1)) {
            chooseSubMenuAction123(ConstantMenu.LIST_PRODUCTS_ACT1, shop);
        } else if (action.equals(ConstantMenu.LIST_PRODUCTS_BASKET_ACT2)) {
            chooseSubMenuAction123(ConstantMenu.LIST_PRODUCTS_BASKET_ACT2, shop);
        } else if (action.equals(ConstantMenu.LIST_ORDERS_ACT3)) {
            chooseSubMenuAction123(ConstantMenu.LIST_ORDERS_ACT3 ,shop);
        } else if (action.equals(ConstantMenu.ADD_ORDER_ACT4)) {
             chooseSubMenuAction4(ConstantMenu.ADD_ORDER_ACT4 , shop);
        } else if (action.equals(ConstantMenu.DEL_ORDER_ACT5)) {
            chooseSubMenuAction5(ConstantMenu.DEL_ORDER_ACT5, shop);
        } else if (action.equals(ConstantMenu.EDIT_ORDER_ACT6)) {
            chooseSubMenuAction6(ConstantMenu.EDIT_ORDER_ACT6, shop);
        } else if (action.equals(ConstantMenu.ADD_PROD_ORDER_ACT7)) {
            chooseSubMenuAction7(ConstantMenu.ADD_PROD_ORDER_ACT7, shop);
        } else if (action.equals(ConstantMenu.DEL_PROD_ORDER_ACT8)) {
            chooseSubMenuAction8(ConstantMenu.DEL_PROD_ORDER_ACT8, shop);
        } else if (action.equals(ConstantMenu.ADD_PROD_BASKET_ACT9)) {
            chooseSubMenuAction9(ConstantMenu.ADD_PROD_BASKET_ACT9, shop);
        } else if (action.equals(ConstantMenu.DEL_PROD_BASKET_ACT10)) {
            chooseSubMenuAction10(ConstantMenu.DEL_PROD_BASKET_ACT10, shop);
        } else if (action.equals(ConstantMenu.ADD_ALL_PROD_ORDER_ACT11)) {
            chooseSubMenuAction11(ConstantMenu.DEL_PROD_BASKET_ACT10, shop);
        } else if (isCheckExitCondition(action)) {
            System.out.println("Выход из программы.");
        } else {
            System.out.printf("Введен №:%s - действие с данным номером отсутсвует в меню.\n\n", action);
        }
    }

    private static void chooseSubMenuAction123(String action, Shop shop) {

        String subAction;
        do {
            SubMenuText.printTitleOtherAction(action);
            printFullTextSubMenuAction123(action, shop);
            subAction = inputStringConsole();
            makeSelectedSubAction123(action, subAction, shop);
        }
        while(!isCheckExitCondition(subAction));
    }

    private static void chooseSubMenuAction4(String action, Shop shop) {

        shop.addOrder();
        SubMenuText.printTitleOtherAction(action);
        makeSubMenuExit();
    }

    private static void chooseSubMenuAction5(String action, Shop shop) {

        String subAction;
        do {
            SubMenuText.printTitleOtherAction(action);
            SubMenuText.printTexOneSubActionToOtherActions(action, shop.getListOrders().size());
            subAction = inputStringConsole();
            makeSelectedOneSubAction(action, subAction, shop);
        }
        while(!isCheckExitCondition(subAction));
    }

    private static void chooseSubMenuAction6(String action, Shop shop) {

        SubMenuText.printTitleOtherAction(action);
        makeSubMenuExit();
    }

    private static void chooseSubMenuAction7(String action, Shop shop) {

        String subAction;
        do {
            SubMenuText.printTitleOtherAction(action);
            SubMenuText.printTexOneSubActionToOtherActions(action, shop.getListOrders().size());
            subAction = inputStringConsole();
            makeSelectedOneSubAction(action, subAction, shop);
        }
        while(!isCheckExitCondition(subAction));
    }


    private static void chooseSubMenuAction8(String action, Shop shop) {

        String subAction;
        do {
            SubMenuText.printTitleOtherAction(action);
            SubMenuText.printTexOneSubActionToOtherActions(action, shop.getListOrders().size(), shop.getSizeProductsInCurrentOrder());
            subAction = inputStringConsole();
            makeSelectedOneSubAction(action, subAction, shop);
        }
        while(!isCheckExitCondition(subAction));
    }

    private static void chooseSubMenuAction9(String action, Shop shop) {

        String subAction;
        do {
            SubMenuText.printTitleOtherAction(action);
            SubMenuText.printTexOneSubActionToOtherActions(action);
            subAction = inputStringConsole();
            makeSelectedOneSubAction(action, subAction, shop);
        }
        while(!isCheckExitCondition(subAction));
    }

    private static void chooseSubMenuAction10(String action, Shop shop) {

        String subAction;
        do {
            SubMenuText.printTitleOtherAction(action);
            SubMenuText.printTexOneSubActionToOtherActions(action, shop.getProductsInBasket().size());
            subAction = inputStringConsole();
            makeSelectedOneSubAction(action, subAction, shop);
        }
        while(!isCheckExitCondition(subAction));
    }

    private static void chooseSubMenuAction11(String action, Shop shop) {

        if (shop.getListOrders().size() >0) {
            if (shop.getProductsInBasket().size() > 0) {
                shop.addProductsInBasketInCurrentOrder();
                System.out.println(("\nДобавлнеы все товары из корзины к текущему заказу."));
                return;
            } else {
                System.out.println("Список товаров в корзине - ПУСТ.");
            }
        } else {
            System.out.println("Список заказов - ПУСТ.");
        }
        makeSubMenuExit();
    }

    private static void printFullTextSubMenuAction123(String basicAction, Shop shop) {

        if(basicAction.equals(ConstantMenu.LIST_PRODUCTS_ACT1)){
            SubMenuText.printListAction123("Список товаров доступных для заказа", shop.getProductsInWarehouse().size());
        } else if (basicAction.equals(ConstantMenu.LIST_PRODUCTS_BASKET_ACT2)) {
            SubMenuText.printListAction123("Список товаров в корзине", shop.getProductsInBasket().size());
        } else if (basicAction.equals(ConstantMenu.LIST_ORDERS_ACT3)) {
            SubMenuText.printListAction123("Список заказов", shop.getListOrders().size());
        }
    }
    private static void makeSelectedSubAction123(String basicAction, String subAction, Shop shop){

        if(subAction.equals(ConstantMenu.SUB_ACTION1)){
            printInfoListAction123(shop, basicAction, true);
        } else if (subAction.equals(ConstantMenu.SUB_ACTION2)){
            printInfoListAction123(shop, basicAction, false);
        } else if (isCheckExitCondition(subAction)) {
            System.out.println("Возврат в главное меню.\n");
        } else {
            System.out.printf("Введен №:%s - действие с данным номером отсутствует в под-меню.\n", subAction);
        }
    }

    private static void printInfoListAction123(Shop shop, String action, boolean fullInfo){

        if(action.equals(ConstantMenu.LIST_PRODUCTS_ACT1) && (shop.getProductsInWarehouse().size()>0) ) {
            System.out.println(shop.getStringInfoListProducts("\nПеречень товаров на СКЛАДЕ:",
                    fullInfo, shop.getProductsInWarehouse()));
        } else if (action.equals(ConstantMenu.LIST_PRODUCTS_BASKET_ACT2) && (shop.getProductsInBasket().size()>0)) {
            System.out.println(shop.getStringInfoListProducts("\nПеречень товаров в КОРЗИНЕ:",
                    fullInfo, shop.getProductsInBasket()));
        } else if (action.equals(ConstantMenu.LIST_ORDERS_ACT3) && (shop.getListOrders().size()>0)) {
            System.out.print(shop.getStringInfoListOrders("\nПеречень заказов в МАГАЗИНЕ:",
                    fullInfo, shop.getListOrders()));
        }
    }

    private static void makeSelectedOneSubAction(String basicAction, String subAction, Shop shop){

        if(subAction.equals(ConstantMenu.SUB_ACTION1)){
            alternativeOneSubAction(basicAction, shop);
        } else if (isCheckExitCondition(subAction)) {
            System.out.println("Возврат в главное меню.\n");
        } else {
            System.out.printf("Введен №:%s - действие с данным номером отсутствует в под-меню.\n", subAction);
        }
    }

    private static void alternativeOneSubAction(String basicAction, Shop shop) {

        if(basicAction.equals(ConstantMenu.DEL_ORDER_ACT5)) {
            actionToOrder(basicAction, shop);
        } else if(basicAction.equals(ConstantMenu.ADD_PROD_ORDER_ACT7)) {
            actionToOrder(basicAction, shop);
        } else if(basicAction.equals(ConstantMenu.DEL_PROD_ORDER_ACT8)) {
            actionToOrder(basicAction, shop);
        } else if(basicAction.equals(ConstantMenu.ADD_PROD_BASKET_ACT9)) {
            addProduct(ConstantMenu.ADD_PROD_BASKET_ACT9, shop);
        } else if(basicAction.equals(ConstantMenu.DEL_PROD_BASKET_ACT10)) {
            delProduct(ConstantMenu.DEL_PROD_BASKET_ACT10, shop);
        }
    }

    private static void actionToOrder(String basicAction, Shop shop) {

        if( shop.getListOrders().size()>0) {

            if(basicAction.equals(ConstantMenu.DEL_ORDER_ACT5)){
                delOrder(shop);
            } else if(basicAction.equals(ConstantMenu.ADD_PROD_ORDER_ACT7)) {
                addProduct(ConstantMenu.ADD_PROD_ORDER_ACT7, shop);
            } else if(basicAction.equals(ConstantMenu.DEL_PROD_ORDER_ACT8)){
                delProduct(ConstantMenu.DEL_PROD_ORDER_ACT8, shop);
            }
        }
    }

    private static void addProduct( String basicAction, Shop shop) {

        System.out.print("Введите номер добавляемого товара : ");
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

    private static void delProduct(String basicAction, Shop shop){

        System.out.print("Введите номер даляемого товара : ");
        int delNumber = inputNumberParseInt();
        if(delNumber == NO_INT) {
            return;
        }

        delProductInOtherSource(delNumber, basicAction, shop);
    }

    private static void addProductInOtherSource(int addProductNumber, String basicAction, Shop shop) {

        if(basicAction.equals(ConstantMenu.ADD_PROD_ORDER_ACT7)) {
            shop.addProductCurrentOrderFromWarehouse(addProductNumber - 1);
            System.out.printf("Добавлен к заказу №:%d новый товар -> %s.\n",
                    shop.getCountOrders(), shop.getProductInWarehouse(addProductNumber-1).getName());
        } else if (basicAction.equals(ConstantMenu.ADD_PROD_BASKET_ACT9)) {
            shop.addProductInBasketFromWarehouse(addProductNumber-1);
            System.out.printf("Добавлен в корзину новый товар -> %s.\n",
                    shop.getProductInWarehouse(addProductNumber-1).getName());
        }
    }

    private static void delProductInOtherSource(int delProductNumber, String basicAction, Shop shop) {

        if(basicAction.equals(ConstantMenu.DEL_PROD_ORDER_ACT8)) {

            if((delProductNumber > 0) && (delProductNumber <= shop.getSizeProductsInCurrentOrder())){
                shop.addProductInWarehouse(shop.getProductInCurrentOrder(delProductNumber-1));
                shop.delProductInCurrentOrder(delProductNumber-1);
                System.out.printf("Удален из заказа №:%d товар -> %s.\n",
                        shop.getCountOrders(), shop.getProductInCurrentOrder(delProductNumber-1).getName() );
            } else {
                System.out.printf("Введенный номер №:%d не входит в диапазон допустимых значений.\n", delProductNumber);
            }

        } else if (basicAction.equals(ConstantMenu.DEL_PROD_BASKET_ACT10)) {

            if((delProductNumber > 0) && (delProductNumber <= shop.getProductsInBasket().size())){
                shop.addProductInWarehouse(shop.getProductInBasket(delProductNumber-1));
                shop.delProductInBasket(delProductNumber-1);
                System.out.printf("Удален из корзины товар -> %s.\n",
                        shop.getProductInBasket(delProductNumber-1).getName());
            } else {
                System.out.printf("Введенный номер №:%d не входит в диапазон допустимых значений.\n", delProductNumber);
            }
        }
    }

    private static void delOrder(Shop shop) {

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

    private static void makeSubMenuExit() {

        String subAction;
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
