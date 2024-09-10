package com.filtro.demo.pais.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filtro.demo.pais.domain.models.Country;
import com.filtro.demo.pais.domain.ports.in.CountryOperations;
import com.filtro.demo.pais.domain.ports.out.CountryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CountryService implements CountryOperations{
    @Autowired
    private CountryRepository repository;

    @Override
    public Country create(Country country) {
        return repository.save(country);
    }

    @Override
    public Optional<Country> update(Country country) {
        Optional<Country> countryExists = repository.findById(country.getId());
        if(countryExists.isPresent()){
            return Optional.of(repository.save(country));
        }else{
            return Optional.empty();
        }
    }

    @Override
    public Optional<Country> getCountryById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Country> getAllCountry() {
        return repository.findAll();
    }

    @Override
    public boolean deleteCountryById(Integer id) {
        Optional<Country> countryExists = repository.findById(id);
        if(countryExists.isPresent()){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
