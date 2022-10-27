package JAVA_GLk_JC1_29_22.HomeTasks.Task4;

import java.util.Objects;

/**
 * Класс CatTask4.
 *
 *
 * @version 1.0
 * @author  Andrei Kapytou (Андрей Копытов)
 */
public class CatTask4 {

    private int age;
    private String name;

    { /* Блок инициализации глобальных-переменных-полей класса CatTask4. */
        this.age = -1;
        this.name = "Нет_имени_у_кота";
    }

    public CatTask4(  ){ /* Конструктор класса по умолчанию */

    }
    public CatTask4(int age, String name  ){  /* Конструктор класса. Перегрузка.  */

        this.age =  age;
        this.name = name;
    }

    public void printAgeName() {

        System.out.printf("Возраст кота-age = %d  Имя кота-name = %s \n", this.age, this.name);
    }

    public void setAge(int age) {

        this.age =  age;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getAge() {

        return this.age;
    }

    public String getName() {

        return this.name;
    }

    @Override
    public boolean equals(Object obj) { /* Сравнивает один объект с другим. Значения полей-перемнных однго объекта равно значению полей-перемнных другого объкта */

        /* this требуется для того, чтобы метод мог сослаться на вызвавший его объект */
        if (this == obj) { /* Если настоящий экземпляр класса - это экземпляр класса Object.   */
            //System.out.printf("\n№1\n");
            return true;
        }

        if ( (obj == null) || (obj.getClass() != this.getClass()) ) { /* Убеждаемся что разные объекты относятся к одному и томуже классу */
            //System.out.printf("\n№2\n");
            return false;
        }

        CatTask4 cat = (CatTask4) obj; // Приводим явно тип объекта obj к типу объекта cat и присваиваем значения.
        //System.out.printf("\n№3\n %d = %d --- %s = %s \n", this.age, cat.age, this.name, cat.name );
        return ( this.age == cat.age ) && ( this.name.equals(cat.name) );
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.age, this.name);
    }

    @Override
    public String toString() { /* Строковое предсатвление объекта. */
        return "Метод toString():" + " { age = " + this.age +", name = " + this.name + " }";
    }

}

/*
Нужно переопределить hashCode() метод, если класс переопределяет equals().
Если equals() возвращает true для двух объектов, затем hashCode() метод также должен возвращать то же значение,
т. е. если a.equals(b) == true а также b.equals(a) == true, тогда a.hashCode() == b.hashCode().
Если equals() возвращает false для двух объектов, тогда hashCode() метод должен возвращать разные значения, т.е.
если a.equals(b) == false или же b.equals(a) == false, тогда a.hashCode() != b.hashCode().
*/
