package cvetkov.homework.creational.builder.classicalbuilder;

import lombok.Getter;

@Getter
public class CarBuilderImpl implements CarBuilder{
    private String marka;
    private String chassis;
    private String color;
    private int year;



    @Override
    public Car build() {
        return new Car(marka, chassis, color, year);
    }
    @Override
    public CarBuilder setMarka(String marka) {
        this.marka = marka;
        return this;
    }

    @Override
    public CarBuilder setChassis(String chassis) {
        this.chassis = chassis;
        return this;
    }

    @Override
    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public CarBuilder setYear(int year) {
        this.year = year;
        return this;
    }

    @Override
    public String toString() {
        return "CarBuilderImpl{" +
                "marka='" + marka + '\'' +
                ", chassis='" + chassis + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                '}';
    }
}
