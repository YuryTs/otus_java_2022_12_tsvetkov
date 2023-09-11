package cvetkov.homework.decorator;

public class OrderExtraDish implements Order{
    private final OrderImpl order;

    public OrderExtraDish(OrderImpl order) {
        this.order = order;
    }

    @Override
    public void getBill() {

    }

    @Override
    public void addDish(Dish dish) {
        if(dish != null){
            order.getDishList().add(dish);
            order.getDishList().add(dish);
        }

    }
}
