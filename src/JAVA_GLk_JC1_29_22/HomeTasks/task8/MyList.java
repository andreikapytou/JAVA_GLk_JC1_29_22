package JAVA_GLk_JC1_29_22.HomeTasks.task8;

import java.util.Collection;

public interface MyList <T> {

    // Количество элементов в коллекции-списке.
    int size();

    // Проверяет на наличие элементов в коллекции-списке.
    boolean isEmpty();

    // Проверяет содержится ли элемент в коллекции-списке.
    boolean contains(Object value);

    // Возвращает индекс первого вхождения объекта value в список. Если объект не найден вернуть -1;
    int indexOf (Object value);

    boolean add(T value);

    void add(int index, T value);

    boolean addAll(Collection<? extends T> value);

    boolean addAll(MyList<? extends T> coll);

    T set(int index, T value);

    boolean remove(Object value);

    T remove (int index);

    // Возвращает объект из списка по индексу index
    T get(int index);

    Object[] toArray();

    void printMyList();

}
