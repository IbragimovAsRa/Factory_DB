package entity;

public class Material {
    int id_materials;
    String material_name;
    int unit_price;

    public Material(int id_materials, String material_name, int unit_price) {
        this.id_materials = id_materials;
        this.material_name = material_name;
        this.unit_price = unit_price;
    }

    public int getId_materials() {
        return id_materials;
    }

    public void setId_materials(int id_materials) {
        this.id_materials = id_materials;
    }

    public String getMaterial_name() {
        return material_name;
    }

    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
    }

    public int getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(int unit_price) {
        this.unit_price = unit_price;
    }

    @Override
    public String toString() {
        return '\n'  +
                "  id_materials = " + id_materials +
                "  material_name = " + material_name + '\'' +
                "  unit_price = " + unit_price
                  ;
    }
}
