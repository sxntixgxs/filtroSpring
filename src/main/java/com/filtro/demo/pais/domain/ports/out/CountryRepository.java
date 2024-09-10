package com.filtro.demo.pais.domain.ports.out;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filtro.demo.pais.domain.models.Country;

public interface CountryRepository extends JpaRepository<Country,Integer>{
    
}
