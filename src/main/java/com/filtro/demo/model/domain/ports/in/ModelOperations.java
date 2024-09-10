package com.filtro.demo.model.domain.ports.in;

import java.util.List;
import java.util.Optional;

import com.filtro.demo.model.domain.models.Model;

public interface ModelOperations {
    Model createModel(Model model);
    Optional<Model> updateModel(Model model);
    Optional<Model> getModelById(Integer id);
    List<Model> getAllModels();
    boolean deleteModelById();
}
