package cvetkov.homework.behavioral.command2;

public class SomeObject { //тот объект над которым будем работать
    private String value; //его поля

    public SomeObject(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SomeObject{" +
                "value='" + value + '\'' +
                '}';
    }
}
