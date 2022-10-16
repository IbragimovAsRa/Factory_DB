package com.api.restapifactorydatabase.model;

import javax.persistence.*;

@Entity
@Table(name = "materials")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materials")
    private Long id;
    @Column(name = "material_name")
    private String material_name;
    @Column(name = "unit_price")
    private int unit_price;

    public Material(String material_name, int unit_price) {
        this.material_name = material_name;
        this.unit_price = unit_price;
    }

    public Material() {
    }

    public Long getId() {
        return id;
    }

    public String getMaterial_name() {
        return material_name;
    }

    public int getUnit_price() {
        return unit_price;
    }

    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
    }

    public void setUnit_price(int unit_price) {
        this.unit_price = unit_price;
    }
}
