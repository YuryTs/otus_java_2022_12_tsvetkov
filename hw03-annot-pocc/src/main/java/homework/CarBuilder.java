package homework;

public class CarBuilder {
    private String model;
    private String color;
    private int age;

    public CarBuilder(String model, String color, int age) {
        this.model = model;
        this.color = color;
        this.age = age;
    }

    public CarBuilder model(String value){
        model = value;
        return this;
    }
    public CarBuilder color(String value){
        color = value;
        return this;
    }
    public CarBuilder age(int value){
        age = value;
        return this;
    }
    public Car build(){
        return new Car(model, color, age);
    }
}
