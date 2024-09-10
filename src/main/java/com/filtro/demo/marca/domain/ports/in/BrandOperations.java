package com.filtro.demo.marca.domain.ports.in;

import java.util.List;
import java.util.Optional;

import com.filtro.demo.marca.domain.models.Brand;

public interface BrandOperations {
    Brand createBrand(Brand brand);
    Optional<Brand> updateBrand(Brand brand);
    Optional<Brand> getBrandById(Integer id);
    List<Brand> getAllBrands();
    boolean deleteBrandById(Integer id);
}
