package JAVA_GLk_JC1_29_22.HomeTasks.task8.test;

import java.util.Objects;

public class Test1 {

    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Test1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Test1 test1)) return false;
        return age == test1.age && Objects.equals(name, test1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
