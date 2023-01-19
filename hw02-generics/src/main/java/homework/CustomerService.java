package homework;

import java.util.*;

public class CustomerService {

    TreeMap<Customer, String> customersTreeMap = new TreeMap<>();


    public Map.Entry<Customer, String> getSmallest() {
        Customer tempCustomer = new Customer(customersTreeMap.firstKey());
        return Map.entry(tempCustomer, customersTreeMap.get(tempCustomer));
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Customer crutchCustomer = customersTreeMap.higherKey(customer);
        return crutchCustomer != null ? Map.entry(new Customer(crutchCustomer), customersTreeMap.get(crutchCustomer)) : null;
    }

    public void add(Customer customer, String data) {
        customersTreeMap.put(customer, data);
    }
}
