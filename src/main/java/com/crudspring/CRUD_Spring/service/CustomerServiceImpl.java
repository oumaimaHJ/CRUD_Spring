package com.crudspring.CRUD_Spring.service;

import com.crudspring.CRUD_Spring.entity.Customer;
import com.crudspring.CRUD_Spring.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer CreateCustomer(Customer c) {
        return customerRepository.save(c);

    }

    @Override
    public Customer getCustomerbYId(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomer(Long id) {
          customerRepository.deleteById(id);
    }

    @Override
    public Customer updateCustomer(Customer c) {
        return customerRepository.save(c);


    }


}
