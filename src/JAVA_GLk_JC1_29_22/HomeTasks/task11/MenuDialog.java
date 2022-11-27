package JAVA_GLk_JC1_29_22.HomeTasks.task11;

import java.util.Scanner;

public class MenuDialog {

    private static final String ACTION1 = "1";
    private static final String ACTION2 = "2";
    private static final String ACTION3 = "3";
    private static final String ACTION4 = "4";
    private static final String ACTION5 = "5";
    private static final String ACTION6 = "6";
    private static final String ACTION7 = "7";
    private static final String ACTION8 = "8";
    private static final String ACTION9 = "9";
    private static final String ACTION10 = "10";
    private static final String ACTION11 = "11";
    private static final String SUB_ACTION1 = "1";
    private static final String SUB_ACTION2 = "2";

    private static final String EXIT1 = "q";
    private static final String EXIT2 = "Q";

    private static final int NO_INT = -1567890895;

    private MenuDialog() {

    }

    public static void startApplication() {

        Shop shop = new Shop();
        shop.unloadNextProductsInWarehouse();
        chooseMenuBasicAction(shop);
    }

    private static void chooseMenuBasicAction(Shop shop) {

        String selectedAction = "";
        do {
            printTextMenuBasicAction();
            selectedAction = inputStringConsole();
            makeSelectedBaseAction(shop, selectedAction);
        }
        while(!isCheckExitCondition(selectedAction));

        System.out.println("Выход.");
    }

    private static void makeSelectedBaseAction(Shop shop, String action){

        if(action.equals(ACTION1)) {
            chooseSubMenuAction123("Для вывода на консоль списка товаров для заказа следуйте инструкции.", shop, ACTION1);
        } else if (action.equals(ACTION2)) {
            chooseSubMenuAction123("Для вывода на консоль списка товаров в корзине следуйте инструкции.", shop, ACTION2);
        } else if (action.equals(ACTION3)) {
            chooseSubMenuAction123("Для вывода на консоль списка заказов следуйте инструкции.", shop, ACTION3);
        } else if (action.equals(ACTION4)) {
             chooseSubMenuAddOrderAction4("Добавлен новый заказ. ID №: ", shop);
        } else if (action.equals(ACTION5)) {
            chooseSubMenuDelOrderAction5("Для удаления заказа следуйте инструкции.", shop);
        } else if (action.equals(ACTION6)) {
            chooseSubMenuEditOrderAction6("Пункт меню № 6 в стадии разработки.", shop);
        } else if (action.equals(ACTION7)) {
            chooseSubMenuAddProductOrderAction7( "Для добавления товара к текущему заказу следуйте инструкции.", shop);
        } else if (action.equals(ACTION8)) {

        } else if (action.equals(ACTION9)) {
            chooseSubMenuAddProductInBasketAction9("Для добавления товара в корзину следуйте инструкции.", shop);
        } else if (action.equals(ACTION10)) {

        } else if (action.equals(ACTION11)) {

        } else if (isCheckExitCondition(action)) {
            System.out.println("Выход из программы.");
        } else {
            System.out.printf("Введен №:%s - действие с данным номером отсутсвует в меню.\n\n", action);
        }
    }

    private static void printTextMenuBasicAction() {

        System.out.println("Выбирете одно из желаемых действий:");
        System.out.println();
        System.out.printf(" %s -  Вывести список товаров доступных для заказа.\n", ACTION1);
        System.out.printf(" %s -  Вывести список товаров в корзине.\n", ACTION2);
        System.out.printf(" %s -  Вывести список закзов.\n", ACTION3);
        System.out.printf(" %s -  Добавить - создать новый заказ.\n", ACTION4);
        System.out.printf(" %s -  Удалить заказ.\n", ACTION5);
        System.out.printf(" %s -  Редактировать - существующие заказы.\n", ACTION6);
        System.out.printf(" %s -  Добавить товар к текущему заказу.\n", ACTION7);
        System.out.printf(" %s -  Удалить товар из текущего заказа.\n", ACTION8);
        System.out.printf(" %s -  Добавить товар в корзину.\n", ACTION9);
        System.out.printf(" %s - Удалить товар из корзины.\n", ACTION10);
        System.out.printf(" %s - Добавить все товары из корзины к текущему заказу.\n", ACTION11);
        System.out.println(" Q -  Выход из программы.");
        System.out.println();
        System.out.print("Введите номер желаемого дейсвия и нажмите клавишу Enter : ");
     }

    private static void printTextSubMenuAction123() {

        System.out.println("Выбирете одно из возможных желаемых действий:");
        System.out.printf("%s - Вывести полную информации.\n", SUB_ACTION1);
        System.out.printf("%s - Вывести сокращенную информацию.\n", SUB_ACTION2);
        System.out.println("Q - Вернуться в основное меню.");
        System.out.print("Введите номер желаемого действия и нажмите клавишу Enter : ");
    }

    private static void printFullTextSubMenuAction123(String title, Shop shop, String action) {

        if(action.equals(ACTION1)){
            if (shop.getProductsInWarehouse().size() >0 ) {
                System.out.println(title);
                printTextSubMenuAction123();
            } else {
                System.out.println("Список товаров доступных для заказа - ПУСТ.");
                printTextSubMenuExit();
            }
        } else if (action.equals(ACTION2)) {
            if (shop.getProductsInBasket().size() >0 ) {
                System.out.println(title);
                printTextSubMenuAction123();
            } else {
                System.out.println("Список товаров в корзине - ПУСТ.");
                printTextSubMenuExit();
            }
        } else if (action.equals(ACTION3)) {
            if (shop.getListOrders().size() >0 ) {
                System.out.println(title);
                printTextSubMenuAction123();
            } else {
                System.out.println("Список заказов - ПУСТ.");
                printTextSubMenuExit();
            }
        }
    }

    private static void chooseSubMenuAction123(String title, Shop shop, String action) {

        String subAction = "";
        do {
            printFullTextSubMenuAction123(title, shop, action);
            subAction = inputStringConsole();
            makeSelectedSubAction12(shop, action, subAction);
        }
        while(!isCheckExitCondition(subAction));
    }

    private static void makeSelectedSubAction12(Shop shop, String action, String subAction){

        if(subAction.equals(SUB_ACTION1)){
            printInfoAction123(shop, action, true);
        } else if (subAction.equals(SUB_ACTION2)){
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
                printTextSubMenuAction5(title,shop );
                subAction = inputStringConsole();
                makeSelectedDelOrderSubAction5(shop, subAction);
         }
        while(!isCheckExitCondition(subAction));
    }

    private static void printTextSubMenuAction5(String title, Shop shop) {

        if(shop.getListOrders().size()>0) {

            System.out.println(title);

            System.out.println("Выбирете одно из возможных желаемых действий:");
            System.out.printf("%s - Удалить заказ по его номеру.\n", SUB_ACTION1);
            System.out.println("Q - Вернуться в основное меню.");
            System.out.print("Введите номер желаемого действия и нажмите клавишу Enter : ");

        } else {
            System.out.println("Список заказов - ПУСТ.");
            printTextSubMenuExit();
        }
    }

    private static void makeSelectedDelOrderSubAction5(Shop shop, String subAction){

        if(subAction.equals(SUB_ACTION1)){
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
            printTextSubMenuAction7(title, shop );
            subAction = inputStringConsole();
            makeSelectedAddProductOrderSubAction7(shop, subAction);
        }
        while(!isCheckExitCondition(subAction));
    }

    private static void printTextSubMenuAction7(String title, Shop shop) {

        if(shop.getListOrders().size()>0) {

            System.out.println(title);

            System.out.println("Выбирете одно из возможных желаемых действий:");
            System.out.printf("%s - Добавить товар по его номеру к текущему заказу.\n", SUB_ACTION1);
            System.out.println("Q - Вернуться в основное меню.");
            System.out.print("Введите номер желаемого действия и нажмите клавишу Enter : ");

        } else {
            System.out.println("Список заказов - ПУСТ.");
            printTextSubMenuExit();
        }
    }

    private static void makeSelectedAddProductOrderSubAction7(Shop shop, String subAction){

        if(subAction.equals(SUB_ACTION1)){
            if( shop.getListOrders().size()>0) {

                System.out.print("Введите номер добавляемого товара : ");
                int addNumber = inputNumberParseInt();
                if(addNumber == NO_INT) {
                    return;
                }

                if((addNumber > 0) && (addNumber <= shop.getProductsInWarehouse().size())){

                    shop.addProductCurrentOrderFromWarehouse(addNumber-1);
                    System.out.printf("Добавлен новый товар -> %s к заказу №:%d \n",
                            shop.getProductInWarehouse(addNumber-1).getName(), shop.getCountOrders());
                    shop.removeProductInWarehouse(addNumber-1);

                } else {
                    System.out.printf("Введенный номер №:%d не входит в диапазон допустимых значений.\n", addNumber);
                }
            }
        } else if (isCheckExitCondition(subAction)) {
            System.out.println("Возврат в главное меню.\n");
        } else {
            System.out.printf("Введен №:%s - действие с данным номером отсутствует в под-меню.\n", subAction);
        }
    }

    private static void chooseSubMenuAddProductInBasketAction9(String title, Shop shop) {

        String subAction = "";
        do {
            printTextSubMenuAction9(title, shop );
            subAction = inputStringConsole();
            makeSelectedAddProductInBasketSubAction9(shop, subAction);
        }
        while(!isCheckExitCondition(subAction));
    }

    private static void printTextSubMenuAction9(String title, Shop shop) {

            System.out.println(title);

            System.out.println("Выбирете одно из возможных желаемых действий:");
            System.out.printf("%s - Добавить товар по его номеру в корзину.\n", SUB_ACTION1);
            System.out.println("Q - Вернуться в основное меню.");
            System.out.print("Введите номер желаемого действия и нажмите клавишу Enter : ");
    }

    private static void makeSelectedAddProductInBasketSubAction9(Shop shop, String subAction){

        if(subAction.equals(SUB_ACTION1)){

            System.out.print("Введите номер добавляемого товара : ");
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
        } else if (isCheckExitCondition(subAction)) {
            System.out.println("Возврат в главное меню.\n");
        } else {
            System.out.printf("Введен №:%s - действие с данным номером отсутствует в под-меню.\n", subAction);
        }
    }


    private static void printInfoAction123(Shop shop, String action, boolean fullInfo){

        if(action.equals(ACTION1) && (shop.getProductsInWarehouse().size()>0) ) {
            System.out.println(shop.getStringInfoListProducts("Перечень товаров на СКЛАДЕ:",
                    fullInfo, shop.getProductsInWarehouse()));
        } else if (action.equals(ACTION2) && (shop.getProductsInBasket().size()>0)) {
            System.out.println(shop.getStringInfoListProducts("Перечень товаров в КОРЗИНЕ:",
                    fullInfo, shop.getProductsInBasket()));
        } else if (action.equals(ACTION3) && (shop.getListOrders().size()>0)) {
            System.out.print(shop.getStringInfoListOrders("Перечень заказов в МАГАЗИНЕ:",
                    fullInfo, shop.getListOrders()));
        }
    }

    private static void printTextSubMenuExit() {

        System.out.println("Выбирете возможное желаемое действие:");
        System.out.println("Q - Вернуться в основное меню.");
        System.out.print("Введите номер желаемого действия и нажмите клавишу Enter : ");
    }

    private static void makeSubMenuExit() {

        String subAction = "";
        do {
            printTextSubMenuExit();
            subAction = inputStringConsole();
            if(!isCheckExitCondition(subAction)){
                System.out.printf("Введен №:%s - действие с данным номером отсутсвует в под-меню.\n\n", subAction);
            }
        }
        while(!isCheckExitCondition(subAction));
    }

    private static boolean isCheckExitCondition(String condition){

        return condition.equals(EXIT1) || condition.equals(EXIT2);
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
