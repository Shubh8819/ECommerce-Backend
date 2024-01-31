package com.Springbootecommerce.Repos;

import com.Springbootecommerce.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmail(String theEmail);
}