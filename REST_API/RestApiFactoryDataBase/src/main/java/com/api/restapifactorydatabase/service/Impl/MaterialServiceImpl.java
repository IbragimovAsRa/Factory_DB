package com.api.restapifactorydatabase.service.Impl;

import com.api.restapifactorydatabase.model.Material;
import com.api.restapifactorydatabase.repository.MaterialRepository;
import com.api.restapifactorydatabase.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialServiceImpl implements MaterialService {
    private final MaterialRepository materialRepository;

    @Autowired
    public MaterialServiceImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public Material getById(Long id) {
        Material result = materialRepository.findById(id).orElse(null);
        return result;
    }

    @Override
    public List<Material> getAll() {
        List<Material> result = materialRepository.findAll();
        return result;
    }

    @Override
    public Material save(Material material) {
        return materialRepository.save(material);
    }
    @Override
    public void delete(Long id) { materialRepository.deleteById(id);}

}
