package com.filtro.demo.ciudad.infrastructure;

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
import org.springframework.web.bind.annotation.RestController;

import com.filtro.demo.ciudad.application.CityServices;
import com.filtro.demo.ciudad.domain.dto.CityRequest;
import com.filtro.demo.ciudad.domain.models.City;
import com.filtro.demo.pais.domain.models.Country;
import com.filtro.demo.pais.domain.ports.out.CountryRepository;

@RestController
@RequestMapping("/api/city")
public class CityController {
    @Autowired
    private CityServices services;
    @Autowired
    private CountryRepository countryRepository;
    @GetMapping
    public List<City> getCities(){
        return services.getAllCity();
    }    
    @PostMapping
    public String createCity(@RequestBody CityRequest city){
        Optional<Country> countryExists = countryRepository.findById(city.getCountry_id());
        if(countryExists.isPresent()){
            City createdCity = new City();
            createdCity.setCountry(countryExists.get());
            createdCity.setName(city.getName());
            services.create(createdCity);
            return "saved succesfully";
        }else{
            return "non saved";
        }
    }
    @PutMapping("/{id}")
    public String updateCity(@RequestAttribute Integer idCountry, @RequestBody City city){
        Optional<Country> countryExists = countryRepository.findById(idCountry);
        if(countryExists.isPresent() ){
            Optional<City> updatedCity = services.update(city);
            return updatedCity.isPresent() ? "updated succesfully" : "not updated"; 
        }else{
            return "country does not found";
        }
    }
    @DeleteMapping("/{id}")
    public String deleteCity(@RequestAttribute Integer id){
        if(services.deleteCityById(id)){
            return "deleted";
        }else{
            return "not deleted";
        }
    }

}
