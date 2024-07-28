package com.di;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(String id) {
        // Simulate fetching customer data from a database
        return new Customer(id, "SAICHARAN8773", "saicharan8773@gmail.com");
    }
}
