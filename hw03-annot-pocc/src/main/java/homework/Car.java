package homework;

public class Car {
    private String model;
    private String color;
    private int age;

    public Car(String model, String color, int age) {
    }
//    public Car(String model, String color, int age) {
//        this.model;
//        this.color;
//        this.age
//    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    @BuilderProperty
    @Override
    public String toString() {
        return "Car{" +
                "age=" + age +
                ", color='" + color + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
