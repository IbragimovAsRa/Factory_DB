package com.api.restapifactorydatabase.model;

import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;

@Entity
@Table(name = "materials")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materials",nullable = false)
    private Long id;
    @Column(name = "material_name",nullable = false)
    private String material_name;
    @Column(name = "unit_price",nullable = false)
    private int unit_price;

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", material_name='" + material_name + '\'' +
                ", unit_price=" + unit_price +
                '}';
    }

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
