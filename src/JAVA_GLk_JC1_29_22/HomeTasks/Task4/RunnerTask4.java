package JAVA_GLk_JC1_29_22.HomeTasks.Task4;

/**
 * Класс RunnerTask3.
 * В данном класе реализован метод main().
 * Метод main() - "главный метод", котрый является точка входа приложения-программы.
 * C запуска-вызова этого метода начинается запуск-управление всего приложения-программы задачи №3.
 *
 * @version 1.0
 * @author  Andrei Kapytou (Андрей Копытов)
 */
public class RunnerTask4 {

    private static final int NUMBER1_CATS = 10; // Клличество элеементов в вмассиве.
    private static final int NUMBER2_CATS = 5;
    private static final int MIN_VALUE_RANDOM_RANGE = 1; // Минимальное-начальное значение рандомного диапазона .
    private static final int MAX_VALUE_RANDOM_RANGE = 28; // Максимальное-конечное значение рандомного диапазона.
    private static final String[] arrStringNameCat = { "Барсик", "Мурзик", "Пол", "Том", "Вася", "Баюн", "Кузя",
                                                       "Авва", "Юлик", "Гога", "Лакмус", "Фадей", "Урфин", "Зерро" };

    /* Объявление метода main() */
    public static void main(String[] args) { /* Заголовок метода */
        // Строки-инструкции кода ниже - это тело-содержимое-реализация метода main().

        CatTask4[] catsWhile = new CatTask4[NUMBER1_CATS];
        CatTask4[] catsDoWhile = new CatTask4[NUMBER1_CATS];
        CatTask4[] catsFor = new CatTask4[NUMBER1_CATS];
        CatTask4[] catsForeach = new CatTask4[NUMBER2_CATS];
        //CatTask4[][] catsBonus = new CatTask4[NUMBER1_CATS][NUMBER2_CATS];

        System.out.println("\nНачало выполнеия пункта №4 ДЗ. Цикл - while{}.");
        int i = 0;
        while (i < catsWhile.length)
        {
            System.out.printf("catsWhile[%d] ", i);
            catsWhile[i] = new  CatTask4();
            catsWhile[i].printAgeName();
            i+=1;
        }

        System.out.println("\nНачало выполнеия пункта №5 ДЗ. Цикл - for{}.");
        for (int j = 0; j < catsFor.length; j++)
        {
            int ageCat = MyRandomTask4.nextRandomIntValueRange(MIN_VALUE_RANDOM_RANGE, MAX_VALUE_RANDOM_RANGE);
            int idxNameCat = MyRandomTask4.nextRandomIntValueRange( arrStringNameCat.length-1);
            System.out.printf("catsFor[%d] ", j);
            catsFor[j] = new  CatTask4();
            catsFor[j].setAge(ageCat); // Я пониимаю что я мог и не создавать локальную переменню - int ageCat.
            catsFor[j].setName(arrStringNameCat[idxNameCat]); // Я пониимаю что я мог и не создавать локальную переменню - int idxNameCat.
            System.out.printf("Возраст кота-age = %d  Имя кота-name = %s \n", catsFor[j].getAge(), catsFor[j].getName());
        }

        i = 0;
        System.out.println("\nНачало выполнеия пункта №6 ДЗ. Цикл - do while{}."); // Без локальных переменных int ageCat и int idxNameCat - но сложно читаемо.
        do
        {
            System.out.printf("catsDoWhile[%d] ", i);
            catsDoWhile[i] = new CatTask4(MyRandomTask4.nextRandomIntValueRange(MIN_VALUE_RANDOM_RANGE, MAX_VALUE_RANDOM_RANGE),
                                            arrStringNameCat[MyRandomTask4.nextRandomIntValueRange( arrStringNameCat.length-1)]);
            catsDoWhile[i].printAgeName();
            i+=1;
        }
        while (i < catsDoWhile.length);

        // Создание 5-ть котиклов.
        for (int j = 0; j < catsForeach.length; j++) /* Без локальных переменных int ageCat и int idxNameCat - но сложно читаемо. */
        {
            catsForeach[j] = new CatTask4(MyRandomTask4.nextRandomIntValueRange(MIN_VALUE_RANDOM_RANGE, MAX_VALUE_RANDOM_RANGE),
                    arrStringNameCat[MyRandomTask4.nextRandomIntValueRange( arrStringNameCat.length-1)]);
        }

        i = 0;
        System.out.println("\nНачало выполнеия пункта №7 ДЗ. Цикл - foreach{}.");
        for (CatTask4 cats : catsForeach )
        {
            System.out.printf("catsForeach[%d] ", i);
            System.out.printf("Выводим массив из %d котиков через toString(): ", catsForeach.length);
            System.out.println(cats); // Срабатывает переопределение метода toString() в к лассе CatTask4.
            cats.printAgeName();
            System.out.println();
            i++;
        }

        // Бонусая часть - работа переопредеелнных метода equals() и метода hashCode().
        System.out.println("Начало бонусной-дополнительной части ДЗ. Генериование методов.");
        System.out.printf(" equals = %b  hashCode = %b \n", catsFor[0].equals(catsFor[1]) , ( catsFor[0].hashCode() == catsFor[1].hashCode() ) );
        catsFor[0].setAge(50);
        catsFor[0].setName("Один");
        catsFor[1].setAge(50);
        catsFor[1].setName("Один");
        System.out.printf(" equals = %b  hashCode = %b \n", catsFor[0].equals(catsFor[1]) , ( catsFor[0].hashCode() == catsFor[1].hashCode() ) );



    }
}

