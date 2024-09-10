package com.filtro.demo.proveedor.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.filtro.demo.ciudad.application.CityServices;
import com.filtro.demo.ciudad.domain.models.City;
import com.filtro.demo.ciudad.domain.ports.out.CityRepository;
import com.filtro.demo.proveedor.application.SupplierServices;
import com.filtro.demo.proveedor.domain.dto.SupplierRequest;
import com.filtro.demo.proveedor.domain.models.Supplier;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    @Autowired
    private SupplierServices services;
    @Autowired
    private CityServices cityServices;
    @GetMapping
    public List<Supplier> getSuppliers(){
        return services.getAllSuppliers();
    }
    @PostMapping
    public String createSupplier(@RequestBody SupplierRequest supplier){
        Optional<City> cityExists = cityServices.getCityById(supplier.getCity_id());
        if(cityExists.isPresent()){
            Supplier createdSupplier = new Supplier();
            createdSupplier.setCity(cityExists.get());
            createdSupplier.setContact(supplier.getContact());
            createdSupplier.setEmail(supplier.getEmail());
            createdSupplier.setName(supplier.getName());
            services.createSupplier(createdSupplier);
            return "created";
        }else{
            return "city does not exists";
        }



    } 
    @PutMapping
    public String updateSupplier(@RequestBody Supplier supplier){
        Optional<Supplier> supplierExists = services.getSupplierById(supplier.getId());
        Optional<City> cityExists = cityServices.getCityById(supplier.getCity().getId());
        if(supplierExists.isPresent() && cityExists.isPresent()){
            services.updateSupplier(supplier);
            return "updated";
        }else{
            return "cannot update";
        }
    }
    @DeleteMapping("/{id}")
    public String deleteSupplier(@RequestParam Integer id){
        return services.deleteSupplierById(id) ? "deleted" : "not deleted";
    }

}
