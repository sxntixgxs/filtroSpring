package com.filtro.demo.marca.infrastructure;

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

import com.filtro.demo.marca.application.BrandServices;
import com.filtro.demo.marca.domain.models.Brand;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/brand")
public class BrandController {
    @Autowired
    private BrandServices services;
    @GetMapping
    public List<Brand> getBrands(){
        return services.getAllBrands();
    }
    @PostMapping
    public String createBrand(@RequestBody Brand brand){
        services.createBrand(brand);
        return "created";
    }
    @PutMapping
    public String updateBrand(@RequestBody Brand brand){
        Optional<Brand> brandExists = services.getBrandById(brand.getId());
        if(brandExists.isPresent()){
            services.updateBrand(brand);
            return "updated";
        }else{
            return "not updated";
        }
    }
    @DeleteMapping("/{id}")
    public String deleteBrand(@RequestParam Integer id){
        return services.deleteBrandById(id) ? "deleted" : "not deleted";
    }
}
