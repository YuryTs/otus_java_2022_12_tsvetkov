package cvetkov.homework.bridge;

public class SolutionBridge {
    public static void main(String[] args) {
        var shape1 = new Circle(new GreenColor());
        var shape2 = new Rectangle(new RedColor());
        var shape3 = new Triangle(new GreenColor());
        var shape4 = new Circle(new RedColor());

        shape1.infoShape();
        shape2.infoShape();
        shape3.infoShape();
        shape4.infoShape();


    }
}
