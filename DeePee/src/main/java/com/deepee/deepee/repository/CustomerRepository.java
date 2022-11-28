package com.deepee.deepee.repository;

import com.deepee.deepee.entity.Customer;
import com.deepee.deepee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findUserByEmail(String email);

}
