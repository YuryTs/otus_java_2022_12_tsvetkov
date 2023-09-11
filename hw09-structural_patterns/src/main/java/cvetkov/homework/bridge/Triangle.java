package cvetkov.homework.bridge;

public class Triangle extends Shape{

    public Triangle(Color color) {
        super(color);
    }

    @Override
    protected String shapeType() {
        return "Triangle - ";
    }


}
