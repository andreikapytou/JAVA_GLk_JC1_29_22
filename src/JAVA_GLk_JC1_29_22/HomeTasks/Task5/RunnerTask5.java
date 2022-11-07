package JAVA_GLk_JC1_29_22.HomeTasks.Task5;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс RunnerTask5.
 * В данном класе реализован метод main().
 * Метод main() - "главный метод", котрый является точка входа приложения-программы.
 * C запуска-вызова этого метода начинается запуск-управление всего приложения-программы задачи №5.
 *
 * @version 1.0
 * @author  Andrei Kapytou (Андрей Копытов)
 */
public class RunnerTask5 {


    /* Объявление метода main() */
    public static void main(String[] args) { /* Заголовок метода */
        // Строки-инструкции кода ниже - это тело-содержимое-реализация метода main().

        // MatrixWork task5 = new MatrixWork();
        //task5.startTask();


        Pattern pattern1 = Pattern.compile ("aaba");//Поиск будет происходить от x до z включительно.
        //Поиск будет происходить только по символам нижнего регистра.
        //Чтобы отключить чувствительность к регистру, можно использовать Pattern.CASE_INSENSITIVE.

        String  text = "012aaba78910aaba";
        Matcher matcher1 = pattern1.matcher (text);

        System.out.println(text);
        while ( matcher1.find() ) { //Поиск любого совпадения с шаблоном.

                int start = matcher1.start();
                int end   = matcher1.end();
                System.out.println ("с " +start+ " по " + end + " = " +  text.substring(start,end) );
        }
        System.out.println (matcher1.find()); //Поиск любого совпадения с шаблоном.
        //Выводится значение true, так как в строке есть символы шаблона.

        String str1 = "qq_ss";
        String str2 = "cc";

        String[] arrStr1 = str1.split("_");

        System.out.println(Arrays.toString(arrStr1));
    }
}

