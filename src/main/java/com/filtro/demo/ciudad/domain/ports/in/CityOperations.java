package com.filtro.demo.ciudad.domain.ports.in;

import java.util.List;
import java.util.Optional;

import com.filtro.demo.ciudad.domain.models.City;

public interface CityOperations {
    City create(City city);
    Optional<City> update(City city);
    List<City> getAllCity();
    boolean deleteCityById(Integer id);
    Optional<City> getCityById(Integer id);
}
