package com.example.ProjectKart.Repository;

import com.example.ProjectKart.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    public Customer findByNumber(int contact);
}
