package cvetkov.homework.decorator;

import java.util.ArrayList;
import java.util.List;

public class OrderImpl implements Order {

    static private int NUMBER;
    private List<Dish> dishList = new ArrayList<>();

    public OrderImpl(List<Dish> dishList) {
        this.dishList = dishList;
        NUMBER++;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public int getNumberOrder() {
        return NUMBER;
    }

    @Override
    public void getBill() {
        int bilt = 0;
        for (Dish dish: dishList){
            int cost = dish.getCost();
            bilt = bilt + cost;
        }

        System.out.println("Ваш заказ = "+ dishList.toString() + "\n" + "Общая сумма заказа = " + bilt + "\n");
    }

    public void addDish(Dish dish) {
        if(dish != null){
            dishList.add(dish);
        }

    }

    public void deleteDish(Dish dish) {
        if(dishList.contains(dish)){
            dishList.remove(dish);
        }

    }
}
