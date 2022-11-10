package entity;

import java.util.Date;

public class Order {
    int id_orders;
    Date order_date;
    String manager;
    int price_order;
    int price_delivery;

    public Order(int id_orders, Date order_date, String manager, int price_order, int price_delivery) {
        this.id_orders = id_orders;
        this.order_date = order_date;
        this.manager = manager;
        this.price_order = price_order;
        this.price_delivery = price_delivery;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return '\n' + "Order {" +
                "id_orders = " + id_orders +
                "  order_date = " + order_date +
                "  manager = '" + manager + '\'' +
                "  price_order = " + price_order +
                "  price_delivery = " + price_delivery +
                '}';
    }

    public void setId_orders(int id_orders) {
        this.id_orders = id_orders;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setPrice_order(int price_order) {
        this.price_order = price_order;
    }

    public void setPrice_delivery(int price_delivery) {
        this.price_delivery = price_delivery;
    }

    public int getId_orders() {
        return id_orders;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public String getManager() {
        return manager;
    }

    public int getPrice_order() {
        return price_order;
    }

    public int getPrice_delivery(int priceDelivery) {
        return price_delivery;
    }
}
