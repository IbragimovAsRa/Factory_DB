package entity;

public class Equipment {
    int id;
    String equipment_name;
    int guaranty_period;
    int period_of_exploitation;
    int work_resource;
    int exploitation_resource;
    int equipment_price;

    public Equipment(int id, String equipment_name, int guaranty_period, int period_of_exploitation, int work_resource, int exploitation_resource, int equipment_price) {
        this.id = id;
        this.equipment_name = equipment_name;
        this.guaranty_period = guaranty_period;
        this.period_of_exploitation = period_of_exploitation;
        this.work_resource = work_resource;
        this.exploitation_resource = exploitation_resource;
        this.equipment_price = equipment_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquipment_name() {
        return equipment_name;
    }

    public void setEquipment_name(String equipment_name) {
        this.equipment_name = equipment_name;
    }

    public int getGuaranty_period() {
        return guaranty_period;
    }

    public void setGuaranty_period(int guaranty_period) {
        this.guaranty_period = guaranty_period;
    }

    public int getPeriod_of_exploitation() {
        return period_of_exploitation;
    }

    public void setPeriod_of_exploitation(int period_of_exploitation) {
        this.period_of_exploitation = period_of_exploitation;
    }

    public int getWork_resource() {
        return work_resource;
    }

    public void setWork_resource(int work_resource) {
        this.work_resource = work_resource;
    }

    public int getExploitation_resource() {
        return exploitation_resource;
    }

    public void setExploitation_resource(int exploitation_resource) {
        this.exploitation_resource = exploitation_resource;
    }

    public int getEquipment_price() {
        return equipment_price;
    }

    public void setEquipment_price(int equipment_price) {
        this.equipment_price = equipment_price;
    }

    @Override
    public String toString() {
        return "\n\n" +
                "id=" + id +
                ", equipment_name = '" + equipment_name + '\'' +
                ", guaranty_period = " + guaranty_period +
                ", period_of_exploitation = " + period_of_exploitation +
                ", work_resource = " + work_resource +
                ", exploitation_resource = " + exploitation_resource +
                ", equipment_price = " + equipment_price ;
    }
}
