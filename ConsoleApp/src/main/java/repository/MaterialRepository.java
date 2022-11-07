package repository;

import entity.Material;

import java.util.List;

public interface MaterialRepository {
    Material getById(int materialId);
    List<Material> getAll();

}
