package com.kapstahillar.coffeeshop.repo;

import com.kapstahillar.coffeeshop.model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;
    private Customer testCustomer;

    @BeforeEach
    public void setUp() {
        testCustomer = new Customer();
    }
    @AfterEach
    public void tearDown() {
        customerRepository.deleteAll();
        testCustomer = null;
    }

    @Test
    public void givenCustomerShouldReturnAddedCustomer() {
        customerRepository.save(testCustomer);
        Customer fetchedCustomer = customerRepository.findById(testCustomer.getId()).get();
        assertEquals(1, fetchedCustomer.getId());
    }
}