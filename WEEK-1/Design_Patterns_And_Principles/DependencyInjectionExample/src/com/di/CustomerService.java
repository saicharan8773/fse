package com.di;

public class CustomerService {
    private CustomerRepository customerRepository;

    // Constructor Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerDetails(String id) {
        return customerRepository.findCustomerById(id);
    }
}
