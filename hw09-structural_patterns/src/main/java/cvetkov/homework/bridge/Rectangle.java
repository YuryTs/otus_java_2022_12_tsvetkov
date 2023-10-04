package cvetkov.homework.bridge;

public class Rectangle extends Shape{
    public Rectangle(Color color) {
        super(color);
    }

    @Override
    protected String shapeType() {
       return "Retrangle - ";
    }


}
