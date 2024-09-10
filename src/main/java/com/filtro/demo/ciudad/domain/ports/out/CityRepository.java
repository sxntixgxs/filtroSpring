package com.filtro.demo.ciudad.domain.ports.out;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filtro.demo.ciudad.domain.models.City;

public interface CityRepository extends JpaRepository<City,Integer>{
}
