package com.filtro.demo.sales.infrastructure;

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

import com.filtro.demo.cliente.application.CustomerServices;
import com.filtro.demo.cliente.domain.models.Customer;
import com.filtro.demo.sales.application.SalesServices;
import com.filtro.demo.sales.domain.dto.SalesRequest;
import com.filtro.demo.sales.domain.models.Sales;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/sales")
public class SalesController {
    @Autowired
    private SalesServices services;
    @Autowired
    private CustomerServices customerServices;
    @GetMapping
    public List<Sales> getSales(){
        return services.getAllSales();
    }
    @PostMapping
    public String createSales(@RequestBody SalesRequest sales){
        Optional<Customer> customerExists = customerServices.getCustomerById(sales.getCustomer_id());
        if(customerExists.isPresent()){
            Sales createdSales = new Sales();
            createdSales.setCustomer(customerExists.get());
            createdSales.setDate(sales.getDate());
            services.createSales(createdSales);
            return "created";
        }else{
            return "not created";
        }
    }
    @PutMapping
    public String updateSales(@RequestBody Sales sales){
        Optional<Sales> salesExists = services.getSalesById(sales.getId());
        Optional<Customer> customerExists = customerServices.getCustomerById(sales.getCustomer().getId());
        if(salesExists.isPresent() && customerExists.isPresent()){
            services.updateSales(sales);
            return "updated";
        }else{
            return "not updated;";
        }
    }
    @DeleteMapping("/{id}")
    public String deleteSales(@RequestParam Integer id){
        return services.deleteSalesById(id) ? "deleted" : "not deleted";
    }
}
