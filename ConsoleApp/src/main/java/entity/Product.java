package entity;

public class Product {
    int id_product;
    String product_name;
    int production_time;

    public Product() {
    }

    public Product(int id_product, String product_name, int production_time) {
        this.id_product = id_product;
        this.product_name = product_name;
        this.production_time = production_time;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduction_time(int production_time) {
        this.production_time = production_time;
    }

    public int getId_product() {
        return id_product;
    }

    public String getProduct_name() {
        return product_name;
    }

    public int getProduction_time() {
        return production_time;
    }

    @Override
    public String toString() {
        return "\n\n" +
                "id_product = " + id_product +
                ", product_name = '" + product_name + '\'' +
                ", production_time = " + production_time;
    }
}
