package com.api.restapifactorydatabase.service;

import com.api.restapifactorydatabase.model.Material;

import java.util.List;
import java.util.Optional;

public interface MaterialService {
    Material getById(Long id);
    List<Material> getAll();
    Material save(Material material);
    void delete(Long id);
}
