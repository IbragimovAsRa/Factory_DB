package com.api.restapifactorydatabase.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long id;

    @Column(name = "product_name")
    private String product_name;
    @Column(name = "production_time")
    private int product_time;

    public Product() {
    }

    public Product(String product_name, int product_time) {
        this.product_name = product_name;
        this.product_time = product_time;
    }

    public Long getId() {
        return id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public int getProduct_time() {
        return product_time;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_time(int product_time) {
        this.product_time = product_time;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", product_name='" + product_name + '\'' +
                ", product_time=" + product_time +
                '}';
    }
}
