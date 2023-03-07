package com.iraqsofit.speedoo.models;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false,name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "discountCode")
    private String discountCode;

    @Column(name = "statesOrder")
    private String statesOrder;



    public Orders() {
    }

    public Orders(String username, String discountCode, String statesOrder) {
        this.username = username;
        this.discountCode = discountCode;
        this.statesOrder = statesOrder;
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

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getStatesOrder() {
        return statesOrder;
    }

    public void setStatesOrder(String statesOrder) {
        this.statesOrder = statesOrder;
    }

}
