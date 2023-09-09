package cvetkov.homework.behavioral.command.data;

import java.util.ArrayList;
import java.util.List;

public class Guest {

    private List<Charge> charges = new ArrayList<>();
    private int rentCost = 0;

    private final String name;

    public Guest(final String name) {
        this.name = name;
    }

    public void addCharge(Charge charge){
        charges.add(charge);
    }

    public List<Charge> getCharges() {
        return charges;
    }

    public int getRentCost() {
        return rentCost;
    }

    public String getName() {
        return name;
    }

    public void setRentCost(int rentCost) {
        this.rentCost = rentCost;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name +
                ", charges=" + charges +
                ", restCost=" + rentCost +
                '\'' +
                '}';
    }
}
