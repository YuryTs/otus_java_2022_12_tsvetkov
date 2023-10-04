package cvetkov.homework.bridge;

public class Circle extends Shape{


    public Circle(Color color) {
        super(color);
    }

    @Override
    protected String shapeType() {
        return "Circle - ";
    }


}
