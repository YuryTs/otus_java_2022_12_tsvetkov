package cvetkov.homework.creational.builder.shortbuilder;

public class MainCarShortDemo {
    public static void main(String[] args) {
        CarShortDemo carShortDemo = new CarShortDemo.Builder() //создаем объект через внутренний класс (.) Если поле не будет задано то оно будет null или 0
                .setMarka("Opel")
                .setChassis("JCAE34O")
                .setColor("RED")
                .setYear(23)
                .build();
        System.out.println(carShortDemo);
    }
}
