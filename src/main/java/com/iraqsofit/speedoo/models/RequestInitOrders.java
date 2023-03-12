package com.iraqsofit.speedoo.models;
import java.util.Date;
import java.util.List;


public class RequestInitOrders {
    private String username;

    private String discountCode;

    private long addressId;

    private Date date;

    private String note;

    private List<OrdersProducts> productsList;

    public RequestInitOrders(String username, String discountCode, long addressId, List<OrdersProducts> productsList,String note) {
        this.username = username;
        this.discountCode = discountCode;
        this.addressId = addressId;
        this.date = new Date();
        this.productsList = productsList;
        this.note =note;
    }

    public RequestInitOrders() {
        date =new Date();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<OrdersProducts> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<OrdersProducts> productsList) {
        this.productsList = productsList;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}


