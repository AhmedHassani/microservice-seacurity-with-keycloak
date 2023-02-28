package com.iraqsofit.speedoo.models;


import javax.persistence.*;

@Entity
@Table(name = "localtion")
public class localtion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false,name = "id")
    private long id;

    private double lat;
    private double lon;

    public localtion(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public localtion() {
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
