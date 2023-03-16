package com.iraqsofit.speedoo.models;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "productId")
    private long productId;

    @Column(nullable = false,name = "name")
    private String name;

    @Column(nullable = false,name = "description" , columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false , name = "category")
    private String category;

    @Column(nullable = false,name = "price")
    private Double price;

    @Column(nullable = false,name = "discount")
    private Double discount;


    @Column(nullable = false,name = "image")
    private String image;


    @JoinColumn(name = "quantityItemInOrder")
    private int quantityItemInOrder;


    public OrderItem(long productId, String name, String description, String category, Double price, Double discount, String image, int quantityItemInOrder) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.discount = discount;
        this.image = image;
        this.quantityItemInOrder = quantityItemInOrder;
    }

    public OrderItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }


    public int getQuantityItemInOrder() {
        return quantityItemInOrder;
    }

    public void setQuantityItemInOrder(int quantityItemInOrder) {
        this.quantityItemInOrder = quantityItemInOrder;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}