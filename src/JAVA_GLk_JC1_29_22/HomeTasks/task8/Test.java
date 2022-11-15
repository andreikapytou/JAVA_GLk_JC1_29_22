package JAVA_GLk_JC1_29_22.HomeTasks.task8;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private Test() {
    }

    public static void start(){

        List<String> list = new ArrayList<>();

       list.add("Латунь");
        list.add("Свинец");
        list.add("Олово");

        MyList<String> myListStr = new MyArrayList<>();

        MyList<Integer> myListInteger = new MyArrayList<>();


        System.out.println(myListStr.isEmpty());
        System.out.println(myListStr.size());

        myListStr.add("Золото");
        System.out.println(myListStr.isEmpty());
        System.out.println(myListStr.size());
        System.out.println(myListStr.get(0));
        myListStr.add("Серебро");
        System.out.println(myListStr.isEmpty());
        System.out.println(myListStr.size());
        System.out.println(myListStr.get(1));

        System.out.println();

        myListStr.add(1, "Бронза");
        System.out.println(myListStr.get(1));
        System.out.println(myListStr.get(2));


        System.out.println();
        myListInteger.add(10);
        System.out.println(myListInteger.isEmpty());
        System.out.println(myListInteger.size());
        System.out.println(myListInteger.get(0));
        myListInteger.add(20);
        System.out.println(myListInteger.isEmpty());
        System.out.println(myListInteger.size());
        System.out.println(myListInteger.get(1));
        myListInteger.add(30);
        myListInteger.add(40);
        System.out.println( myListInteger.set(2, 50) + myListInteger.get(2));

        myListInteger.printMyList();

        System.out.println(myListStr.indexOf("Люминий"));
        System.out.println(myListStr.contains("Люминий"));
        System.out.println(myListStr.indexOf("Бронза"));
        System.out.println(myListStr.indexOf("Серебро"));
        System.out.println(myListStr.contains("Серебро"));

        System.out.println();
        MyList<String> newMyList = new MyArrayList<>(myListStr);

        System.out.println(newMyList.get(0));
        System.out.println(newMyList.get(1));
        System.out.println(newMyList.get(2));

        newMyList.addAll(list);
        System.out.println(newMyList.get(3));
        System.out.println(newMyList.get(4));
        System.out.println(newMyList.get(5));

        newMyList.addAll(myListStr);
        newMyList.printMyList();

        System.out.println("new2MyList");
        list.add("Литий");
        MyList<String> new2MyList = new MyArrayList<>(list);
        new2MyList.printMyList();
        System.out.println(new2MyList.remove(0));
        new2MyList.remove("Олово");
        new2MyList.printMyList();

        System.out.println();
        MyArrayList<Integer> my2ListInteger = new MyArrayList<>(20);
        my2ListInteger.add(100);
        my2ListInteger.addAll(myListInteger);
        my2ListInteger.printMyList();
        System.out.println();
        my2ListInteger.remove((Integer)100);
        my2ListInteger.remove(2);
        my2ListInteger.printMyList();



    }
}
