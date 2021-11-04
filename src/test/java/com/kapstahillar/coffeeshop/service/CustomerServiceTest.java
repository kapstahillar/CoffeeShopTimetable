package com.kapstahillar.coffeeshop.service;

import com.kapstahillar.coffeeshop.model.Customer;
import com.kapstahillar.coffeeshop.repo.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @Autowired
    @InjectMocks
    private CustomerService customerService;
    private Customer customer1;

    @BeforeEach
    public void setUp() {
        customer1 = new Customer();
    }
    @AfterEach
    public void tearDown() {
        customer1 = null;
    }

    @Test
    void registerACustomer() {
        when(customerRepository.save(any())).thenReturn(customer1);
        customerService.registerCustomer(customer1);
        verify(customerRepository, times(1)).save(any());
    }

    @Test
    void validateNewCustomer() {
        customerRepository.deleteAll();
        assertTrue(customerService.validateNewCustomer(customer1));
    }
}