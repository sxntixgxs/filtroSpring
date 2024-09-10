package com.filtro.demo.marca.domain.ports.out;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filtro.demo.marca.domain.models.Brand;

public interface BrandRepository extends JpaRepository<Brand,Integer>{

}
