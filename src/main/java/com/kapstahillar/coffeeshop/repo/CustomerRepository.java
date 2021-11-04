package com.kapstahillar.coffeeshop.repo;

import com.kapstahillar.coffeeshop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

