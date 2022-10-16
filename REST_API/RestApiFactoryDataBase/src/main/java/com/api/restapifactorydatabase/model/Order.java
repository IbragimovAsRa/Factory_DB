package com.api.restapifactorydatabase.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orders")
    private Long id;
    @Column(name = "order_date")
    private Date order_date;
    @Column(name = "manager")
    private String manager;

    @Column(name = "price_order")
    private int price_order;
    @Column(name = "price_delivery")
    private int price_delivery;


    public Order(Date order_date, String manager, int price_order, int price_delivery) {
        this.order_date = order_date;
        this.manager = manager;
        this.price_order = price_order;
        this.price_delivery = price_delivery;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", order_date=" + order_date +
                ", manager='" + manager + '\'' +
                ", price_order=" + price_order +
                ", price_delivery=" + price_delivery +
                '}';
    }

    public Order() {

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

    public Date getOrder_date() {
        return order_date;
    }

    public String getManager() {
        return manager;
    }

    public int getPrice_order() {
        return price_order;
    }

    public int getPrice_delivery() {
        return price_delivery;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
