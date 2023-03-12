package com.iraqsofit.speedoo.models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false,name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "statesOrder")
    private String statesOrder;

    @Column(name = "addressId")
    private long addressId;


    @Column(name = "date")
    private String date;

    @Column(name = "totalPrice")
    private double totalPrice;

    @Column(name = "discountCode")
    private String discountCode;

    @Column(name = "price")
    private double price;

    @Column(name = "massage")
    private String massage;


    @Column(name = "paymentType")
    private String paymentType;

    @Column(name = "zcImage")
    private String zcImage;

    @Column(name = "note")
    private String note;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    public Orders(String username, String statesOrder, long addressId, String date, double totalPrice, String discountCode, double price, String massage,String note) {
        this.username = username;
        this.statesOrder = statesOrder;
        this.addressId = addressId;
        this.date = date;
        this.totalPrice = totalPrice;
        this.discountCode = discountCode;
        this.price = price;
        this.massage = massage;
        this.note=note;
    }

    public Orders() {
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

    public String getStatesOrder() {
        return statesOrder;
    }

    public void setStatesOrder(String statesOrder) {
        this.statesOrder = statesOrder;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
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

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getZcImage() {
        return zcImage;
    }

    public void setZcImage(String zcImage) {
        this.zcImage = zcImage;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
