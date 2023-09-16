package cvetkov.serializExample.binary_for_java;

import java.io.Serializable;


public class Person implements Serializable {
    private static final long serialVersionUID = -8912204534725413640L;
    private int age;
    private String name;

//transient - не сериализуется
    private transient String hidden;

    public Person(int age, String name, String hidden) {
        this.age = age;
        this.name = name;
        this.hidden = hidden;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", hidden='" + hidden + '\'' +
                '}';
    }
}
