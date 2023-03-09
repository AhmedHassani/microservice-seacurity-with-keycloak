package com.iraqsofit.speedoo.models;

public class OrdersProducts {
    private int id;
    private String name;
    private int quantity;

    public OrdersProducts() {
    }

    public OrdersProducts(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
