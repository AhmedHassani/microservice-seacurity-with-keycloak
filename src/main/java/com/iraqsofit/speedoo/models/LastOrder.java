package com.iraqsofit.speedoo.models;


import java.util.List;

public class LastOrder {
    private long id;
    private String username;
    private int orderStatus;
    private String address;
    private String date;
    private double totalPrice;
    private double discount;
    private double price;

    private String massage;
    private List<ProductsModel> productsModel;

    public LastOrder(long id, String username, int orderStatus, String address,
                     String date, double totalPrice, double discount,
                     double price, List<ProductsModel> productsModel,
                     String massage
    ) {
        this.id = id;
        this.username = username;
        this.orderStatus = orderStatus;
        this.address = address;
        this.date = date;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.price = price;
        this.productsModel = productsModel;
        this.massage =massage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<ProductsModel> getProductsModel() {
        return productsModel;
    }

    public void setProductsModel(List<ProductsModel> productsModel) {
        this.productsModel = productsModel;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
