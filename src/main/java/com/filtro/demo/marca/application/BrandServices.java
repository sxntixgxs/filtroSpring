package com.filtro.demo.marca.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filtro.demo.marca.domain.models.Brand;
import com.filtro.demo.marca.domain.ports.in.BrandOperations;
import com.filtro.demo.marca.domain.ports.out.BrandRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BrandServices implements BrandOperations{
    @Autowired
    private BrandRepository repository;

    @Override
    public Brand createBrand(Brand brand) {
       return repository.save(brand);
    }

    @Override
    public Optional<Brand> updateBrand(Brand brand) {
        Optional<Brand> brandOptional = repository.findById(brand.getId());
        if(brandOptional.isPresent()){
            return Optional.of(repository.save(brand));
        }else{
            return Optional.empty();
        }
    }

    @Override
    public Optional<Brand> getBrandById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Brand> getAllBrands() {
        return repository.findAll();
    }

    @Override
    public boolean deleteBrandById(Integer id) {
        Optional<Brand> brandOptional = repository.findById(id);
        if(brandOptional.isPresent()){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
