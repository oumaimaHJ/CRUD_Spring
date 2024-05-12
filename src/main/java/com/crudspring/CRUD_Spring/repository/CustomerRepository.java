package com.crudspring.CRUD_Spring.repository;

import com.crudspring.CRUD_Spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
