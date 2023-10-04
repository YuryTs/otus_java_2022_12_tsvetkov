package cvetkov.homework.bridge;

public abstract class Shape {

    private final Color color;

    public Shape(Color color) {
        this.color = color;
    }


    void infoShape(){
        System.out.println(shapeType() + color.getColor() );
    }

    protected abstract String shapeType();

}
