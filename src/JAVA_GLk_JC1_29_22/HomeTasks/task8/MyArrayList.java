package JAVA_GLk_JC1_29_22.HomeTasks.task8;

import java.util.Collection;

public class MyArrayList<T> implements MyList<T> {

    private static final int ELEMENTARY_CAPACITY = 15;
    private int currentSize;
    private int currentCapacity;
    private T[] arrayObjectList;

    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {

        return currentSize == 0;
    }

    public boolean contains(Object value) {

        return indexOf(value) >= 0;
    }

    public int indexOf(Object value) {

        if (!checkItemTypes(value)) {
            return -1;
        }

        T element = (T) value;

        if (value == null) {

            for (int i = 0; i < currentSize; i++) {
                if (arrayObjectList[i] == null) {
                    return i;
                }
            }

        } else {

            for (int i = 0; i < currentSize; i++) {
                if (arrayObjectList[i].equals(element)) {
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
            System.out.println("Метод: add(int index, T value) - Введен отрицательный индекс массива");
        } else {

            if (currentSize >= currentCapacity) {
                enlargeCapacity();
            }
            if (index > currentSize) {
                index = currentSize;
            }

            for (int i = currentSize; i >= 0; i--) {

                if (i >= index) {
                    arrayObjectList[i + 1] = arrayObjectList[i];
                }
            }
            arrayObjectList[index] = value;
            currentSize++;
        }
    }

    public boolean addAll(Collection<? extends T> value) {

        if ((value == null) || (value.isEmpty())) {
            return false;
        }

        for (T next : value) {
            add(next);
        }
        return true;
    }

    public boolean addAll(MyList<? extends T> coll) {

        if ((coll == null) || (coll.isEmpty())) {
            return false;
        }

        for (T nextObject : (T[]) coll.toArray()) {
            add(nextObject);
        }

        return true;
    }

    public T set(int index, T value) {
        if ((index >= 0) && (index < currentSize)) {
            T object = arrayObjectList[index];
            arrayObjectList[index] = value;
            return object;
        }
        return null;
    }

    private void enlargeCapacity() {
        currentCapacity = currentCapacity * 2;
        T[] newArrayObjectList = (T[]) new Object[currentCapacity];
        for (int i = 0; i < currentSize; i++) {
            newArrayObjectList[i] = arrayObjectList[i];
            arrayObjectList[i] = null;
        }
        arrayObjectList = newArrayObjectList;
    }

    public boolean remove(Object value) {

        if ((currentSize == 0) || (!checkItemTypes(value)) || (!contains(value))) {
            System.out.println("Метод remove(Object value): " + "В массиве отсутвует элемент = " + value);
            return false;
        }

        int iSearch = 0;
        for (int i = 0; i < currentSize; i++) {

            if (value == null) {
                if (arrayObjectList[i] == null) {
                    iSearch = i;
                    break;
                }
            } else {
                if ((arrayObjectList[i] != null) && (arrayObjectList[i].equals(value))) {
                    iSearch = i;
                    break;
                }
            }
        }
        return shiftRemoveElement(iSearch);
    }

    public T remove(int index) {

        T removeElement = get(index);
        if (shiftRemoveElement(index)) {
            return removeElement;
        }
        return null;
    }

    public T get(int index) {

        if ((index >= 0) && (index < currentSize)) {
            return arrayObjectList[index];
        }
        return null;
    }

    private boolean shiftRemoveElement(int removeIndex) {

        if ((removeIndex) >= 0 && (removeIndex < currentSize)) {

            for (int i = 0; i < currentSize; i++) {

                if (i >= removeIndex) {
                    arrayObjectList[i] = arrayObjectList[i + 1];
                }
            }
            currentSize--;
            arrayObjectList[currentSize] = null;
            return true;
        }
        return false;
    }

    public T[] toArray() {
        T[] newArray = (T[]) new Object[currentSize];
        System.arraycopy(arrayObjectList, 0, newArray, 0, currentSize);
        return newArray;
    }

    private boolean checkItemTypes(Object value) {

        if (value.getClass() != arrayObjectList[0].getClass()) {
            System.out.print("Тип объекта " + "(" + value.getClass() + ") не равен (" +
                    arrayObjectList[0].getClass() + ") Типу объекта массива.  ");
            return false;
        }
        return true;
    }

    public void printMyList() {

        if (!isEmpty()) {
            for (int i = 0; i < currentSize; i++) {
                System.out.println("[" + i + "]" + " " + get(i));
            }
        } else {
            System.out.println("MyList - пуст.");
        }
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public MyArrayList() {
        currentCapacity = ELEMENTARY_CAPACITY;
        arrayObjectList = (T[]) new Object[currentCapacity];
    }

    public MyArrayList(int initCapacity) {
        this.currentCapacity = initCapacity;
        arrayObjectList = (T[]) new Object[initCapacity];
    }

    MyArrayList(MyList<? extends T> col) {

        this();
        if ((col != null) && !(col.isEmpty())) {
            for (T nextObject : (T[]) col.toArray()) {
                add(nextObject);
            }
        } else {
            System.out.println("Ошибка параметров конструктора MyArrayList(MyList<? extends T> col)");
        }
    }

    MyArrayList(Collection<? extends T> coll) {

        this();
        if ((coll != null) && (!coll.isEmpty())) {
            for (T nextColl : coll) {
                add(nextColl);
            }
        } else {
            System.out.println("Ошибка параметров конструктора MyArrayList(Collection<? extends T> coll)");
        }
    }
}
