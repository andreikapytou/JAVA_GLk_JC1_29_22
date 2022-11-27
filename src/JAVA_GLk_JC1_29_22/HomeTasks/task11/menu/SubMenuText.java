package JAVA_GLk_JC1_29_22.HomeTasks.task11.menu;

public class SubMenuText {

    public static void printListAction123(String title, int sizeList) {

        if (sizeList >0 ) {
            System.out.println(title);
            SubMenuText.printAction123(ConstantMenu.SUB_ACTION1, ConstantMenu.SUB_ACTION2);
        } else {
            System.out.println(title + " - ПУСТ.");
            SubMenuText.printExit();
        }
    }

    private static void printAction123(String subAction1, String subAction2 ) {

        printTextTwoSubAction("Вывести полную информации.", "Вывести окращенную информации.",
                subAction1, subAction2);
    }

    public static void printAction5(String title, String subAction1, int sizeList) {

        if(sizeList>0) {
            System.out.println(title);
            printTextOneSubAction("Удалить заказ по его номеру.", subAction1);
        } else {
            System.out.println("Список заказов - ПУСТ.");
            SubMenuText.printExit();
        }
    }

    public static void printAction7(String title, String subAction1, int sizeList ){

        if(sizeList>0) {
            System.out.println(title);
            printTextOneSubAction("Добавить товар по его номеру к текущему заказу.", subAction1);
        } else {
            System.out.println("Список заказов - ПУСТ.");
            SubMenuText.printExit();
        }
    }

    public static void printAction9(String title, String subAction1) {

        System.out.println(title);
        printTextOneSubAction("Добавить товар по его номеру в корзину.", subAction1);
    }

    private static void printTextOneSubAction(String textSubAction, String subAction1) {

        System.out.println("Выбирете одно из возможных желаемых действий:");
        System.out.println( subAction1 +" - "+ textSubAction);
        System.out.println("Q - Вернуться в основное меню.");
        System.out.print("Введите номер желаемого действия и нажмите клавишу Enter : ");
    }

    private static void printTextTwoSubAction(String textSubAction1, String textSubAction2, String subAction1, String subAction2) {

        System.out.println("Выбирете одно из возможных желаемых действий:");
        System.out.println( subAction1 +" - "+ textSubAction1);
        System.out.println( subAction2 +" - "+ textSubAction2);
        System.out.println("Q - Вернуться в основное меню.");
        System.out.print("Введите номер желаемого действия и нажмите клавишу Enter : ");
    }

    public static void printExit() {

        System.out.println("Выбирете возможное желаемое действие:");
        System.out.println("Q - Вернуться в основное меню.");
        System.out.print("Введите номер желаемого действия и нажмите клавишу Enter : ");
    }

    private SubMenuText() {

    }
}
