package com.filtro.demo.pais.domain.ports.in;

import java.util.List;
import java.util.Optional;

import com.filtro.demo.pais.domain.models.Country;

public interface CountryOperations{
    Country create(Country country);
    Optional<Country> update(Country country);
    Optional<Country> getCountryById(Integer id);
    List<Country> getAllCountry();
    boolean deleteCountryById(Integer id);
}
