package cvetkov.homework.decorator;

public class OrderWithSale implements Order{

    private final OrderImpl order;

    public OrderWithSale(OrderImpl order) {
        this.order = order;
    }

    @Override
    public void getBill() {
        int bilt = 0;
        for (Dish dish: order.getDishList()){
            int cost = dish.getCost();
            bilt = bilt + cost/2;
        }

        System.out.println("Ваш заказ = "+ order.getDishList().toString() + "\n" + "Общая сумма заказа с учетом скидки = " + bilt + "\n");

    }

    @Override
    public void addDish(Dish dish) {
        order.addDish(dish);
    }

}
