package com.api.restapifactorydatabase.controller;

import com.api.restapifactorydatabase.model.Material;
import com.api.restapifactorydatabase.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/material/")
public class MaterialRestController {
    private final MaterialService materialService;

    @Autowired
    public MaterialRestController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping(path ="")
    public List<Material> getAllMaterials() {

        return materialService.getAll();
    }
    @GetMapping(path = "{id}")
    public Material getMaterialById(@PathVariable(name = "id") Long id) {
        return materialService.getById(id);
    }
    @PostMapping(path = "",consumes="application/json")
    public ResponseEntity saveMaterial(@RequestBody Material material) {
        System.out.println(material.toString());
        materialService.save(material);
        return  ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping(path = "{id}")
    public ResponseEntity deleteMaterial(@PathVariable(name = "id") Long id) {
        materialService.delete(id);
        return  ResponseEntity.ok(HttpStatus.OK);
    }

}

