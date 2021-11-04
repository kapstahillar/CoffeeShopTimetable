package com.kapstahillar.coffeeshop.service;

import com.kapstahillar.coffeeshop.model.Customer;
import com.kapstahillar.coffeeshop.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    // Adds new customer to database if passes validation
    // otherwise sends back old customer reference
    public Customer registerCustomer(Customer customer) {
        if (validateNewCustomer(customer)) {
            return customerRepository.save(customer);
        }
        return customer;
    }

    // Validates new customer
    // Only validation here is, if it is not already in customer repository.
    public boolean validateNewCustomer(Customer customer) {
        return !(customerRepository.findAll().contains(customer));
    }
}
