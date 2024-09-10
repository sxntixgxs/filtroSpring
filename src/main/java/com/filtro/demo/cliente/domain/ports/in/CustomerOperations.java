package com.filtro.demo.cliente.domain.ports.in;

import java.util.List;
import java.util.Optional;

import com.filtro.demo.cliente.domain.models.Customer;

public interface CustomerOperations {
    Customer createCustomer(Customer customer);
    Optional<Customer> updateCustomer(Customer customer);
    Optional<Customer> getCustomerById(Integer id);
    List<Customer> getAllCustomers();
    boolean deleteCustomerById(Integer id);
}
