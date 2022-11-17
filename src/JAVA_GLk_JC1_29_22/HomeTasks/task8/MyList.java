package JAVA_GLk_JC1_29_22.HomeTasks.task8;

import java.util.Collection;

public interface MyList<T> {

    int size();

    boolean isEmpty();

    boolean contains(Object value);

    int indexOf(Object value);

    boolean add(T value);

    void add(int index, T value);

    boolean addAll(Collection<? extends T> value);

    boolean addAll(MyList<? extends T> coll);

    T set(int index, T value);

    boolean remove(Object value);

    T remove(int index);

    T get(int index);

    Object[] toArray();

    void printMyList();

    int getCurrentCapacity();
}
