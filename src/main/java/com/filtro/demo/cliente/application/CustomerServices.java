package com.filtro.demo.cliente.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filtro.demo.cliente.domain.models.Customer;
import com.filtro.demo.cliente.domain.ports.in.CustomerOperations;
import com.filtro.demo.cliente.domain.ports.out.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor 
@Service
public class CustomerServices implements CustomerOperations{
    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Optional<Customer> updateCustomer(Customer customer) {
        Optional<Customer> customerExists = repository.findById(customer.getId());
        if(customerExists.isPresent()){
            return Optional.of(repository.save(customer));
        }else{
            return Optional.empty();
        }
    }

    @Override
    public Optional<Customer> getCustomerById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public boolean deleteCustomerById(Integer id) {
        Optional<Customer> customerExists = repository.findById(id);
        if(customerExists.isPresent()){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
