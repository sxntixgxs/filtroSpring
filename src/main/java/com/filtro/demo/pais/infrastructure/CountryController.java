package com.filtro.demo.pais.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.filtro.demo.pais.application.CountryService;
import com.filtro.demo.pais.domain.models.Country;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@AllArgsConstructor
@RestController
@RequestMapping("/api/country")
public class CountryController {
    @Autowired
    private CountryService services;
    @PostMapping
    public String createCountry(@RequestBody Country country) {
        services.create(country);
        return "Country saved succesfuly";
    }
    @PutMapping("/{id}")
    public String updateCountry(@RequestBody Country country,@RequestParam Integer id) {
        Optional<Country> updatedCountry = services.update(country);
        if(updatedCountry.isPresent()){
            return "updated succesfully";
        }else{
            return "non updated";
        }
    }
    @GetMapping
    public List<Country> getCountries(){
        return services.getAllCountry();
    }
    @DeleteMapping("/{id}")
    public String deleteCountry(@RequestParam Integer id){
        if(services.deleteCountryById(id)){
            return "deleted";
        }else{
            return "not found";
        }
    }
    
    
}
