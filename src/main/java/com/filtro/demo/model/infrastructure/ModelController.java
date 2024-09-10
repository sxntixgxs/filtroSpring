package com.filtro.demo.model.infrastructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
        return 
    }
}
