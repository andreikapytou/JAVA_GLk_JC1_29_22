package JAVA_GLk_JC1_29_22.LessonTasks.bankTask;

import java.util.Scanner;

public class ConsoleMenu {

    public static void start(){
        inputApp();
    }

    private static void inputApp(){

       String exitApp;
        do {
            printMenuInputItem();
            exitApp = inputStringConsole();
            if(exitApp.equals("1")){
                System.out.print("Введите ПИН-КОД : ");
                Integer pin = inputNumberParseInt();
                System.out.println("Введите номер карты соответсвующего шаблона:");
                System.out.print("XXXX-XXXX-XXXX-XXXX-XXXX : ");
                String num = inputStringConsole();

                if ( MachineATM.isFind(pin, num) ) {
                    String back;
                    PaymentAccount paymentAccount = new PaymentAccount();
                    do {
                        printMenuCashItem();
                        back = inputStringConsole();
                        if(back.equals("1")) {
                            paymentAccount.printBalanceAccount();
                        } else if (back.equals("2")){
                            System.out.print("Введите суму денег которую хотите снять со счета : ");
                            paymentAccount.withdrawMoneyFromAccount(inputNumberParseInt());
                        } else if (back.equals("3")){
                            System.out.print("Введите суму денег для пополнения счета : ");
                            paymentAccount.depositAccount(inputNumberParseInt());
                        }
                    } while (!back.equals("b"));
                }
            }
        }while(!exitApp.equals("q"));
    }

    private static void printMenuInputItem(){

        System.out.println("1 -> вход в приложение");
        System.out.println("q -> Выход из программы");
        System.out.print("Введите ID пункта меню и нажмите Enter : ");
    }

    private static void printMenuCashItem(){

        System.out.println("1 -> проверить баланс карты");
        System.out.println("2 -> снять средства со счета");
        System.out.println("3 -> Пополнить баланс");
        System.out.println("b -> Возврат в предыдущее меню");
        System.out.print("Введите ID пункта меню и нажмите Enter : ");
    }

    private static String inputStringConsole() {

        Scanner inputData = new Scanner(System.in);
        return inputData.nextLine();
    }

    private static Integer inputNumberParseInt() {

        String strRemoveNumber = inputStringConsole();
        try
        {
            return Integer.parseInt(strRemoveNumber.trim());
        }
        catch (NumberFormatException nfe)
        {
            System.err.printf("\nВведенный номер №: %s не является числом.\n", strRemoveNumber);
            System.err.println("NumberFormatException:" + nfe.getMessage());
            return -1;
        }
    }

    private ConsoleMenu(){

    }
}
