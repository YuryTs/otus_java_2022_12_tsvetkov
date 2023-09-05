package cvetkov.homework.creational.builder.classicalbuilder;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
//@RequiredArgsConstructor //обеспечивает создание конструктора со всеми финальными полями

public final class Car { //создаем финальный класс с финальными полями с геттерами и конструктором из финальных полей
    private final String marka;
    private final String chassis;
    private final String color;
    private final int year;

    public Car(String marka, String chassis, String color, int year) {
        this.marka = marka;
        this.chassis = chassis;
        this.color = color;
        this.year = year;
    }
}

