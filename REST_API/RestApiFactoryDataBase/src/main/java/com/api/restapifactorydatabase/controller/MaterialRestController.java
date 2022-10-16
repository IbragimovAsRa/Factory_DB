package com.api.restapifactorydatabase.controller;

import com.api.restapifactorydatabase.model.Material;
import com.api.restapifactorydatabase.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/material/")
public class MaterialRestController {
    private final MaterialService materialService;

    @Autowired
    public MaterialRestController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping("")
    public List<Material> getAllMaterials() {
        return materialService.getAll();
    }
    @GetMapping("{id}")
    public Material getMaterialById(@PathVariable(name = "id") Long id) {
        return materialService.getById(id);
    }
}
