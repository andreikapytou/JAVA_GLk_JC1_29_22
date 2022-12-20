package JAVA_GLk_JC1_29_22.LessonTasks.bankTask;

public class PaymentAccount {

    private static final int MAX_SUM_DEPOSIT = 1_000_000;
    private static final int MAX_LIMIT_WITHDRAW_ATM = 100_000;
    private int balance = 1000;

    public void printBalanceAccount(){
        System.out.println("Денег на счету -> " + balance);
    }

    public void withdrawMoneyFromAccount(int money){

        if (money > balance) {
            System.out.printf("Желаемая сумма %d больше чем сумма на счете %d \n", money, balance);
        } else if (money > MAX_LIMIT_WITHDRAW_ATM) {
            System.out.printf("Желаемая сумма %d больше чем лимит за одну транзакцию %d \n", money, MAX_LIMIT_WITHDRAW_ATM);
        } else {
            balance = balance - money;
        }
    }

    public void depositAccount(int money){

        if (money > MAX_SUM_DEPOSIT ) {
            System.out.printf("Сумма пополнения %d превышает дпустимую сумму %d\n", money,  MAX_SUM_DEPOSIT);
        } else {
            balance = balance + money;
        }
    }


}
