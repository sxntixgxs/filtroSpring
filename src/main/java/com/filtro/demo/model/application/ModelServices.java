package com.filtro.demo.model.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filtro.demo.model.domain.models.Model;
import com.filtro.demo.model.domain.ports.in.ModelOperations;
import com.filtro.demo.model.domain.ports.out.ModelRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ModelServices implements ModelOperations{
    @Autowired
    private ModelRepository repository;

    @Override
    public Model createModel(Model model) {
        return repository.save(model);
    }

    @Override
    public Optional<Model> updateModel(Model model) {
        Optional<Model> optional = repository.findById(model.getId());
        if(optional.isPresent()){
            return Optional.of(repository.save(model));
        }else{
            return Optional.empty();
        }
    }

    @Override
    public Optional<Model> getModelById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Model> getAllModels() {
        return repository.findAll();
    }

    @Override
    public boolean deleteModelById(Integer id) {
        Optional<Model> optional = repository.findById(id);
        if(optional.isPresent()){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
