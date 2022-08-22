package com.example.demo.CustomerRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
