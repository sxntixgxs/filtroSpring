package com.filtro.demo.model.domain.ports.out;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filtro.demo.model.domain.models.Model;

public interface ModelRepository extends JpaRepository<Model,Integer>{

}
