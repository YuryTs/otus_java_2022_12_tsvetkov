package homework;


import java.util.ArrayDeque;

public class CustomerReverseOrder {
    private ArrayDeque<Customer> customersDeque = new ArrayDeque<>();

    public void add(Customer customers) {
        customersDeque.add(customers);
    }

    public Customer take() {
        return customersDeque.pollLast();
    }
}
