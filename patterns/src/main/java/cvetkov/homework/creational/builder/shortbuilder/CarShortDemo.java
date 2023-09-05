package cvetkov.homework.creational.builder.shortbuilder;

import lombok.Getter;

@Getter
//@Builder //с этой аннотацией все что после toString можно не писать
public final class CarShortDemo { //создаем финальный класс с финальными полями
    private final String marka;
    private final String chassis;
    private final String color;
    private final int year;

    private CarShortDemo(Builder builder){ //в конструктор передаем вложенный статический класс и из него забираем нужные поля
        this.marka = builder.marka;
        this.chassis = builder.chassis;
        this.color = builder.color;
        this.year = builder.year;
    }

    @Override
    public String toString() {
        return "CarShortDemo{" +
                "marka='" + marka + '\'' +
                ", chassis='" + chassis + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                '}';
    }

    public static  class Builder{ //создаем вложенный класс с приватными полями
        private  String marka;
        private  String chassis;
        private  String color;
        private  int year;

        public CarShortDemo build(){return new CarShortDemo(this);} //создаем метод билд в котором создаем наш объект
        public Builder setMarka(String marka) { //создаем сеттеры для установления полей
            this.marka = marka;
            return this;
        }

        public Builder setChassis(String chassis) {
            this.chassis = chassis;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

    }
}
