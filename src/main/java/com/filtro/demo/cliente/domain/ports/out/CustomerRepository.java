package com.filtro.demo.cliente.domain.ports.out;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filtro.demo.cliente.domain.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
