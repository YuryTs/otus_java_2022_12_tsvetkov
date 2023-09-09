package cvetkov.homework.behavioral.command.data;

public class Charge {
    private final String description;

    private final int sum;

    public Charge(String description, int sum) {
        this.description = description;
        this.sum = sum;
    }

    public String getDescription() {
        return description;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "Charge{" +
                "description='" + description + '\'' +
                ", sum=" + sum +
                '}';
    }
}
