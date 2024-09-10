package com.filtro.demo.model.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.filtro.demo.model.application.ModelServices;
import com.filtro.demo.model.domain.models.Model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/model")
public class ModelController {
    @Autowired
    private ModelServices services;
    @GetMapping
    public List<Model> getModels(){
        return services.getAllModels();
    }
    @PostMapping
    public String createModel(@RequestBody Model model){
        services.createModel(model);
        return "created";
    }
    @PutMapping
    public String updateModel(@RequestBody Model model){
        Optional<Model> optional = services.getModelById(model.getId());
        if(optional.isPresent()){
            services.updateModel(model);
            return "updated";
        }else{
            return "not updated";
        }
    }
    @DeleteMapping("/{id}")
    public String deleteModel(@RequestParam Integer id){
        return services.deleteModelById(id) ? "deleted" : "not deleted";
    }
}
