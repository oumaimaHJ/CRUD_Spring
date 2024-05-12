package com.crudspring.CRUD_Spring.service;

import com.crudspring.CRUD_Spring.entity.Customer;


import java.util.List;


public interface CustomerService {
    public Customer getCustomerbYId(Long id);
    public List<Customer> getAllCustomer();
    public void deleteCustomer(Long id);
    public Customer updateCustomer(Customer c);
    public Customer CreateCustomer(Customer c);

}
