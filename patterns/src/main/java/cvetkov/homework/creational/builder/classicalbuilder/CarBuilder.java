package cvetkov.homework.creational.builder.classicalbuilder;

public interface CarBuilder {
    CarBuilder setMarka(String marka);
    CarBuilder setChassis(String chassis);
    CarBuilder setColor(String color);
    CarBuilder setYear(int year);

    Car build();
}
