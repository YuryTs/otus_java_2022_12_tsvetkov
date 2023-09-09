package cvetkov.homework.behavioral.visitor;

import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

        List<Element> elements = Arrays.asList(new Brake(), new Engine(), new Transmission());

        Visitor visitor = new CarService();
        elements.forEach(elem -> elem.accept(visitor));//выполняем к-л действия с этими элементами

    //    Visitor visitorVip = new CarServiceVip();
    //    elements.forEach(elem -> elem.accept(visitorVip));
    }
}
