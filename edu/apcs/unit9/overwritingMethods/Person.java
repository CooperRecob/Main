package edu.apcs.unit9.overwritingMethods;

public class Person {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {
        age = 4;
        name = "John";
    }

    public String toString() {
        return "Person[age=" + age + ", name=" + name + "]";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}