package JAVA_GLk_JC1_29_22.HomeTasks.task11.menu;

public class SubMenuText {

    public static void printTextMenuBasicAction() {

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

    public static void printListAction123(String title, int sizeList) {

        if (sizeList >0 ) {
            SubMenuText.printTextTwoSubAction123();
        } else {
            System.out.println(title + " - ПУСТ.");
            SubMenuText.printExit();
        }
    }

    private static void printTextTwoSubAction123() {

        printTextTwoSubAction("Вывести полную информации.", "Вывести окращенную информации.");
    }

    private static void printTextOneSubAction5(int sizeList) {

        if(sizeList>0) {
            printTextOneSubAction("Удалить заказ по его номеру.");
        } else {
            System.out.println("Список заказов - ПУСТ.");
            SubMenuText.printExit();
        }
    }

    private static void printTextOneSubAction7(int sizeList ){

        if(sizeList>0) {
            printTextOneSubAction("Добавить товар по его номеру к текущему заказу.");
        } else {
            System.out.println("Список заказов - ПУСТ.");
            SubMenuText.printExit();
        }
    }

    private static void printTextOneSubAction8(int sizeListOrders, int sizeListProducts) {

        if (sizeListOrders >0) {
            if (sizeListProducts > 0) {
                printTextOneSubAction("Удалить из текущего заказа товар по его номеру.");
                return;
            } else {
                System.out.println("Список товаров в текущем заказе - ПУСТ.");
            }
        } else {
            System.out.println("Список заказов - ПУСТ.");
        }
        SubMenuText.printExit();
    }

    private static void printTextOneSubAction10(int sizeList) {

        if(sizeList>0) {
            printTextOneSubAction("Удалить из корзины товар по его номеру.");
        } else {
            System.out.println("Список товаров корзине - ПУСТ.");
            SubMenuText.printExit();
        }
    }

    public static void printTexOneSubActionToOtherActions(String basicAction){

        if (basicAction.equals(ConstantMenu.ADD_PROD_BASKET_ACT9)){
            printTextOneSubAction("Добавить товар по его номеру в корзину.");
        }
    }

    public static void printTexOneSubActionToOtherActions(String basicAction, int sizeList){

         if (basicAction.equals(ConstantMenu.DEL_ORDER_ACT5)) {
            printTextOneSubAction5(sizeList);
        } else if (basicAction.equals(ConstantMenu.EDIT_ORDER_ACT6)) {
            printTextOneSubAction("Редактировать заказа по его номеру.");
        } else if (basicAction.equals(ConstantMenu.ADD_PROD_ORDER_ACT7)) {
            printTextOneSubAction7(sizeList);
        } else if (basicAction.equals(ConstantMenu.ADD_PROD_BASKET_ACT9)) {
             printTextOneSubAction("Добавить товар по его номеру в корзину.");
        } else if (basicAction.equals(ConstantMenu.DEL_PROD_BASKET_ACT10)) {
            printTextOneSubAction10(sizeList);
        }
    }

    public static void printTexOneSubActionToOtherActions(String basicAction, int sizeListOrders, int sizeListProducts){

        if (basicAction.equals(ConstantMenu.DEL_PROD_ORDER_ACT8)) {
            printTextOneSubAction8(sizeListOrders, sizeListProducts);
        }
    }

    private static void printTextOneSubAction(String textSubAction1) {

        System.out.println("Выбирете одно из возможных желаемых действий:");
        System.out.println( ConstantMenu.SUB_ACTION1 +" - "+ textSubAction1);
        System.out.println("Q - Вернуться в основное меню.");
        System.out.print("Введите номер желаемого действия и нажмите клавишу Enter : ");
    }

    private static void printTextTwoSubAction(String textSubAction1, String textSubAction2) {

        System.out.println("Выбирете одно из возможных желаемых действий:");
        System.out.println( ConstantMenu.SUB_ACTION1 +" - "+ textSubAction1);
        System.out.println( ConstantMenu.SUB_ACTION2 +" - "+ textSubAction2);
        System.out.println("Q - Вернуться в основное меню.");
        System.out.print("Введите номер желаемого действия и нажмите клавишу Enter : ");
    }

    public static void printTitleOtherAction(String basicAction) {

        if(basicAction.equals(ConstantMenu.LIST_PRODUCTS_ACT1)) {
            System.out.println("\nДля вывода на консоль списка товаров для заказа - следуйте инструкции.");
        } else if(basicAction.equals(ConstantMenu.LIST_PRODUCTS_BASKET_ACT2)) {
            System.out.println("\nДля вывода на консоль списка товаров в корзине - следуйте инструкции.");
        } else if(basicAction.equals(ConstantMenu.LIST_ORDERS_ACT3)) {
            System.out.println("\nДля вывода на консоль списка заказов - следуйте инструкции.");
        } else if(basicAction.equals(ConstantMenu.ADD_ORDER_ACT4)) {
            System.out.println("\nДобавлен новый заказ.");
        } else if(basicAction.equals(ConstantMenu.DEL_ORDER_ACT5)) {
            System.out.println("\nДля удаления заказа - следуйте инструкции.");
        } else if(basicAction.equals(ConstantMenu.EDIT_ORDER_ACT6)) {
            System.out.println("\nПункт меню № 6 в стадии разработки.");
        } else if(basicAction.equals(ConstantMenu.ADD_PROD_ORDER_ACT7)) {
            System.out.println("\nДля добавления товара к текущему заказу - следуйте инструкции.");
        } else if(basicAction.equals(ConstantMenu.DEL_PROD_ORDER_ACT8)) {
            System.out.println("\nДля удаления товара из текущего заказа - следуйте инструкции.");
        } else if (basicAction.equals(ConstantMenu.ADD_PROD_BASKET_ACT9)) {
            System.out.println("\nДля добавления товара в корзину - следуйте инструкции.");
        } else if(basicAction.equals(ConstantMenu.DEL_PROD_BASKET_ACT10)) {
            System.out.println("\nДля уаления товара из корзины - следуйте инструкции.");
        } else if(basicAction.equals(ConstantMenu.ADD_ALL_PROD_ORDER_ACT11)) {
            System.out.println("\nДля добавления всех товаров из корзине к текущему заказу - следуйте инструкции.");
        }
    }

    public static void printExit() {

        System.out.println("Выбирете возможное желаемое действие:");
        System.out.println("Q - Вернуться в основное меню.");
        System.out.print("Введите номер желаемого действия и нажмите клавишу Enter : ");
    }

    private SubMenuText() {

    }
}
