package com.crudspring.CRUD_Spring.controller;

import com.crudspring.CRUD_Spring.entity.Customer;
import com.crudspring.CRUD_Spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.CreateCustomer(customer);

    }

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        Customer customer = customerService.getCustomerbYId(id);
        if (customer== null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,
    @RequestBody Customer customer){
        Customer existingcustomer = customerService.getCustomerbYId(id);
        if (existingcustomer== null)
            return ResponseEntity.notFound().build();
        existingcustomer.setName(customer.getName());
        existingcustomer.setEmail(customer.getEmail());
        existingcustomer.setPhone(customer.getPhone());
        Customer updateCustomer = customerService.updateCustomer(existingcustomer);
        return ResponseEntity.ok(updateCustomer);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        Customer existingCustomer = customerService.getCustomerbYId(id);
        if (existingCustomer == null)
            return ResponseEntity.notFound().build();
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }

}
