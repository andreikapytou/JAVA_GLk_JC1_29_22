package JAVA_GLk_JC1_29_22.HomeTasks.task8;

import java.util.ArrayList;
import java.util.List;

import JAVA_GLk_JC1_29_22.HomeTasks.task8.test.*;

public class Test {

    private static final String STRING_TEST0 = "Сталь";
    private static final String [] STRINGS_TEST1 = {"Серебро", "Золото", "Олово", "Медь" };
    private static final String STRING_TEST1 = "Бронза";
    private static final String [] STRINGS_TEST2 = {"Палалдий", "Цинк", "Литий"};
    private static final String [] STRINGS_TEST3 = {"Никель", "Аллюминий"};

    private static final Integer INTEGER_TEST0 = 1;
    private static final Integer [] INTEGERS_TEST1 = {2, 3, 4, 5};
    private static final Integer INTEGER_TEST1 = 6;


    private Test() {
    }

    public static void start(){

        MyList<String> myList1String = new MyArrayList<>();
        myList1String.add(STRING_TEST0);
        for(String nextString : STRINGS_TEST1 ){
            myList1String.add(nextString);
        }
        myList1String.printMyList();
        System.out.printf("Кол-во элементов = %d. Размер капасити = %d\n", myList1String.size(), myList1String.getCurrentCapacity());
        findObject(myList1String, STRINGS_TEST2[1]);
        findObject(myList1String, 123.67);
        findObject(myList1String, STRINGS_TEST1[2]);
        System.out.println();
        System.out.printf("Добавлен елемент = %s по Индекс = %d\n", STRING_TEST1, 1);
        myList1String.add(1, STRING_TEST1);
        myList1String.printMyList();
        System.out.printf("Кол-во элементов = %d. Размер капасити = %d\n", myList1String.size(), myList1String.getCurrentCapacity());
        System.out.println();

        MyList<Integer> myList1Integer = new MyArrayList<>();
        myList1Integer.add(INTEGER_TEST0);
        for(Integer nextInteger : INTEGERS_TEST1 ){
            myList1Integer.add(nextInteger);
        }
        myList1Integer.printMyList();
        if(myList1Integer.contains(INTEGERS_TEST1[0])){
            System.out.printf("Найден элемент = %d его Индекс = %d\n", INTEGERS_TEST1[0], myList1Integer.indexOf(INTEGERS_TEST1[0]));
        } else {
            System.out.println("Отсутвует элемент или тип элемента не соответвует типу массива");
        }
        System.out.printf("Кол-во элементов = %d. Размер капасити = %d\n", myList1Integer.size(), myList1Integer.getCurrentCapacity());
        System.out.println();
        System.out.printf("Добавлен елемент = %s по Индекс = %d\n", INTEGER_TEST1, 1);
        myList1Integer.add(1, INTEGER_TEST1);
        myList1Integer.printMyList();
        System.out.printf("Кол-во элементов = %d. Размер капасити = %d\n", myList1Integer.size(), myList1Integer.getCurrentCapacity());
        System.out.println();

        MyList<Test1> myList1Test1 = new MyArrayList<>();
        Test1 test11 = new Test1("Вася", 12);
        Test1 test12 = new Test1("Вася", 12);
        Test1 test13 = new Test1("Вася", 12);
        Test1 test14 = new Test1("Вася", 23);
        Test2 test21 = new Test2("Вася", 12);
        myList1Test1.add(test11);
        myList1Test1.add(test12);
        myList1Test1.add(test13);
        findObject(myList1Test1, test13);
        findObject(myList1Test1, test21);
        findObject(myList1Test1, test14);
        System.out.println();

        List<String> list = new ArrayList<>();
        for(String nextString : STRINGS_TEST2 ){
            list.add(nextString);
            System.out.println(nextString);
        }
        System.out.println();
        MyList<String> new1MyList = new MyArrayList<>(20);
        for(String nextString : STRINGS_TEST3 ){
            new1MyList.add(nextString);
        }
        new1MyList.printMyList();
        System.out.println();
        MyList<String> new2MyList = new MyArrayList<>(new1MyList);
        new2MyList.printMyList();
        System.out.println();
        new2MyList.addAll(list);
        new2MyList.addAll(myList1String);
        new2MyList.printMyList();
        System.out.println();

        MyList<String> new3MyList = new MyArrayList<>(list);
        new3MyList.printMyList();
        System.out.println();
        System.out.println("Удален объект-элемент = " + new3MyList.remove(1));
        new3MyList.printMyList();
        System.out.println();
        new3MyList.remove(STRINGS_TEST2[1]);
        new3MyList.printMyList();
        System.out.println();
        String resultRemove = (new3MyList.remove(STRINGS_TEST2[0])) ? "Удален объект-элемент "+STRINGS_TEST2[0] : "";
        System.out.println(resultRemove);
        new3MyList.printMyList();
        System.out.println();

        new2MyList.printMyList();
        System.out.println();
        resultRemove = (new2MyList.remove("Никель")) ? "Удален объект-элемент "+"Никель" : "";
        System.out.println(resultRemove);
        new2MyList.printMyList();
        System.out.println();
        resultRemove = (new2MyList.remove("Медь")) ? "Удален объект-элемент "+"Медь" : "";
        System.out.println(resultRemove);
        new2MyList.printMyList();
        System.out.println();

        System.out.println("Удаление объектов-элементов в коллекции типа Integer");
        MyArrayList<Integer> my2ListInteger = new MyArrayList<>(20);
        my2ListInteger.add(100);
        my2ListInteger.add(500);
        my2ListInteger.addAll(myList1Integer);
        my2ListInteger.printMyList();
        System.out.println();
        resultRemove = (my2ListInteger.remove((Integer)100)) ? "Удален объект-элемент со значением "+(Integer)100 : "" ;
        System.out.println(resultRemove);
        my2ListInteger.printMyList();
        System.out.println();
        System.out.println("Удален объект-элемент" + my2ListInteger.remove(2));
        my2ListInteger.printMyList();

    }

    private static void findObject(MyList myList, Object findObject){

        if(myList.contains(findObject)){
            System.out.printf("Найден элемент = %s его Индекс = %d\n", findObject, myList.indexOf(findObject));
        } else{
            System.out.printf("В массиве отсутвует элемент = %s \n", findObject);
        }
    }
}
