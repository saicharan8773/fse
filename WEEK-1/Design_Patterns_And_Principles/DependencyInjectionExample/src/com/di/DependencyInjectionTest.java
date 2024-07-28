package com.di;

public class DependencyInjectionTest {
    public static void main(String[] args) {
        // Create an instance of CustomerRepositoryImpl
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the CustomerRepository into CustomerService
        CustomerService customerService = new CustomerService(customerRepository);

        // Use CustomerService to get customer details
        Customer customer = customerService.getCustomerDetails("21501A0529");
        System.out.println(customer);
    }
}
