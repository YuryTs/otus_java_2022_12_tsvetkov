package cvetkov.homework.behavioral.chain2;


public class Demo {
    public static void main(String[] args) {
        var appl = new Application();

        //три независимых этапа (три независимых объекта)
        var input = new ApplicationInput();
        var reader = new ApplicationReader();
        var reader2 = new ApplicationReader(); //можно добавить еще один этап
        var result = new ApplicationResult();

        input.setNext(reader); // после инпута пойдет реадер
        reader.setNext(reader2); // можно легко добавить еще один этап или переставить местами
        reader2.setNext(result); //после реадера пойдет резалт

        input.process(appl);
        appl.printHistory();
    }
}
