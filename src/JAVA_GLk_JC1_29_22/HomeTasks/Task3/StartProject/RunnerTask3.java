package JAVA_GLk_JC1_29_22.HomeTasks.Task3.StartProject;

import JAVA_GLk_JC1_29_22.HomeTasks.Task3.OtherProjectClasses. *;

/**
 * Класс StartClassTask3.
 * В данном класе реализован метод main().
 * Метод main() - "главный метод", котрый является точка входа приложения-программы.
 * C запуска-вызова этого метода начинается запуск-управление всего приложения-программы задачи №3.
 *
 * @version 1.0
 * @author  Andrei Kapytou (Андрей Копытов)
 */
public class RunnerTask3 {

    /* Объявление метода main() */
    public static void main(String[] args) { /* Заголовок метода */
        // Строки-инструкции кода ниже - это тело-содержимое-реализация метода main().

        Rainbow rainbow = new Rainbow();

        rainbow.runDialogUser();

    }
}

