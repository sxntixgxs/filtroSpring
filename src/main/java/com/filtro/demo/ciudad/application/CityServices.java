package com.filtro.demo.ciudad.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filtro.demo.ciudad.domain.models.City;
import com.filtro.demo.ciudad.domain.ports.in.CityOperations;
import com.filtro.demo.ciudad.domain.ports.out.CityRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CityServices implements CityOperations{
    @Autowired
    private CityRepository repository;

    @Override
    public City create(City city) {
        return repository.save(city);
    }

    @Override
    public Optional<City> update(City city) {
        Optional<City> cityExists = repository.findById(city.getId());
        if(cityExists.isPresent()){
            return Optional.of(repository.save(city));
        }else{
            return Optional.empty();
        }
    }

    @Override
    public List<City> getAllCity() {
        return repository.findAll();
    }

    @Override
    public boolean deleteCityById(Integer id) {
        Optional<City> cityExists = repository.findById(id);
        if(cityExists.isPresent()){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Optional<City> getCityById(Integer id) {
        return repository.findById(id);
    }
}
