package JAVA_GLk_JC1_29_22.HomeTasks.Task4;

public class BoxForRunnerTask4 {

    private static final int NUMBER1_CATS = 10; // Клличество элеементов в вмассиве.
    private static final int NUMBER2_CATS = 5;
    private static final int MIN_VALUE_RANDOM_RANGE = 1; // Минимальное-начальное значение рандомного диапазона .
    private static final int MAX_VALUE_RANDOM_RANGE = 28; // Максимальное-конечное значение рандомного диапазона.
    private static final String[] arrStringNameCat = { "Барсик", "Мурзик", "Пол", "Том", "Вася", "Баюн", "Кузя",
                                                       "Авва", "Юлик", "Гога", "Лакмус", "Фадей", "Урфин", "Зерро" };

    public BoxForRunnerTask4() {

    }

    public void runBox(){

        CatTask4[] catsWhile = new CatTask4[NUMBER1_CATS];
        CatTask4[] catsDoWhile = new CatTask4[NUMBER1_CATS];
        CatTask4[] catsFor = new CatTask4[NUMBER1_CATS];
        CatTask4[] catsForeach = new CatTask4[NUMBER2_CATS];
        //CatTask4[][] catsBonus = new CatTask4[NUMBER1_CATS][NUMBER2_CATS];

        System.out.println("\nНачало выполнения пункта №4 ДЗ. Цикл - while{}.");
        createCatWhile("catsWhile",  catsWhile);

        System.out.println("\nНачало выполнения пункта №5 ДЗ. Цикл - for{}.");
        createCatFor("catsFor", catsFor);

        System.out.println("\nНачало выполнения пункта №6 ДЗ. Цикл - do while{}.");
        createCatDoWhile("catsDoWhile", catsDoWhile);

        System.out.println("\nНачало выполнения пункта №7 ДЗ. Цикл - foreach{}.");
        createCatFor(catsForeach);
        inputRandomValueAgeForCat(catsForeach,MIN_VALUE_RANDOM_RANGE, MAX_VALUE_RANDOM_RANGE);
        inputRandomValueNameForCat(catsForeach, arrStringNameCat);

        printCatForeach("catsForeach", catsForeach);

        // Бонусая часть - работа переопредеелнных метода equals() и метода hashCode().
        System.out.println("\nНачало бонусной-дополнительной части ДЗ. Генериование методов.");
        printArrCat("catsFor", catsFor);

        System.out.println("\nПроверка до Cat");
        catsFor[0].printAgeName();
        setCatAgeName(catsFor[0]);
        System.out.println("Проверка после Cat");
        catsFor[0].printAgeName();

        System.out.printf("\n equals = %b  hashCode = %b \n", catsFor[0].equals(catsFor[1]) , ( catsFor[0].hashCode() == catsFor[1].hashCode() ) );
        catsFor[0].setAge(50);
        catsFor[0].setName("Один");
        catsFor[1].setAge(50);
        catsFor[1].setName("Один");
        System.out.printf(" equals = %b  hashCode = %b \n", catsFor[0].equals(catsFor[1]) , ( catsFor[0].hashCode() == catsFor[1].hashCode() ) );
    }

    private void createCatWhile( String text, CatTask4[] cats ) {

        int i = 0;
        while (i < cats.length)
        {
            System.out.printf("%s[%d] ", text, i);
            cats[i] = new  CatTask4();
            cats[i].printAgeName();
            i+=1;
        }
    }

    private void createCatDoWhile( String title, CatTask4[] cats ) {

        // Без локальных переменных int ageCat и int idxNameCat - но сложно читаемо.
        int i = 0;
        do
        {
            System.out.printf("%s[%d] ", title, i);
            cats[i] = new CatTask4(MyRandomTask4.nextRandomIntValueRange(MIN_VALUE_RANDOM_RANGE, MAX_VALUE_RANDOM_RANGE),
                    arrStringNameCat[MyRandomTask4.nextRandomIntValueRange( arrStringNameCat.length-1)]);
            cats[i].printAgeName();
            i+=1;
        }
        while (i < cats.length);
    }

    private void createCatFor( String title, CatTask4[] cats ) {

        for (int i = 0; i < cats.length; i++)
        {
            int ageCat = MyRandomTask4.nextRandomIntValueRange(MIN_VALUE_RANDOM_RANGE, MAX_VALUE_RANDOM_RANGE);
            int idxNameCat = MyRandomTask4.nextRandomIntValueRange( arrStringNameCat.length-1);
            System.out.printf("%s[%d] ", title, i);
            cats[i] = new  CatTask4();
            cats[i].setAge(ageCat); // Я пониимаю что я мог и не создавать локальную переменню - int ageCat.
            cats[i].setName(arrStringNameCat[idxNameCat]); // Я пониимаю что я мог и не создавать локальную переменню - int idxNameCat.
            System.out.printf("Возраст кота-age = %d  Имя кота-name = %s \n", cats[i].getAge(),cats[i].getName());
        }
    }

    private void createCatFor( CatTask4[] cats ) {

        for (int j = 0; j < cats.length; j++)
        {
            cats[j] = new CatTask4();
        }
    }

    private void inputRandomValueAgeForCat( CatTask4[] cats, int startRange, int endRange ) {

        for (int j = 0; j < cats.length; j++) /* Без локальных переменных int ageCat - но сложно читаемо. */
        {
            cats[j].setAge( MyRandomTask4.nextRandomIntValueRange(startRange, endRange) );
        }
    }

    private void inputRandomValueNameForCat( CatTask4[] cats, String[] arrStrName ) {

        for (int j = 0; j < cats.length; j++) /* Без локальных переменных int idxNameCat - но сложно читаемо. */
        {
              cats[j].setName( arrStrName[MyRandomTask4.nextRandomIntValueRange( arrStrName.length-1)] );
        }
    }

    private void printCatForeach( String title, CatTask4[] cats ) {

        int i = 0;
        for (CatTask4 printCats : cats )
        {
            System.out.printf("%s[%d] ", title, i);
            System.out.printf("Выводим массив из %d котиков через toString(): ", cats.length);
            System.out.println(printCats); // Срабатывает переопределение метода toString() в к лассе CatTask4.
            printCats.printAgeName();
            i++;
        }
    }

    private void printArrCat( String title, CatTask4[] cats ) {

        int i = 0;
        for (CatTask4 printCats : cats )
        {
            System.out.printf("%s[%d] ", title, i);
            printCats.printAgeName();
            i++;
        }
    }

    // Для проверки меняется-изменяется ли значение параметра объекта вметоде и за его пределами.
    private void setCatAgeName( CatTask4 cat ) {

        cat.setAge(111);
        cat.setName("ХХХ");
    }
}

