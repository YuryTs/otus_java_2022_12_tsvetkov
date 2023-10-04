package cvetkov.homework.decorator;


import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        var order = new OrderImpl(new ArrayList<>());
        Dish dish = new Dish(56, "barbecue");

        order.addDish(dish);
        order.getBill();

    //использование декоратора orderSale над классом OrderImpl
        var orderWithSale = new OrderWithSale(order);
        orderWithSale.getBill();
        orderWithSale.addDish(new Dish(3000, "soup"));

        orderWithSale.getBill();

        var orderExtraDish = new OrderExtraDish(order);
        orderExtraDish.addDish(dish);
        order.getBill();
    }
}
