package JAVA_GLk_JC1_29_22.HomeTasks.task8;

import java.util.Collection;

public class MyArrayList<T> implements MyList<T> {

    private static final int ELEMENTARY_CAPACITY = 15;
   
    private int currentSize;
    private int currentCapacity;

    private Object[] arrayObjectList;
    //private T[] arrayObjectList;

    // Количество элементов в коллекции-списке.
    public int size() {
        return currentSize;
    }

    // Проверяет на наличие элементов в коллекции-списке.
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // Проверяет содержится ли элемент в коллекции-списке.
    public boolean contains(Object value) {
        return indexOf(value) >= 0;
    }

    // Возвращает индекс первого вхождения объекта value в коллекцию-список. Если объект не найден вернуть -1;
    public int indexOf(Object value) {
        if (value == null) {

            for (int i = 0; i < currentSize; i++) {
                if (arrayObjectList[i] == null) {
                    return i;
                }
            }

        } else {

            for (int i = 0; i < currentSize; i++) {
                if (value.equals(arrayObjectList[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean add(T value) {
        if (currentSize >= currentCapacity) {
            enlargeCapacity();
        }
        arrayObjectList[currentSize] = value;
        currentSize++;
        return true;
    }

    public void add(int index, T value) {
        if (index < 0) {
            return;
        }
        if (currentSize + 1 >= currentCapacity) {
            enlargeCapacity();
        }
        if (index > currentSize) {
            index = currentSize;
        }
        for (int i = currentSize; i >= index; i--) {
            arrayObjectList[i + 1] = arrayObjectList[i];
        }
        arrayObjectList[index] = value;
        currentSize++;
    }

    // Добавляет элементы одной коллекции в конец другой.
    public boolean addAll(Collection<? extends T> value) {
        if (value == null) {
            return false;
        }
        if (value.isEmpty()) {
            return false;
        }
        for (T next : value) {
            add(next);
        }
        return true;
    }

    public boolean addAll(MyList<? extends T> coll) {
        if (coll == null) {
            return false;
        }
        if (coll.isEmpty()) {
            return false;
        }
        for (Object nextObject : coll.toArray()) {
            add((T) nextObject);
        }
        return true;
    }

    // Присваивает значение объекта value элементу, который находиться по индексу index.
    public T set(int index, T value) {
        if ((index >= 0) && (index < currentSize)) {
            Object object = arrayObjectList[index];
            arrayObjectList[index] = value;
            return (T) object;
        }
        return null;
    }

    private void enlargeCapacity() {
        currentCapacity = currentCapacity * 2;
        Object[] newArrayObjectList = new Object[currentCapacity];
        for (int i = 0; i < currentSize; i++) {
            newArrayObjectList[i] = arrayObjectList[i];
            arrayObjectList[i] = null;
        }
        arrayObjectList = newArrayObjectList;
    }

    public boolean remove(Object value) {
        if (currentSize == 0) {
            return false;
        }
        int iSearch;
        for (iSearch = 0; iSearch < currentSize; iSearch++) {
            if (arrayObjectList[iSearch] == null && value == null) {
                break;
            }
            if ((arrayObjectList[iSearch] != null) && (arrayObjectList[iSearch].equals(value))) {
                break;
            }
        }

        if (iSearch < currentSize) {
            offsetRemove(iSearch);
            return true;
        }
        return false;
    }

    // Возвращает объект из списка по индексу index
    public T get(int index) {
        if ((index >= 0) && (index < currentSize)) {
            return (T) arrayObjectList[index];
        }
        return null;
    }

    public T remove(int index) {
        T object = null;
        if ( (index >= 0) && (index < currentSize)) {
            object = get(index);
            offsetRemove(index);
        }
        return object;
    }

    private void offsetRemove(int begin) {
        currentSize--;
        if (currentSize <= 0) {
            return;
        }
        if (currentSize != begin) {
            System.arraycopy(arrayObjectList, begin + 1, arrayObjectList, begin, currentSize - begin);
               /*
                Object src, // исходный массив - из которго копируют.
                int srcPos, // начальный индекс для копирования в исходном массиве.
                Object dest, // итоговый массив - в который коипруют.
                int destPos, // начальный индекс в итогоовом массиве.
                int length // длина копируемого содержимого
               */
        }
        arrayObjectList[currentSize] = null;
    }

    public Object[] toArray() {
        Object[] newArray = new Object[currentSize];
        System.arraycopy(arrayObjectList, 0, newArray, 0, currentSize);
        return newArray;
    }


    public void printMyList() {

        if (!isEmpty()) {
            for (int i = 0; i < currentSize; i++) {
                System.out.println("["+i+"]"+" "+ get(i));
            }
        } else {
            System.out.println("MyList - пуст.");
        }
    }

    public MyArrayList() {
        currentCapacity = ELEMENTARY_CAPACITY;
        arrayObjectList = new Object[currentCapacity];
    }

    public MyArrayList(int initCapacity) {
        this.currentCapacity = initCapacity;
        arrayObjectList = new Object[initCapacity];
    }

    // Создаёт список, в который добавляются все элементы коллекции col
    MyArrayList(MyList<? extends T> col) {

        this();
        if ((col != null) && !(col.isEmpty())) {
            for (Object nextObject : col.toArray()) {
                add((T) nextObject);
            }
        } else {
            System.out.println("Ошибка параметров конструктора MyArrayList(MyList<? extends T> col)");
        }
    }

    MyArrayList(Collection<? extends T> coll) {

        this();
        if ((coll != null) && !(coll.isEmpty())) {
            for (T nextColl : coll) {
                add(nextColl);
            }
        } else {
            System.out.println("Ошибка параметров конструктора MyArrayList(Collection<? extends T> coll)");
        }
    }

}
