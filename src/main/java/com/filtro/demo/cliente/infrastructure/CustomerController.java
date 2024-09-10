package com.filtro.demo.cliente.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.filtro.demo.ciudad.application.CityServices;
import com.filtro.demo.ciudad.domain.models.City;
import com.filtro.demo.cliente.application.CustomerServices;
import com.filtro.demo.cliente.domain.dto.CustomerRequest;
import com.filtro.demo.cliente.domain.models.Customer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerServices services;
    @Autowired
    private CityServices cityServices;
    @GetMapping
    public List<Customer> getCustomers(){
        return services.getAllCustomers();
    }
    @PostMapping
    public String creeateCustomer(@RequestBody CustomerRequest customer){
        Optional<City> cityExists = cityServices.getCityById(customer.getCity_id());
        if(cityExists.isPresent()){
            Customer createdCustomer = new Customer();
            createdCustomer.setCity(cityExists.get());
            createdCustomer.setEmail(customer.getEmail());
            createdCustomer.setName(customer.getName());
            createdCustomer.setPassword(customer.getPasssword());
            createdCustomer.setPhone(customer.getPhone());
            services.createCustomer(createdCustomer);
            return "created";
        }else{
            return "city not found";
        }
    }
    @PutMapping
    public String updateCustomer(@RequestBody Customer customer){
        Optional<Customer> optionalCustomer = services.getCustomerById(customer.getId());
        Optional<City> optionalCity = cityServices.getCityById(customer.getCity().getId());
        if(optionalCity.isPresent() && optionalCustomer.isPresent()){
            services.updateCustomer(customer);
            return "customer updated";
        }else{
            return "cannot update";
        }
    }
    @DeleteMapping("/{id}")
    public String deleteCustomer(@RequestParam Integer id){
        return services.deleteCustomerById(id) ? "deleted" : "not deleted";
    }
}
