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
    private static final String ACTION11 = "10";
    private static final String SUB_ACTION1 = "1";
    private static final String SUB_ACTION2 = "2";

    private static final String EXIT1 = "q";
    private static final String EXIT2 = "Q";

    private static final String PROD_WAREHOUSE = "Перечень товаров на СКЛАДЕ:";

    private static final Shop shop = new Shop();

    private MenuDialog() {

    }

    public static void startApplication() {

        shop.unloadNextProductsInWarehouse();

        chooseMenuAction();
    }

    private static void chooseMenuAction() {

        String selectedAction = "";
        do {
            selectedAction = printMenuBasicText();
            makeSelectedBaseAction(selectedAction);
        }
        while(!isCheckExitCondition(selectedAction));

        System.out.println("Выход.");
    }

    private static boolean isCheckExitCondition(String condition){

        return condition.equals(EXIT1) || condition.equals(EXIT2);
    }

    private static void makeSelectedBaseAction(String action){

        if(action.equals(ACTION1)) {
            System.out.println("Для вывода на консоль списка товаров доступных для заказ следуйте инструкции.");
            chooseSubMenuAction();
        } else if (action.equals(ACTION2)) {

        } else if (action.equals(ACTION3)) {

        } else if (action.equals(ACTION4)) {

        } else if (action.equals(ACTION5)) {

        } else if (action.equals(ACTION6)) {

        } else if (action.equals(ACTION7)) {

        } else if (action.equals(ACTION8)) {

        } else if (action.equals(ACTION9)) {

        } else if (action.equals(ACTION10)) {

        } else if (action.equals(ACTION11)) {

        } else if (isCheckExitCondition(action)) {
            System.out.println("Выход из программы.");
        } else {
            System.out.printf("Введен №:%s - действие с данным номером отсутсвует в меню.\n\n", action);
        }
    }

    private static String printMenuBasicText() {

        System.out.println("Выбирете одно из желаемых действий:");
        System.out.println();
        System.out.printf(" %s -  Вывести список товаров доступных для заказа.\n", ACTION1);
        System.out.printf(" %s -  Вывести список товаров в корзине.\n", ACTION2);
        System.out.printf(" %s -  Вывести список закзов.\n", ACTION3);
        System.out.printf(" %s -  Добавить - создать новый заказ.\n", ACTION4);
        System.out.printf(" %s -  Редактировать - существующие заказы.\n", ACTION5);
        System.out.printf(" %s -  Удалить заказ.\n", ACTION6);
        System.out.printf(" %s -  Добавить товар к текущему заказу.\n", ACTION7);
        System.out.printf(" %s -  Удалить товар из текущего заказа.\n", ACTION8);
        System.out.printf(" %s -  Добавить товар в корзину.\n", ACTION9);
        System.out.printf(" %s -  Удалить товар из корзины.\n", ACTION10);
        System.out.printf(" %s -  Добавить все товары из корзины к текущему заказу.\n", ACTION11);
        System.out.println(" Q -  Выход из программы.");
        System.out.println();
        System.out.print("Введите номер желаемого дейсвия и нажмите клавишу Enter : ");

        return inputConsole();
    }

    private static String printSubMenuBasicText() {

        System.out.println("Выбирете одно из желаемых действий:");
        System.out.printf("%s - Вывести полную информации.\n", SUB_ACTION1);
        System.out.printf("%s - Вывести сокращенную информацию.\n", SUB_ACTION2);
        System.out.println("Q - Вернуться в основное меню.");
        System.out.print("Введите номер желаемого дейсвия и нажмите клавишу Enter : ");

        return inputConsole();
    }

    private static void chooseSubMenuAction() {

        String subAction = "";
        do {
            subAction = printSubMenuBasicText();
            makeSelectedSubAction(subAction);
        }
        while(!isCheckExitCondition(subAction));
    }

    private static void makeSelectedSubAction(String subAction){

        if(subAction.equals(SUB_ACTION1)){
            System.out.println(shop.getStringInfoListProducts(PROD_WAREHOUSE,true, shop.getProductsInWarehouse()));
        } else if (subAction.equals(SUB_ACTION2)){
            System.out.println(shop.getStringInfoListProducts(PROD_WAREHOUSE,false, shop.getProductsInWarehouse()));
        } else if (isCheckExitCondition(subAction)) {
            System.out.println("Возврат в главное меню.\n");
        } else {
            System.out.printf("Введен №:%s - действие с данным номером отсутсвует в меню.\n", subAction);
        }
    }

    private static String inputConsole(String strWelcomeInput) {

        System.out.print(strWelcomeInput);
        Scanner inputData = new Scanner(System.in);
        return inputData.nextLine();
    }

    private static String inputConsole() {

        Scanner inputData = new Scanner(System.in);
        return inputData.nextLine();
    }

}
