package JAVA_GLk_JC1_29_22.HomeTasks.task10;

import JAVA_GLk_JC1_29_22.HomeTasks.task10.myexception.*;

import java.util.Scanner;

public class HandlerException {



    public static void start(){

        try {
                basicHandler();
        } catch ( MyException4 e4) {
                System.out.println(e4.getMessage());
        } finally {
            System.out.println("Блок finally метода start()");
        }
    }

    public static void basicHandler() throws MyException4 {

        try {
                nestedHandler();
        } catch ( MyException3 e3) {
                System.out.println("Обработка исключения MyException3: " + e3.getMessage());
        }  finally {
            System.out.println("Блок finally метода basicHandler()");
        }
    }

    public static void nestedHandler() throws MyException3, MyException4{

        String strInput = input("Введите тип генерируемого исключения - тип  цифра от 1 до 3 : ");
        try {

            if (strInput.equals("1")) {
                    throw new MyException1("Start - MyException1.");
            } else if (strInput.equals("2")) {
                    throw new MyException2("Start - MyException2.");
            }  else if (strInput.equals("3")) {
                    throw new MyException3("Start - MyException3.");
            } else {
                    throw new MyException4("Start - MyException4. С клавиатуры введен неизвестный тип исключения.");
            }

        } catch (MyException1 | MyException2 e) {
                System.out.println("Объединенная обработка исключений MyException1 и MyException2: " + e.getMessage());
        }   finally {
                System.out.println("Блок finally метода nestedHandler()");
        }
    }

    public static String input(String strWelcomeInput) {

        System.out.print(strWelcomeInput);
        Scanner inputData = new Scanner(System.in);
        return inputData.nextLine();
    }

    private HandlerException() {
    }

}
